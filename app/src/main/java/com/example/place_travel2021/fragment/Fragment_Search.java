package com.example.place_travel2021.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.place_travel2021.Database.placeDatabase;
import com.example.place_travel2021.Diadiem_Adapter;
import com.example.place_travel2021.MainActivity;
import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Search extends Fragment {

    List<DiaDiem> lstDiaDiemSearch;
    RecyclerView rcvfragmentSreach;
    SearchView sreachView;
    Diadiem_Adapter diadiemAdapter;


    View v;
    public Fragment_Search() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment__search, container, false);

        rcvfragmentSreach=v.findViewById(R.id.rcv_Search);
        sreachView = v.findViewById(R.id.searchview);

        lstDiaDiemSearch = new ArrayList<>();

        lstDiaDiemSearch = placeDatabase.getDatabase(getContext()).getDao().getAllData();
        diadiemAdapter = new Diadiem_Adapter(lstDiaDiemSearch);
        rcvfragmentSreach.setAdapter(diadiemAdapter);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        sreachView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                diadiemAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                diadiemAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}