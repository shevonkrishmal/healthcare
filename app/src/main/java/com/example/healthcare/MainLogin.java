package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLogin extends AppCompatActivity {
Button alog,dlog,plog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        alog = (Button)findViewById(R.id.aLog);
        dlog = (Button)findViewById(R.id.dLog);
        plog = (Button)findViewById(R.id.pLog);

        alog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this,
                        adminLogin.class);
                startActivity(intent);
            }
        });

        dlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this,
                        Doctor_Login.class);
                startActivity(intent);
            }
        });

        plog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this,
                        patientLogin.class);
                startActivity(intent);
            }
        });

}
}