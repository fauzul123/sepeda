package com.example.sepeda.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.sepeda.Helper.config;
import com.example.sepeda.R;
import com.example.sepeda.initial;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AdminSepedaCreateActivity extends AppCompatActivity {

    ImageView ivBack;
    private EditText etKode, etMerk, etWarna, etHarga;
    private Button btntambahsepeda;
    private boolean mIsFormFilled = false;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sepeda_create);
        binding();
    }

    private void binding() {
        etKode= findViewById(R.id.etKodesepeda);
        etMerk= findViewById(R.id.etMerk);
        etWarna= findViewById(R.id.etWarna);
        etHarga = findViewById(R.id.etHarga);
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btntambahsepeda = findViewById(R.id.btntambahsepeda);
        btntambahsepeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsFormFilled = true;
                final String kode = etKode.getText().toString();
                final String warna = etWarna.getText().toString().trim();
                final String merk = etMerk.getText().toString();
                final String harga = etHarga.getText().toString();



                if (kode.isEmpty() || warna.isEmpty() || merk.isEmpty() || harga.isEmpty()){
                    Toast.makeText(AdminSepedaCreateActivity.this, "Harap lengkapi kolom Tambah Sepeda !", Toast.LENGTH_SHORT).show();
                    mIsFormFilled = false;
                }


                if (mIsFormFilled) {
                    HashMap<String, String> body = new HashMap<>();
                    body.put("kode", kode);
                    body.put("warna", warna);
                    body.put("merk", merk);
                    body.put("harga", harga);

                    AndroidNetworking.post(config.BASE_URL+"tambahsepeda.php")
                            .addBodyParameter(body)
                            .setPriority(Priority.MEDIUM)
                            .setOkHttpClient(((initial) getApplication()).getOkHttpClient())
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {

//                                            String status = response.getString(config.RESPONSE_STATUS_FIELD);
                                        String message = response.getString(config.RESPONSE_MESSAGE_FIELD);

                                        Toast.makeText(AdminSepedaCreateActivity.this, message, Toast.LENGTH_LONG).show();
                                        Log.d("f", "response: "+message);
                                        if (message.equalsIgnoreCase(config.RESPONSE_STATUS_VALUE_SUCCESS)) {

                                            Intent intent = new Intent(AdminSepedaCreateActivity.this, AdminSepedaActivity.class);
                                            startActivity(intent);
                                            finishAffinity();
                                        }
                                    }
                                    catch (JSONException e) {
                                        e.printStackTrace();
                                        Log.d("b", "JSONException: " + e.getMessage());
                                    }
                                }

                                @Override
                                public void onError(ANError anError) {
//                                        mProgress.dismiss();
                                    Toast.makeText(AdminSepedaCreateActivity.this, config.TOAST_AN_EROR, Toast.LENGTH_SHORT).show();
                                    Log.d("ab", "onError: " + anError.getErrorBody());
                                    Log.d("ab", "onError: " + anError.getLocalizedMessage());
                                    Log.d("ab", "onError: " + anError.getErrorDetail());
                                    Log.d("ab", "onError: " + anError.getResponse());
                                    Log.d("ab", "onError: " + anError.getErrorCode());
                                }
                            });
                }

            }
        });
    }
}