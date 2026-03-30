package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity13 extends AppCompatActivity {

    TextView t1, t2;
    Button b1, b2;
    EditText ed1;
    RecyclerView r1;
    String[] data = {"Apple", "Banana", "Mango", "Orange", "Grapes","Apple",  "Orange", "Grapes","Apple", "Banana", "Mango", "Orange", "Grapes","Apple", "Banana", "Mango", "Orange", "Grapes"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main13);

        r1 = findViewById(R.id.r1);

        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.setAdapter(new MainActivity13.SimpleAdapter());

    }
    class SimpleAdapter extends RecyclerView.Adapter<MainActivity13.SimpleAdapter.ViewHolder>{

        @NonNull
        @Override
        public MainActivity13.SimpleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
            return new MainActivity13.SimpleAdapter.ViewHolder(view);




        }

        @Override
        public void onBindViewHolder(@NonNull MainActivity13.SimpleAdapter.ViewHolder holder, int position) {
            holder.textView.setText(data[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity13.this, MainActivity12.class);

                    // Data pass karna (optional)

                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.length;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);

            }
        }
    }
}