package com.example.asmita22.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.asmita22.Adaptor.teamAdaptor;
import com.example.asmita22.Models.TeamModel;
import com.example.asmita22.R;
import com.example.asmita22.databinding.FragmentHomeBinding;
import com.example.asmita22.databinding.FragmentTeamBinding;

import java.util.ArrayList;


public class TeamFragment extends Fragment {


    FragmentTeamBinding binding;
    public TeamFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTeamBinding.inflate(inflater,container,false);
        ArrayList<TeamModel> arrayList=new ArrayList<>();
        arrayList.add(new TeamModel("@drawable/a00","Dr. Sunnel Yadav", "Faculty In-Charge","Mail"));
        arrayList.add(new TeamModel("@drawable/a01","Mr. Harsh Bhardwaj", "President","Mail"));
        arrayList.add(new TeamModel("@drawable/a02","Mr. Sahil Udayasingh", "General Secretary","Mail"));
        arrayList.add(new TeamModel("@drawable/a03","Ashish Tyagi", "Sports Secretary","Mail"));
        arrayList.add(new TeamModel("@drawable/a04","Harsh Meena", "Fest Coordinator","Mail"));
        arrayList.add(new TeamModel("@drawable/a05","Hritik Chauhan", "Fest Coordinator","Mail"));
        arrayList.add(new TeamModel("@drawable/a06","Tushar Kumar ", "Head Public Relations","Mail"));
        arrayList.add(new TeamModel("@drawable/a07","Pavika Chaudhary", "Head Public Relations","Mail"));
        arrayList.add(new TeamModel("@drawable/a08","Chaitanya Joshi", "Head Media and Publicity","Mail"));
        arrayList.add(new TeamModel("@drawable/a09","Ankit Chauhan", "Head Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a10","Nitesh Rawat", "Head Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a11","Vasu Gupta", "Head Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a12","Ritu Kiran Murmu", "Head Registration","Mail"));
        arrayList.add(new TeamModel("@drawable/a13","Sarvesh", "Head Registration","Mail"));
        arrayList.add(new TeamModel("@drawable/a14","Sneha Gupta", "Head Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a15","Priya Bhagat", "Head Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a16","Aditya Singh Machhaiya", "Head Filming","Mail"));
        arrayList.add(new TeamModel("@drawable/a17","Garvit Chittora", "Head Web Operations","Mail"));
        arrayList.add(new TeamModel("@drawable/a18","Varun Bhardwaj", "Head App Operations","Mail"));
        arrayList.add(new TeamModel("@drawable/a19","Devang Bharti", "Head Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a20","Prabhnoor Singh", "Head Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a21","Nabajit Boro", "Head Campus Coordinator","Mail"));
        arrayList.add(new TeamModel("@drawable/a22","Mayur Kumar", "Head Campus Coordinator","Mail"));
        arrayList.add(new TeamModel("@drawable/a23","Divyansh Gupta", "E&M","Mail"));
        arrayList.add(new TeamModel("@drawable/a24","Gautam Rajeev", "E&M","Mail"));
        arrayList.add(new TeamModel("@drawable/a25","Hardik Arora", "E&M","Mail"));
        arrayList.add(new TeamModel("@drawable/a26","Ishan Tapadia", "E&M","Mail"));
        arrayList.add(new TeamModel("@drawable/a27","Jiniya Singal", "E&M","Mail"));
        arrayList.add(new TeamModel("@drawable/a28","Pranav Raj", "E&M","Mail"));
        arrayList.add(new TeamModel("@drawable/a29","Aayoushee", "Media and Publicity","Mail"));
        arrayList.add(new TeamModel("@drawable/a30","Samriddhi V Walia", "Media and Publicity","Mail"));
        arrayList.add(new TeamModel("@drawable/a31","Shivam Singh", "Media and Publicity","Mail"));
        arrayList.add(new TeamModel("@drawable/a32","Janhavi Bawaskar", "Media and Publicity","Mail"));
        arrayList.add(new TeamModel("@drawable/a33","Ishaan Kaustav", "Public Relations","Mail"));
        arrayList.add(new TeamModel("@drawable/a34","Rishabh jain", "Public Relations","Mail"));
        arrayList.add(new TeamModel("@drawable/a35","Kotha Sai Vineeth", "Public Relations","Mail"));
        arrayList.add(new TeamModel("@drawable/a36","Rushil", "Public Relations","Mail"));
        arrayList.add(new TeamModel("@drawable/a37","Aaditya Rathod", "Registration","Mail"));
        arrayList.add(new TeamModel("@drawable/a38","Praneeksha", "Registration","Mail"));
        arrayList.add(new TeamModel("@drawable/a39","Kunal Kaushik", "Registration","Mail"));
        arrayList.add(new TeamModel("@drawable/a40","Nithin", "Registration","Mail"));
        arrayList.add(new TeamModel("@drawable/a41","Hemant Goyal", "Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a42","Danish Jamwal", "Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a43","Himanshu Mathur", "Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a44","Prashast Jain", "Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a45","Archit Dashora", "Sponsorship And Marketing","Mail"));
        arrayList.add(new TeamModel("@drawable/a46","MD. Mohsin Raza", "Web Operations","Mail"));
        arrayList.add(new TeamModel("@drawable/a47","Prajjwal Bhatt", "Web Operations","Mail"));
        arrayList.add(new TeamModel("@drawable/a48","Shailesh Tiwar", "Web Operations","Mail"));
        arrayList.add(new TeamModel("@drawable/a49","Shashank Tiwari", "Filming","Mail"));
        arrayList.add(new TeamModel("@drawable/a50","Deepanshu Gautam", "Filming","Mail"));
        arrayList.add(new TeamModel("@drawable/a51","Himanshu", "Filming","Mail"));
        arrayList.add(new TeamModel("@drawable/a52","Sachin Kumar", "Filming","Mail"));
        arrayList.add(new TeamModel("@drawable/a53","Anupam Raj", "Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a54","Aditya Raj", "Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a55","Mahesh Kumar Pal", "Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a56","Rajat Choudhary", "Hospitality And Travel","Mail"));
        arrayList.add(new TeamModel("@drawable/a57","Shadaan Hussain", "Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a58","Laalasa Krishna", "Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a59","Saurav", "Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a60","Shashirith", "Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a61","Anshika Jain", "Creatives","Mail"));
        arrayList.add(new TeamModel("@drawable/a62","Aashish Agarwal", "App Operations","Mail"));
        arrayList.add(new TeamModel("@drawable/a63","Tabish Malik", "App Operations","7456990499"));
        teamAdaptor adaptor=new teamAdaptor(arrayList,getContext());
        binding.TeamRV.setAdapter(adaptor);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getContext());
        binding.TeamRV.setLayoutManager(layoutManager);
        return  binding.getRoot();
    }
}