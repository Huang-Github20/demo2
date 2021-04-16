package com.example.place_travel2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.place_travel2021.fragment.Fragment_Home;
import com.example.place_travel2021.fragment.Fragment_Profile;
import com.example.place_travel2021.fragment.Fragment_Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnavi;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnavi=(BottomNavigationView)findViewById(R.id.btn_navi);
        frameLayout=(FrameLayout)findViewById(R.id.frame_layout);

        setFragment(new Fragment_Home());

        btnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.function_home:
                        setFragment(new Fragment_Home());
                        return true;
                    case R.id.function_search:
                        setFragment(new Fragment_Search());
                        return true;
                    case R.id.function_profile:
                        setFragment(new Fragment_Profile());
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}