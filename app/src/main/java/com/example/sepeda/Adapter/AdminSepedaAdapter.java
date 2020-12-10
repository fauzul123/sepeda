package com.example.sepeda.Adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.sepeda.Admin.AdminSepedaActivity;
import com.example.sepeda.Admin.DetailSepedaActivity;
import com.example.sepeda.Admin.DetailUserActivity;
import com.example.sepeda.Admin.list_data_customerActivity;
import com.example.sepeda.Helper.AppHelper;
import com.example.sepeda.Helper.config;
import com.example.sepeda.Model.SepedaModel;
import com.example.sepeda.Model.UserAdminModel;
import com.example.sepeda.R;

import org.json.JSONObject;

import java.util.List;

public class AdminSepedaAdapter extends RecyclerView.Adapter<AdminSepedaAdapter.ItemViewHolder> {
    private Context context;
    private List<SepedaModel> mList;
    private String mLoginToken = "";
    private boolean mBusy = false;
    private ProgressDialog mProgressDialog;
    private AdminSepedaActivity mAdminActivity;
    private TextView tvUsername;

    public AdminSepedaAdapter(Context context, List<SepedaModel> mList, Activity AdminUserActivity) {

        this.context = context;
        this.mList = mList;
        this.mAdminActivity = (AdminSepedaActivity) AdminUserActivity;

    }
    @NonNull
    @Override
    public AdminSepedaAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_list_data_sepeda, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminSepedaAdapter.ItemViewHolder holder, int position) {
        final SepedaModel Amodel = mList.get(position);
        holder.bind(Amodel);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearData() {
        int size = this.mList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.mList.remove(0);
            }
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvKode, tvMerk, tvHarga;
        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKode = itemView.findViewById(R.id.tvKodesepeda);
            tvMerk = itemView.findViewById(R.id.tvMerkSepeda);
            tvHarga = itemView.findViewById(R.id.tvHargaSewa);
        }

        private void bind(final SepedaModel Amodel) {
            tvKode.setText(Amodel.getKODE());
            tvMerk.setText(Amodel.getMERK());
            tvHarga.setText(Amodel.getHARGA());

            tvKode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailSepedaActivity.class);
                    AppHelper.goToSepedaAdminDetail(context,Amodel);
                }
            });
        }
    }
}
