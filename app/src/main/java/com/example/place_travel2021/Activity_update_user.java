package com.example.place_travel2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.place_travel2021.Database.placeDatabase;
import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.Model_Entity.User;
import com.example.place_travel2021.fragment.Fragment_Home;
import com.example.place_travel2021.fragment.Fragment_Profile;

import java.util.List;

public class Activity_update_user extends AppCompatActivity {
    Button btnupdateuser,btnbackuser;
    EditText edtusername,edtuserdate,edtuseraddress,edtuserphone,edtuserCMT,edtuserSTK,edtuserEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        anhxa();



    }

    private void anhxa() {

        btnbackuser=(Button)findViewById(R.id.btn_back_edit_profile);
        btnupdateuser=(Button)findViewById(R.id.btn_update_profile);
        edtusername=(EditText)findViewById(R.id.edt_update_name);
        edtuserdate=(EditText)findViewById(R.id.edt_update_date);
        edtuseraddress=(EditText)findViewById(R.id.edt_update_address);
        edtuserphone=(EditText)findViewById(R.id.edt_update_Phone);
        edtuserCMT=(EditText)findViewById(R.id.edt_update_CMT);
        edtuserSTK=(EditText)findViewById(R.id.edt_update_STK);
        edtuserEmail=(EditText)findViewById(R.id.edt_update_Email);

        btnupdateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtusername.getText().toString().isEmpty()
                        ||  edtuseraddress.getText().toString().isEmpty()
                        || edtuserdate.getText().toString().isEmpty()
                        || edtuserphone.getText().toString().isEmpty()
                        || edtuserCMT.getText().toString().isEmpty()
                        || edtuserSTK.getText().toString().isEmpty()
                        || edtuserEmail.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Bạn phải điền đầy đủ thông tin !",Toast.LENGTH_SHORT).show();
                }else {

                    saveDataUser();

                }

            }
        });

        btnbackuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_update_user.this, Activity.class));

            }
        });
    }


    private void saveDataUser() {

        String txt_name = edtusername.getText().toString().trim();
        String txt_date = edtuserdate.getText().toString().trim();
        String txt_address = edtuseraddress.getText().toString().trim();
        String txt_phone = edtuserphone.getText().toString().trim();
        String txt_cmt = edtuserCMT.getText().toString().trim();
        String txt_stk = edtuserSTK.getText().toString().trim();
        String txt_email = edtuserEmail.getText().toString().trim();

        List<DiaDiem> list = placeDatabase.getDatabase(getApplicationContext()).getDao().getAllData();

        placeDatabase.getDatabase(getApplicationContext()).getUserDao().insertDataUser(new User(list.size()+1,txt_name,txt_date,txt_address,txt_phone,txt_cmt,txt_stk,txt_email));

        edtusername.setText("");
        edtuseraddress.setText("");
        edtuserdate.setText("");
        edtuserphone.setText("");
        edtuserCMT.setText("");
        edtuserSTK.setText("");
        edtuserEmail.setText("");

        finish();

    }
}