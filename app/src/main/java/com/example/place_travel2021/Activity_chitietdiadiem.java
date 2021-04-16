package com.example.place_travel2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.place_travel2021.fragment.Fragment_Home;

public class Activity_chitietdiadiem extends AppCompatActivity {

    ImageView imagect;


    Button btnbackct,btndattour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietdiadiem);
        btnbackct=(Button)findViewById(R.id.btn_back_ct);
        btndattour=(Button)findViewById(R.id.btn_dattour);
        btnbackct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_chitietdiadiem.this,MainActivity.class));
            }
        });

        btndattour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_chitietdiadiem.this,Activivty_Dattour.class));
            }
        });

    }
}