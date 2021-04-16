package com.example.place_travel2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activivty_Dattour extends AppCompatActivity {
    private Button btnback_dattour;
    private ImageButton imageButtonmess,imageButtoncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activivty__dattour);
        btnback_dattour=(Button)findViewById(R.id.btn_back_dattour);
        imageButtoncall=(ImageButton)findViewById(R.id.btn_image_call);
        imageButtonmess=(ImageButton)findViewById(R.id.btn_image_mess);

        imageButtoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
        imageButtonmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

        btnback_dattour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activivty_Dattour.this,Activity_chitietdiadiem.class));
            }
        });

    }


}