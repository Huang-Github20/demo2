package com.example.place_travel2021.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.Model_Entity.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertDataUser(User user);

    //Select All Data user
    @Query("select * from  user")
    List<User> getDataUser();

    //DELETE DATA place
    @Query("delete from user where `keyuser`= :id_user")
    void deleteData(int id_user);

    //Update Data user
    @Query("update user SET Nameuser= :name_user ,Dateuser =:date_user, Addressuser =:address_user, Phoneuser =:phone_user, Cmtuser= :cmt_user, STKuser= :STK_user ,Emailuser= :email_user where `keyuser`= :key_user")
    void updateDataUser(String name_user,String date_user,String address_user,String phone_user,String cmt_user,String STK_user,String email_user, int key_user);
}
