package com.example.place_travel2021.Model_Entity;

import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "place")
public class DiaDiem implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int key;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] imgplace;
    @ColumnInfo(name = "namePlace")
    private String nameplace;
    @ColumnInfo(name = "addressPlace")
    private String addressplace;
    @ColumnInfo(name = "costPlace")
    private String costplace;
    @ColumnInfo(name = "informationPlace")
    private String informationplace;




    public DiaDiem(int key, byte[] imgplace, String nameplace, String addressplace, String costplace, String informationplace) {
        this.imgplace = imgplace;
        this.nameplace = nameplace;
        this.addressplace = addressplace;
        this.costplace = costplace;
        this.key=key;
        this.informationplace = informationplace;
    }

    public DiaDiem() {
    }

    public String getInformationplace() {
        return informationplace;
    }

    public void setInformationplace(String informationplace) {
        this.informationplace = informationplace;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public byte[] getImgplace() {
        return imgplace;
    }

    public void setImgplace(byte[] imgplace) {
        this.imgplace = imgplace;
    }

    public String getNameplace() {
        return nameplace;
    }

    public void setNameplace(String nameplace) {
        this.nameplace = nameplace;
    }

    public String getAddressplace() {
        return addressplace;
    }

    public void setAddressplace(String addressplace) {
        this.addressplace = addressplace;
    }

    public String getCostplace() {
        return costplace;
    }

    public void setCostplace(String costplace) {
        this.costplace = costplace;
    }

}
