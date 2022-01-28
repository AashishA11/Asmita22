package com.example.asmita22.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asmita22.R;
import com.example.asmita22.TrixxterActivity;
import com.example.asmita22.databinding.FragmentResultsBinding;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ResultsFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    FragmentResultsBinding binding;
    String Result,eventName;
    public ResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding= FragmentResultsBinding.inflate(inflater,container,false);
        firebaseFirestore=FirebaseFirestore.getInstance();
        TrixxterActivity activity = (TrixxterActivity) getActivity();
        eventName = activity.getName();
        binding.getResult.setVisibility(View.INVISIBLE);
        DocumentReference reference=firebaseFirestore.collection("events").document(eventName);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Result=documentSnapshot.getString("Result");
                if(!Result.equals("-1")){
                    binding.getResult.setVisibility(View.VISIBLE);
                    binding.defaultResultIv.setVisibility(View.INVISIBLE);
                    binding.defaultResultTv.setVisibility(View.INVISIBLE);
                    ImageView imageView= binding.getRoot().findViewById(R.id.results);
                    Glide.with(getContext()).load(Result).into(imageView);
                    binding.getResult.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DownloadImage(Result);
                        }
                    });
                }
            }
        });
        return binding.getRoot();
    }
    void DownloadImage(String ImageUrl) {

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
            showToast("Need Permission to access storage for Downloading Image");
        } else {
            showToast("Downloading Image...");
            //Asynctask to create a thread to downlaod image in the background
            new DownloadsImage().execute(ImageUrl);
        }
    }
    class DownloadsImage extends AsyncTask<String, Void,Void> {

        @Override
        protected Void doInBackground(String... strings) {
            URL url = null;
            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Bitmap bm = null;
            try {
                bm =    BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Create Path to save Image
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES+ "/AsmitaResults2022"); //Creates app specific folder

            if(!path.exists()) {
                path.mkdirs();
            }

            File imageFile = new File(path, String.valueOf(eventName+System.currentTimeMillis())+".png"); // Imagename.png
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(imageFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try{
                bm.compress(Bitmap.CompressFormat.PNG, 100, out); // Compress Image
                out.flush();
                out.close();
                // Tell the media scanner about the new file so that it is
                // immediately available to the user.
                MediaScannerConnection.scanFile(getContext(),new String[] { imageFile.getAbsolutePath() }, null,new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        // Log.i("ExternalStorage", "Scanned " + path + ":");
                        //    Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });
            } catch(Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            showToast("Result Saved in Pictures/AsmitaResults2022!");
        }
    }
    void showToast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }
}