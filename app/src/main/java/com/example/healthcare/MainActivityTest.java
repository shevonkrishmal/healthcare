package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTest extends AppCompatActivity {
    public Button button;
    public Button buttonX;
    public Button buttonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        button = (Button) findViewById(R.id.btnLab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityTest.this, LabTest.class);
                startActivity(intent);
            }
        });

        buttonX = (Button) findViewById(R.id.btnX);
        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentx = new Intent(MainActivityTest.this, TakeX_Ray.class);
                startActivity(intentx);
            }
        });

        buttonS = (Button) findViewById(R.id.btnScan);
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentS = new Intent(MainActivityTest.this, TakeScans.class);
                startActivity(intentS);
            }
        });
    }
}