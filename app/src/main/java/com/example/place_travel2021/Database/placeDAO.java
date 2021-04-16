package com.example.place_travel2021.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.Model_Entity.User;

import java.util.List;
@Dao
public interface placeDAO {
    @Insert
    void insertPlace(DiaDiem... place);


    //Select All Data place
    @Query("select * from  place")
    List<DiaDiem> getAllData();


    //DELETE DATA user
    @Query("delete from place where `key`= :id")
    void deleteData(int id);


    //Update Data place

    @Query("update place SET namePlace= :name ,addressPlace =:address, costPlace =:cost, imgplace =:image where `key`= :key")
    void updateData(String name, String cost, String address,byte[] image, int key);


}
