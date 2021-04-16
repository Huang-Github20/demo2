package com.example.place_travel2021.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.place_travel2021.Activity_update_user;
import com.example.place_travel2021.Database.placeDatabase;
import com.example.place_travel2021.Diadiem_Adapter;
import com.example.place_travel2021.MainActivity;
import com.example.place_travel2021.Model_Entity.User;
import com.example.place_travel2021.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Profile extends Fragment {


    TextView tv_username,tv_userdate,tv_useraddress,tv_userphone,tv_userCMT,tv_userSTK,tv_useremail;
    FloatingActionButton btnedit;
    private List<User> listuser;


    View v;

    public Fragment_Profile() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment__profile, container, false);

        anhxa();

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Activity_update_user.class));

            }
        });


        return v;
    }

    private void anhxa() {

        btnedit = v.findViewById(R.id.btn_Edit_profile);
        tv_username = v.findViewById(R.id.txt_name_profile);
        tv_userdate = v.findViewById(R.id.txt_date_profile);
        tv_useraddress = v.findViewById(R.id.txt_address_profile);
        tv_userphone = v.findViewById(R.id.txt_phone_profile);
        tv_userCMT = v.findViewById(R.id.txt_CMT_profile);
        tv_userSTK = v.findViewById(R.id.txt_STK_profile);
        tv_useremail = v.findViewById(R.id.txt_email_profile);

    }

    private void getData() {

        listuser = placeDatabase.getDatabase(getContext()).getUserDao().getDataUser();

    }


}