package com.example.place_travel2021.Model_Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int keyuser;
    @ColumnInfo(name = "Nameuser")
    private String nameuser;
    @ColumnInfo(name = "Dateuser")
    private String dateuser;
    @ColumnInfo(name = "Addressuser")
    private String addressuser;
    @ColumnInfo(name = "Phoneuser")
    private String phoneuser;
    @ColumnInfo(name = "Cmtuser")
    private String cmtuser;
    @ColumnInfo(name = "STKuser")
    private String STKuser;
    @ColumnInfo(name = "Emailuser")
    private String emailuser;


    public User(int keyuser,String nameuser, String dateuser, String addressuser, String phoneuser, String cmtuser, String STKuser, String emailuser) {
        this.nameuser = nameuser;
        this.dateuser = dateuser;
        this.addressuser = addressuser;
        this.phoneuser = phoneuser;
        this.cmtuser = cmtuser;
        this.STKuser = STKuser;
        this.emailuser = emailuser;
    }

    public User() {
    }

    public int getKeyuser() {
        return keyuser;
    }

    public void setKeyuser(int keyuser) {
        this.keyuser = keyuser;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getDateuser() {
        return dateuser;
    }

    public void setDateuser(String dateuser) {
        this.dateuser = dateuser;
    }

    public String getAddressuser() {
        return addressuser;
    }

    public void setAddressuser(String addressuser) {
        this.addressuser = addressuser;
    }

    public String getPhoneuser() {
        return phoneuser;
    }

    public void setPhoneuser(String phoneuser) {
        this.phoneuser = phoneuser;
    }

    public String getCmtuser() {
        return cmtuser;
    }

    public void setCmtuser(String cmtuser) {
        this.cmtuser = cmtuser;
    }

    public String getSTKuser() {
        return STKuser;
    }

    public void setSTKuser(String sexuser) {
        this.STKuser = sexuser;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String gmailuser) {
        this.emailuser = gmailuser;
    }

}
