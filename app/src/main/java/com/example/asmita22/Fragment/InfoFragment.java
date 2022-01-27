package com.example.asmita22.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmita22.R;
import com.example.asmita22.TrixxterActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Field;


public class InfoFragment extends Fragment {
    FirebaseFirestore firestore;
    public  TextView info_txt,tittle_tv;
    public ImageView insta_link,fb_link;
    View view=null;
    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_info, container, false);
        firestore=FirebaseFirestore.getInstance();
        info_txt=(TextView) view.findViewById(R.id.info_TV);
        tittle_tv=(TextView) view.findViewById(R.id.tittle_info);
        insta_link=(ImageView) view.findViewById(R.id.iv_insta);
        fb_link=(ImageView) view.findViewById(R.id.iv_facebook);
        TrixxterActivity activity = (TrixxterActivity) getActivity();
        String eventName = activity.getName();
        tittle_tv.setText(eventName);
        DocumentReference documentReference=firestore.collection("events").document(eventName);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    info_txt.setText(documentSnapshot.getString("Info"));
                    String url_insta=documentSnapshot.getString("InstaLink");
                    String url_fb=documentSnapshot.getString("FacebookLink");
                    insta_link.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_insta));
                            startActivity(browserIntent);
                        }
                    });
                    fb_link.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_fb));
                            startActivity(browserIntent);
                        }
                    });
                }
            }
        });
        return view;
    }
}