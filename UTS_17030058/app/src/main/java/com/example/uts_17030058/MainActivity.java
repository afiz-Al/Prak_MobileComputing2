package com.example.uts_17030058;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eJari, eLuas, eVolume, eTinggi, eSelimut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myClickHandler(View v){
        eJari = (EditText) findViewById(R.id.ejari);
        eTinggi = (EditText) findViewById(R.id.etinggi);
        eLuas = (EditText) findViewById(R.id.eluas);
        eVolume = (EditText) findViewById(R.id.evolume);
        eSelimut = (EditText) findViewById(R.id.eselimut);


        switch (v.getId()){
            case R.id.btnproses:

                int jari = Integer.parseInt(eJari.getText().toString());
                int tinggi = Integer.parseInt(eTinggi.getText().toString());

                double selimut = Math.sqrt((jari*jari) + (tinggi*tinggi));
                eSelimut.setText(String.valueOf(selimut));

                double luas = Math.PI * jari * selimut ;
                double volume = Math.PI * jari * jari * tinggi / 3;
                eLuas.setText(String.valueOf(luas));
                eVolume.setText(String.valueOf(volume));

                break;

            case R.id.btnhapus:
                eJari.setText("");
                eTinggi.setText("");
                eSelimut.setText("");
                eLuas.setText("");
                eVolume.setText("");

                break;
        }
    }

}