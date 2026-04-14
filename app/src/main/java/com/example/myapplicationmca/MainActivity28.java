package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity28 extends AppCompatActivity {

    EditText etId, etFname, etLname, etMob, etAddr, etCity, etSpec;
    Button btnSubmit, btnGoSearch;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main28);

        etId = findViewById(R.id.etId);
        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        etMob = findViewById(R.id.etMob);
        etAddr = findViewById(R.id.etAddr);
        etCity = findViewById(R.id.etCity);
        etSpec = findViewById(R.id.etSpec);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnGoSearch = findViewById(R.id.btnGoSearch);

        db = new DBHelper(this);

        btnSubmit.setOnClickListener(v -> {
            boolean inserted = db.insertData(
                    etId.getText().toString(),
                    etFname.getText().toString(),
                    etLname.getText().toString(),
                    etMob.getText().toString(),
                    etAddr.getText().toString(),
                    etCity.getText().toString(),
                    etSpec.getText().toString()
            );

            if (inserted)
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
        });

        btnGoSearch.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        });
    }
}