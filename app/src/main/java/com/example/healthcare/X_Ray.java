package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class X_Ray extends AppCompatActivity {
    Button buttonX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x__ray);

        buttonX = (Button) findViewById(R.id.buttonTest);
        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentxray = new Intent(X_Ray.this, RequestForm.class);
                startActivity(intentxray);
            }
        });
    }
}