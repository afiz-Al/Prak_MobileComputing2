package com.example.tugas3_1;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dua_skor_activity extends AppCompatActivity {
    int skorA = 0;
    int skorB = 0;
/*    int SkorA1=0;
    int SkorA2=0;
    int SkorA3=0;
    private TextView mTextNumber;
    private Button mButton;
    private Button mButton2;
    private Button mButton3;*/

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_skor);

        TextView namaTimA = findViewById(R.id.tv_Tim_A);
        TextView namaTimB = findViewById(R.id.tv_Tim_B);

        String namaA = getIntent().getStringExtra("Tim A");
        String namaB = getIntent().getStringExtra("Tim B");

        namaTimA.setText("Team" + " " + namaA);
        namaTimB.setText("Team" + " " + namaB);

     /*mTextNumber = findViewById(R.id.textViewPointA);
        mButton = findViewById(R.id.satu_poinA);
        mButton2 = findViewById(R.id.dua_poinA);
        mButton3 = findViewById(R.id.tiga_poinA);

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //mCount akan ditambah dengan 1 setiap klik
                skorA = skorA + 1;

                //mTextNumber akan menampilkan nilai dari mCount
                mTextNumber.setText(String.valueOf(skorA));
            }
        }
        );*/

    }

   public void Tambah (View view) {
        if (view.getId() == R.id.satu_poinA) {
            skorA = skorA + 1;
        } else if (view.getId() == R.id.dua_poinA) {
            skorA = skorA + 2;
        } else if (view.getId() == R.id.tiga_poinA) {
            skorA = skorA + 3;
        } else if (view.getId() == R.id.satu_poinB) {
            skorB = skorB + 1;
        } else if (view.getId() == R.id.dua_pointB) {
            skorB = skorB + 2;
        } else if (view.getId() == R.id.tiga_poinB) {
            skorB = skorB + 3;
        }

        TextView skorTimA = findViewById(R.id.textViewPointA);
        TextView skorTimB = findViewById(R.id.textViewPointB);

        skorTimA.setText(String.valueOf(skorA));
        skorTimB.setText(String.valueOf(skorB));
    }
}