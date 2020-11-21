package com.example.sepeda.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.sepeda.Adapter.AdminSepedaAdapter;
import com.example.sepeda.Adapter.AdminUserAdapter;
import com.example.sepeda.Helper.AppHelper;
import com.example.sepeda.Helper.config;
import com.example.sepeda.Model.SepedaModel;
import com.example.sepeda.Model.UserAdminModel;
import com.example.sepeda.R;
import com.example.sepeda.initial;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminSepedaActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ImageView ivAdd, ivBack;

    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView rv;
    private FloatingActionButton tambahsepeda;

    private ArrayList<SepedaModel> mList = new ArrayList<>();
    private AdminSepedaAdapter mAdapter;

    private String mLoginToken = "";
    private String mUserId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sepeda);
        binding();
        getUserList();
    }

    @Override
    public void onRefresh() {
getUserList();
    }

    public void getUserList() {
        swipeRefresh.setRefreshing(true);
        AndroidNetworking.get(config.BASE_URL + "getsepeda.php")
                .setPriority(Priority.LOW)
                .setOkHttpClient(((initial) getApplication()).getOkHttpClient())
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {

                    @Override
                    public void onResponse(JSONArray response) {
                        swipeRefresh.setRefreshing(false);
                        if (mAdapter != null) {
                            mAdapter.clearData();
                            mAdapter.notifyDataSetChanged();
                        }
                        if (mList != null) mList.clear();
                        Log.d("RBA", "res" + response);
                        try {
                            Log.i("AB", "respo: "+response);
                            //Loop the Array
                            for(int i=0;i < response.length();i++) {
                                JSONObject data = response.getJSONObject(i);
                                Log.e("ADF", "ponse: "+data );
                                SepedaModel item = AppHelper.mapSepedaAdminModel(data);
                                mList.add(item);
//                                mList.add(new UserAdminModel(
//                                        data.getInt("id"),
//                                        data.getString("email"),
//                                        data.getString("username"),
//                                        data.getString("roleuser"),
//                                        data.getString("noktp"),
//                                        data.getString("notlp"),
//                                        data.getString("alamat"),
//                                        data.getString("password")
//                                ));
                            }
                            mAdapter = new AdminSepedaAdapter (AdminSepedaActivity.this, mList, AdminSepedaActivity.this);
                            rv.setAdapter(mAdapter);
                        } catch(JSONException e) {
                            Log.e("log_tag", "Error parsing data "+e.toString());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        swipeRefresh.setRefreshing(false);
                        Toast.makeText(AdminSepedaActivity.this, config.TOAST_AN_EROR, Toast.LENGTH_SHORT).show();
                        Log.d("A", "onError1: " + anError.getErrorBody());
                        Log.d("A", "onError: " + anError.getLocalizedMessage());
                        Log.d("A", "onError: " + anError.getErrorDetail());
                        Log.d("A", "onError: " + anError.getResponse());
                        Log.d("A", "onError: " + anError.getErrorCode());
                    }
                });

    }

    private void binding() {
        tambahsepeda = findViewById(R.id.tambahsepeda);
        tambahsepeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminSepedaActivity.this,AdminSepedaCreateActivity.class);
                startActivity(i);
            }
        });

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rv = findViewById(R.id.rvSepedaManage);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);
        mAdapter = new AdminSepedaAdapter (AdminSepedaActivity.this, mList, AdminSepedaActivity.this);
        rv.setAdapter(mAdapter);

        swipeRefresh = findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.post(new Runnable() {
            private void doNothing() {

            }

            @Override
            public void run() {
                getUserList();
            }
        });
    }
}