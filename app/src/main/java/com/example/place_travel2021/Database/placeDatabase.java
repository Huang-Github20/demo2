package com.example.place_travel2021.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.Model_Entity.User;

@Database(entities = {DiaDiem.class, User.class}, version = 1)
public abstract class placeDatabase extends RoomDatabase{

    public abstract placeDAO getDao();
    public abstract UserDAO getUserDao();

    private static placeDatabase instance;


    public static placeDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (placeDatabase.class) {
                instance = Room.databaseBuilder(context, placeDatabase.class, "DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;

    }
}
