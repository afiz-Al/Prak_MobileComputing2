package com.example.prak_pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    String EmailHolder;
    TextView Email;
    Button LogOUT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Email = (TextView)findViewById(R.id.textEmail);
        LogOUT = (Button)findViewById(R.id.buttonLogOut);

        Intent intent = getIntent();

        EmailHolder =
                intent.getStringExtra(MainActivity.UserEmail);
        Email.setText(Email.getText().toString()+ EmailHolder);

        LogOUT.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view) {
            finish();
            }
    });
    }
}