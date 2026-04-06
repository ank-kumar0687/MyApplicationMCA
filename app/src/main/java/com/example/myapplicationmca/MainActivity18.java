package com.example.myapplicationmca;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity18 extends AppCompatActivity {
    ListView listView;
    ArrayList<String> contacts = new ArrayList<>();
    ArrayList<String> phoneNumbers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main18);
        listView = findViewById(R.id.listView);

        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS)
                != getPackageManager().PERMISSION_GRANTED) {

            requestPermissions(
                    new String[]{android.Manifest.permission.READ_CONTACTS},
                    1
            );
        } else {
            loadContacts(); // call only if permission already granted
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contacts
        );

        listView.setAdapter(adapter);

        // Click event
        listView.setOnItemClickListener((parent, view, position, id) -> {

            String number = phoneNumbers.get(position);

            // Open Dialer
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        });
    }

    private void loadContacts() {

        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {

                String name = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                String phone = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));

                contacts.add(name + " - " + phone);
                phoneNumbers.add(phone);
            }
            cursor.close();
        }

    }
}