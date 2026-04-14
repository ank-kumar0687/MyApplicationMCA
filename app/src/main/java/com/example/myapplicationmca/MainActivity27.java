package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity27 extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main27);

        tvData = findViewById(R.id.tvData);

        fetchJSON();
    }

    private void fetchJSON() {
        new Thread(() -> {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/users");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                parseJSON(result.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void parseJSON(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);

            StringBuilder data = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String name = obj.getString("name");
                String email = obj.getString("email");

                data.append("Name: ").append(name)
                        .append("\nEmail: ").append(email)
                        .append("\n\n");
            }

            runOnUiThread(() -> tvData.setText(data.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}