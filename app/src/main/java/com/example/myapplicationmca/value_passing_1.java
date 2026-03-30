package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class value_passing_1 extends AppCompatActivity {

    EditText firstname,lastname,mobilenumber,emailaddress,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_value_passing1);

        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        mobilenumber = findViewById(R.id.email);
        emailaddress = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btnsubmit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first_name = firstname.getText().toString().trim();
                String last_name = lastname.getText().toString().trim();
                String mobile_number = mobilenumber.getText().toString().trim();
                String email_address = emailaddress.getText().toString().trim();
                String password_p = password.getText().toString().trim();

                if(first_name.isEmpty() || last_name.isEmpty() || mobile_number.isEmpty() || email_address.isEmpty() || password_p.isEmpty())
                {
                    Toast.makeText(value_passing_1.this, "Fill UP THE ALL FEILDS", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(value_passing_1.this, value_passing_2.class);
                    i.putExtra("fname",first_name);
                    i.putExtra("lname",last_name);
                    i.putExtra("mobile",mobile_number);
                    i.putExtra("email",email_address);
                    i.putExtra("password",password_p);
                    startActivity(i);
                }
            }
        });


    }
}