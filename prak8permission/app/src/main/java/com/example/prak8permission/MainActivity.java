package com.example.prak8permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lstview);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
// memeriksa apakah izin kontak baca diberikan.
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS) !=
                PackageManager.PERMISSION_GRANTED){
// meminta izin kepada pengguna.
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.READ_CONTACTS}, 100);
        }else {
// jika aplikasi sudah memiliki izin, blok ini akan dijalankan.
            readContacts();
        }
    }
    // jika pengguna mengklik ALLOW dalam dialog, metode ini dipanggil.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
            permission, @NonNull int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permission, grantResult);
        readContacts();
    }
    // berfungsi untuk membaca kontak menggunakan penyelesai konten
    @SuppressLint("Range")
    private void readContacts(){
        ContentResolver contentResolver=getContentResolver();
        Cursor
                cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,
                null,null);
        if (cursor.moveToFirst()){ do {
            arrayList.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        }while (cursor.moveToNext());
            arrayAdapter.notifyDataSetChanged();
        }
    }
}