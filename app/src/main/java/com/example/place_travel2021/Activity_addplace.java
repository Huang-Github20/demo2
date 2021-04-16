package com.example.place_travel2021;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.place_travel2021.Database.placeDatabase;
import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.fragment.Fragment_Home;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_addplace extends AppCompatActivity {

    private CircleImageView imgaddplace;

    private EditText edtaddnameplace, edtaddaddressplace,edtaddcostplace,edtinformation;
    private Button btnupdateplace,btnviewplace,btnaddimage;
    private Diadiem_Adapter diadiemAdapter;
    private List<DiaDiem> mlistplace;
//    private List<Uri> mlistimage;


    final int REQUEST_EXTERNAL_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplace);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        imgaddplace=(CircleImageView) findViewById(R.id.image_add);
        edtaddnameplace=(EditText)findViewById(R.id.edt_nameplace);
        edtaddaddressplace=(EditText)findViewById(R.id.edt_addressplace);
        edtaddcostplace=(EditText)findViewById(R.id.edt_costplace);
        edtinformation=(EditText)findViewById(R.id.edt_Information);
        btnupdateplace=(Button)findViewById(R.id.btn_updatedata);
        btnaddimage=(Button)findViewById(R.id.btn_addimage);
        btnviewplace=(Button)findViewById(R.id.btn_view);

        diadiemAdapter = new Diadiem_Adapter(this);


        btnupdateplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtaddnameplace.getText().toString().isEmpty()
                || edtaddaddressplace.getText().toString().isEmpty()
                || edtaddcostplace.getText().toString().isEmpty()
                || edtinformation.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Bạn phải nhập đầy đủ thông tin !",Toast.LENGTH_SHORT).show();
                }
                else {
                    saveData();
                }
            }
        });

        btnviewplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_addplace.this, Fragment_Home.class));
            }
        });
         // Thêm ảnh
        btnaddimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(Activity_addplace.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Activity_addplace.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
//                    return;
                } else {
                    launchGalleryIntent();
                }
            }
        });

    }

    public void launchGalleryIntent() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_EXTERNAL_STORAGE);
    }

        @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    launchGalleryIntent();
                } else {

                }
                return;
            }
        }
    }

    Bitmap bitmap = null;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EXTERNAL_STORAGE && resultCode == RESULT_OK) {
            final CircleImageView imageView = findViewById(R.id.image_add);
            final List<Bitmap> bitmaps = new ArrayList<>();
            ClipData clipData = data.getClipData();
            if (clipData != null) {
//                //nhiều hình ảnh được chọn
//                for (int i = 0; i < clipData.getItemCount(); i++) {
//                    Uri imageUri = clipData.getItemAt(i).getUri();
//                    Log.d("URI", imageUri.toString());
//                    try {
//                        InputStream inputStream = getContentResolver().openInputStream(imageUri);
//                         bitmap = BitmapFactory.decodeStream(inputStream);
//                        bitmaps.add(bitmap);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
            } else {
                //một hình ảnh được chọn
                Uri imageUri = data.getData();
                Log.d("URI", imageUri.toString());
                try {
                    InputStream inputStream = getContentResolver().openInputStream(imageUri);
                     bitmap = BitmapFactory.decodeStream(inputStream);
                    bitmaps.add(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (final Bitmap b : bitmaps) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(b);
                            }
                        });
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }


    private void saveData() {

        String txt_name = edtaddnameplace.getText().toString().trim();
        String txt_address = edtaddaddressplace.getText().toString().trim();
        String txt_cost = edtaddcostplace.getText().toString().trim();
        String txt_thongtin = edtinformation.getText().toString().trim();

        mlistplace = placeDatabase.getDatabase(getApplicationContext()).getDao().getAllData();

        byte[] byteArray = getStringImage(bitmap);
        bitmap.recycle();

        placeDatabase.getDatabase(getApplicationContext()).getDao().insertPlace(new DiaDiem(mlistplace.size()+1,byteArray,txt_name,txt_address,txt_cost,txt_thongtin));
        bitmap = null;

        edtaddnameplace.setText("");
        edtaddaddressplace.setText("");
        edtaddcostplace.setText("");
        edtinformation.setText("");
        Toast.makeText(this,"Data Successfully Saved",Toast.LENGTH_SHORT).show();

        finish();
    }

    public byte[] getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return imageBytes;
    }

}