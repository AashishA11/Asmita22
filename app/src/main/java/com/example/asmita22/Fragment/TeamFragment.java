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
        arrayList.add(new TeamModel("@drawable/a00","Dr. Sunnel Yadav", "Faculty In-Charge","mail"));
        arrayList.add(new TeamModel("@drawable/a01","Mr. Sahil Udayasingh", "President","9205177057"));
        arrayList.add(new TeamModel("@drawable/a18","Mr. Varun Bhardwaj", "General Secretary","9319866520"));
        arrayList.add(new TeamModel("@drawable/a03","Ashish Tyagi", "Sports Secretary","7818896250"));
        arrayList.add(new TeamModel("@drawable/a04","Harsh Meena", "Fest Coordinator","9330319099"));
        arrayList.add(new TeamModel("@drawable/a05","Hritik Chauhan", "Fest Coordinator","9068322490"));
        arrayList.add(new TeamModel("@drawable/a06","Tushar Kumar ", "Public Relations","8210491173"));
        arrayList.add(new TeamModel("@drawable/a07","Pavika Chaudhary", "Public Relations","9118011960"));
        arrayList.add(new TeamModel("@drawable/a08","Chaitanya Joshi", "Media and Publicity","9871119308"));
        arrayList.add(new TeamModel("@drawable/a09","Ankit Chauhan", "Head Hospitality And Travel","8859185192"));
        arrayList.add(new TeamModel("@drawable/a10","Nitesh Rawat", "Head Hospitality And Travel","8077983887"));
        arrayList.add(new TeamModel("@drawable/a11","Vasu Gupta", "Head Hospitality And Travel","8858079808"));
        arrayList.add(new TeamModel("@drawable/a12","Ritu Kiran Murmu", "Head Registration","7979007562"));
        arrayList.add(new TeamModel("@drawable/a13","Sarvesh", "Head Registration","8502850121"));
        arrayList.add(new TeamModel("@drawable/a14","Sneha Gupta", "Head Creatives","9462572921"));
        arrayList.add(new TeamModel("@drawable/a15","Priya Bhagat", "Head Creatives","6264343905"));
        arrayList.add(new TeamModel("@drawable/a16","Aditya Singh Machhaiya", "Head Filming","8989006117"));
        arrayList.add(new TeamModel("@drawable/a17","Garvit Chittora", "Head Web Operations","9509267434"));
        arrayList.add(new TeamModel("@drawable/a18","Varun Bhardwaj", "Head App Operations","9319866520"));
        arrayList.add(new TeamModel("@drawable/a19","Devang Bharti", "Head Sponsorship And Marketing","8303437325"));
        arrayList.add(new TeamModel("@drawable/a20","Prabhnoor Singh", "Head Sponsorship And Marketing","9660720117"));
        arrayList.add(new TeamModel("@drawable/a21","Nabajit Boro", "Head Campus Coordinator","9707549626"));
        arrayList.add(new TeamModel("@drawable/a22","Mayur Kumar", "Head Campus Coordinator","9523389362"));
        arrayList.add(new TeamModel("@drawable/a23","Divyansh Gupta", "Events and Management","8982856489"));
        arrayList.add(new TeamModel("@drawable/a24","Gautam Rajeev", "Events and Management","7575871552"));
        arrayList.add(new TeamModel("@drawable/a25","Hardik Arora", "Events and Management","9802201816"));
        arrayList.add(new TeamModel("@drawable/a26","Ishan Tapadia", "Events and Management","8875225090"));
        arrayList.add(new TeamModel("@drawable/a27","Jiniya Singal", "Events and Management","7357642492"));
        arrayList.add(new TeamModel("@drawable/a28","Pranav Raj", "Events and Management","7903823507"));
        arrayList.add(new TeamModel("@drawable/a29","Aayoushee", "Media and Publicity","7023386345"));
        arrayList.add(new TeamModel("@drawable/a30","Samriddhi V Walia", "Media and Publicity","9717620716"));
        arrayList.add(new TeamModel("@drawable/a31","Shivam Singh", "Media and Publicity","7985613162"));
        arrayList.add(new TeamModel("@drawable/a32","Janhavi Bawaskar", "Media and Publicity","9167026346"));
        arrayList.add(new TeamModel("@drawable/a33","Ishaan Kaustav", "Public Relations","9304309794"));
        arrayList.add(new TeamModel("@drawable/a34","Rishabh jain", "Public Relations","7909338983"));
        arrayList.add(new TeamModel("@drawable/a35","Kotha Sai Vineeth", "Public Relations","8897947042"));
        arrayList.add(new TeamModel("@drawable/a36","Rushil", "Public Relations","9769862981"));
        arrayList.add(new TeamModel("@drawable/a37","Aaditya Rathod", "Registration","9977737801"));
        arrayList.add(new TeamModel("@drawable/a38","Praneeksha", "Registration","6309292919"));
        arrayList.add(new TeamModel("@drawable/a39","Kunal Kaushik", "Registration","9334430187"));
        arrayList.add(new TeamModel("@drawable/a40","Nithin", "Registration","8341608876"));
        arrayList.add(new TeamModel("@drawable/a41","Hemant Goyal", "Sponsorship And Marketing","8949064004"));
        arrayList.add(new TeamModel("@drawable/a42","Danish Jamwal", "Sponsorship And Marketing","8899741619"));
        arrayList.add(new TeamModel("@drawable/a43","Himanshu Mathur", "Sponsorship And Marketing","7081457425"));
        arrayList.add(new TeamModel("@drawable/a44","Prashast Jain", "Sponsorship And Marketing","9560281108"));
        arrayList.add(new TeamModel("@drawable/a45","Archit Dashora", "Sponsorship And Marketing","9509830601"));
        arrayList.add(new TeamModel("@drawable/a46","MD. Mohsin Raza", "Web Operations","9771132632"));
        arrayList.add(new TeamModel("@drawable/a47","Prajjwal Bhatt", "Web Operations","9302547780"));
        arrayList.add(new TeamModel("@drawable/a48","Shailesh Tiwar", "Web Operations","+971503718598"));
        arrayList.add(new TeamModel("@drawable/a49","Shashank Tiwari", "Filming","8591194172"));
        arrayList.add(new TeamModel("@drawable/a50","Deepanshu Gautam", "Filming","9058024546"));
        arrayList.add(new TeamModel("@drawable/a51","Himanshu", "Filming","9649654790"));
        arrayList.add(new TeamModel("@drawable/a52","Sachin Kumar", "Filming","9560712575"));
        arrayList.add(new TeamModel("@drawable/a53","Anupam Raj", "Hospitality And Travel","9990843768"));
        arrayList.add(new TeamModel("@drawable/a54","Aditya Raj", "Hospitality And Travel","9708409423"));
        arrayList.add(new TeamModel("@drawable/a55","Mahesh Kumar Pal", "Hospitality And Travel","9889429691"));
        arrayList.add(new TeamModel("@drawable/a56","Rajat Choudhary", "Hospitality And Travel","6350664634"));
        arrayList.add(new TeamModel("@drawable/a58","Laalasa Krishna", "Creatives","7893546579"));
        arrayList.add(new TeamModel("@drawable/a59","Saurav", "Creatives","9325606686"));
        arrayList.add(new TeamModel("@drawable/a60","Shashirith", "Creatives","6300973551"));
        arrayList.add(new TeamModel("@drawable/a57","Shadaan Hussain", "Creatives","8989058973"));
        arrayList.add(new TeamModel("@drawable/a61","Anshika Jain", "Creatives","8989058973"));
        arrayList.add(new TeamModel("@drawable/a62","Aashish Agarwal", "App Operations","9975679288"));
        arrayList.add(new TeamModel("@drawable/a63","Tabish Malik", "App Operations","7456990499"));
        teamAdaptor adaptor=new teamAdaptor(arrayList,getContext());
        binding.TeamRV.setAdapter(adaptor);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getContext());
        binding.TeamRV.setLayoutManager(layoutManager);
        return  binding.getRoot();
    }
}