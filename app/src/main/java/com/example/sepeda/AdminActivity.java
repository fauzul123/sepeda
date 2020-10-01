package com.example.sepeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.sepeda.Admin.DetailAdminActivity;
import com.example.sepeda.Admin.list_data_customerActivity;

public class AdminActivity extends AppCompatActivity {

   private CardView daftarsepeda, daftarcustomer;
   private ImageView ivProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        daftarcustomer = findViewById(R.id.daftarcustomer);
        daftarcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, list_data_customerActivity.class);
                startActivity(i);
            }
        });
        ivProfile = findViewById(R.id.ivProfile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, DetailAdminActivity.class);
                startActivity(i);
            }
        });
    }
}