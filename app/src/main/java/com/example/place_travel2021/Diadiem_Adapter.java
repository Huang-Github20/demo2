package com.example.place_travel2021;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import com.bumptech.glide.Glide;
import com.example.place_travel2021.Model_Entity.DiaDiem;
import com.example.place_travel2021.Model_Entity.User;
import com.example.place_travel2021.fragment.Fragment_Home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Diadiem_Adapter extends RecyclerView.Adapter<Diadiem_Adapter.DiadiemViewHorlder> implements Filterable {

    private Context context;
    private List<DiaDiem> mlistDiaDiem;
    private List<DiaDiem> mlistDiaDiemold;


    public Diadiem_Adapter(List<DiaDiem> mlistDiaDiem) {
        this.mlistDiaDiem = mlistDiaDiem;
        this.mlistDiaDiemold = mlistDiaDiem;
    }

    public Diadiem_Adapter(Context context) {
        this.context = context;
    }


    public void setData(List<DiaDiem> list){
        this.mlistDiaDiem=list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DiadiemViewHorlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diadiemm,parent,false);

        return new DiadiemViewHorlder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DiadiemViewHorlder holder, int position) {

        holder.txtnameplace.setText(mlistDiaDiem.get(position).getNameplace());
        holder.txtaddressplace.setText(mlistDiaDiem.get(position).getAddressplace());
        holder.txtcostplace.setText(mlistDiaDiem.get(position).getCostplace());
        Bitmap bitmap = BitmapFactory.decodeByteArray(mlistDiaDiem.get(position).getImgplace(),0,100);
        holder.imgdiadiem.setImageBitmap(bitmap);
        holder.btnxemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Activity_chitietdiadiem.class);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {

        return mlistDiaDiem.size();
    }




    public class DiadiemViewHorlder extends RecyclerView.ViewHolder{
        private CircleImageView imgdiadiem;
        private TextView txtnameplace,txtaddressplace,txtcostplace;
        private Button btnxemchitiet;

        public DiadiemViewHorlder(@NonNull View itemView) {
            super(itemView);
            imgdiadiem = itemView.findViewById(R.id.img_diadiem);
            txtnameplace = itemView.findViewById(R.id.txt_nameplace);
            txtaddressplace = itemView.findViewById(R.id.txt_addressplace);
            txtcostplace = itemView.findViewById(R.id.txt_costplace);
            btnxemchitiet = itemView.findViewById(R.id.btn_xemchitiet);

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    mlistDiaDiem = mlistDiaDiemold;
                }else {
                    List<DiaDiem> list = new ArrayList<>();
                    for (DiaDiem diaDiem : mlistDiaDiemold){
                        if(diaDiem.getNameplace().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(diaDiem);
                        }
                    }
                    mlistDiaDiem = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mlistDiaDiem;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mlistDiaDiem = (List<DiaDiem>) results.values;
                notifyDataSetChanged();

            }
        };
    }

}
