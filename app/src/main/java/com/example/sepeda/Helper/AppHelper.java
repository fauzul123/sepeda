package com.example.sepeda.Helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.sepeda.Admin.DetailUserActivity;
import com.example.sepeda.Model.SepedaModel;
import com.example.sepeda.Model.UserAdminModel;

import org.json.JSONObject;

public class AppHelper {
    public static UserAdminModel mapUserAdminModel(JSONObject rowData) {
        UserAdminModel item = new UserAdminModel();
        item.setId(rowData.optString("id"));
        item.setRoleUser(rowData.optString("roleuser"));
        item.setEmail(rowData.optString("email"));
        item.setUsername(rowData.optString("username"));
        item.setNoKtp(rowData.optString("noktp"));
        item.setNoTlp(rowData.optString("notlp"));
        item.setAlamat(rowData.optString("alamat"));



        return item;
    }

    public static void goToUserAdminDetail(Context context, UserAdminModel rowData) {
        Bundle bundle = new Bundle();

        bundle.putString("id", String.valueOf(rowData.getId()));
        bundle.putString("roleuser", rowData.getRoleUser().toUpperCase());
        bundle.putString("email", rowData.getEmail().toUpperCase());
        bundle.putString("username", rowData.getUsername().toUpperCase());
        bundle.putString("noktp", rowData.getNoKtp());
        bundle.putString("notlp", rowData.getNoTlp());
        bundle.putString("alamat", rowData.getAlamat().toUpperCase());



        Intent i = new Intent(context, DetailUserActivity.class);
        i.putExtra("extra_user", rowData);
        context.startActivity(i);
    }

    public static SepedaModel mapSepedaAdminModel(JSONObject rowData) {
        SepedaModel item = new SepedaModel();
//        item.setID(rowData.optInt("ID"));
        item.setKODE(rowData.optString("KODE"));
        item.setMERK(rowData.optString("MERK"));
        item.setWARNA(rowData.optString("WARNA"));
        item.setIMAGE(rowData.optString("IMAGE"));
        item.setHARGA(rowData.optString("HARGA"));

        return item;
    }

    public static void goToSepedaAdminDetail(Context context, SepedaModel rowData) {
        Bundle bundle = new Bundle();

        bundle.putString("ID", String.valueOf(rowData.getID()));
        bundle.putString("KODE", rowData.getKODE().toUpperCase());
        bundle.putString("MERK", rowData.getMERK().toUpperCase());
        bundle.putString("WARNA", rowData.getWARNA().toUpperCase());
        bundle.putString("HARGA", rowData.getHARGA());
        bundle.putString("IMAGE", rowData.getIMAGE());

//        Intent i = new Intent(context, DetailUserActivity.class);
//        i.putExtra("extra_sepeda", rowData);
//        context.startActivity(i);
    }

}
