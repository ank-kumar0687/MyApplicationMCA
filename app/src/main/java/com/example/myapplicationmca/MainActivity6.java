package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    String correctUsername = "Ankit";
    String correctPassword = "Ankit12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.equals(correctUsername) && password.equals(correctPassword)) {

                    Toast.makeText(MainActivity6.this,
                            "Login Successful",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity6.this, MainActivity7.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);

                } else {

                    Toast.makeText(MainActivity6.this,
                            "Invalid Username or Password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
