package com.example.place_travel2021.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.place_travel2021.Activity_addplace;
import com.example.place_travel2021.Database.placeDatabase;
import com.example.place_travel2021.Diadiem_Adapter;
import com.example.place_travel2021.MainActivity;
import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Home extends Fragment {

    private RecyclerView rcvfragmenthome;
    private Diadiem_Adapter diadiemAdapter;
//    private MainActivity mMainActivity;
    private FloatingActionButton btnaddplace;

    private List<DiaDiem> list ;

    View v;


    public Fragment_Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment__home, container, false);
//        mMainActivity= (MainActivity) getActivity();


        btnaddplace=v.findViewById(R.id.btn_addplace);
        btnaddplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Activity_addplace.class));
            }
        });

        rcvfragmenthome = v.findViewById(R.id.rcv_fragmenthome);
        rcvfragmenthome.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL );
        rcvfragmenthome.addItemDecoration(itemDecoration);
        onResume();


        return v;

    }
    @Override
    public void onResume() {
        getData();
        super.onResume();

    }
    private void getData() {

        list = placeDatabase.getDatabase(getContext()).getDao().getAllData();
        diadiemAdapter = new Diadiem_Adapter(getContext());
        diadiemAdapter.setData(list);
        rcvfragmenthome.setAdapter(diadiemAdapter);
    }


}