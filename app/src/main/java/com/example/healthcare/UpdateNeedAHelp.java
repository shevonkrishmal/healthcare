package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateNeedAHelp extends AppCompatActivity {

    public Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_need_a_help);

        btnDelete = (Button) findViewById(R.id.btnPayment);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateNeedAHelp.this, DeleteNeedAHelp.class);
                startActivity(intent);
            }
        });
    }
}