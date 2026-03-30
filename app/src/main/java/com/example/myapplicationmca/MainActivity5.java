package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity5 extends AppCompatActivity {

    TextView t1, t2;
    Button b1, b2;
    EditText ed1;
    RecyclerView r1;
    String[] data = {"Apple", "Banana", "Mango", "Orange", "Grapes","Apple", "Banana", "Mango", "Orange", "Grapes","Apple", "Banana", "Mango", "Orange", "Grapes","Apple", "Banana", "Mango", "Orange", "Grapes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        r1 = findViewById(R.id.r1);

        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.setAdapter(new SimpleAdapter());


    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder>{

        @NonNull
        @Override
        public SimpleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull SimpleAdapter.ViewHolder holder, int position) {
            holder.textView.setText(data[position]);

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