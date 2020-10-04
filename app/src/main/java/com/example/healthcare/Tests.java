package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tests extends AppCompatActivity {
    Button buttonTets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        buttonTets = (Button) findViewById(R.id.buttonTest);
        buttonTets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTests = new Intent(Tests.this, RequestForm.class);
                startActivity(intentTests);
            }
        });
    }
}