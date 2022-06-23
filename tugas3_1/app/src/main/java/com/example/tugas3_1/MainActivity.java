package com.example.tugas3_1;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    String TAG = "Main Activity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        EditText inputNamaTimA = findViewById(R.id.editTextA);
        EditText inputNamaTimB = findViewById(R.id.editTextB);
        String namaTimA = inputNamaTimA.getText().toString();
        Log.d(TAG, namaTimA);
        String namaTimB = inputNamaTimB.getText().toString();
        Log.d(TAG, namaTimB);
        Intent intent = new Intent(this, dua_skor_activity.class);
        intent.putExtra("Tim A", namaTimA);
        intent.putExtra("Tim B", namaTimB);
        startActivity(intent);
    }
}