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
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asmita22.CustomProgressDialogue;
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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ResultsFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    FragmentResultsBinding binding;
    String Result,eventName,url;
    View view;
    public ResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_results, container, false);
        firebaseFirestore=FirebaseFirestore.getInstance();
        TrixxterActivity activity = (TrixxterActivity) getActivity();
        eventName = activity.getName();
        DocumentReference reference=firebaseFirestore.collection("events").document(eventName);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Result=documentSnapshot.getString("Result");
                if(!Result.equals("-1")){
                    view.findViewById(R.id.result).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.default_result_iv).setVisibility(View.INVISIBLE);
                    view.findViewById(R.id.default_result_tv).setVisibility(View.INVISIBLE);
                    pdfOpen(Result);
                }
            }
        });
        return view;
    }
    private void pdfOpen(String fileUrl){

        CustomProgressDialogue dialogue=new CustomProgressDialogue(getContext());
        WebView webView = view.findViewById(R.id.web_result);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptEnabled(true);
        url=null;
        try {
            url = "https://docs.google.com/gview?embedded=true&url=" + URLEncoder.encode(Result, "ISO-8859-1");
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            dialogue.show();
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageFinished(WebView view, String url) {
                    if (view.getTitle().equals("")) {
                        view.reload();
                    }
                    else{
                        dialogue.dismiss();
                    }
                }
            });
            webView.loadUrl(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}