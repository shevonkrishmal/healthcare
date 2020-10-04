package com.example.healthcare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Doctor_channelingDetails extends AppCompatActivity {
     private TextView R_Roomnum,R_Atime,R_Adate,R_Dfee;

    private FirebaseAuth auth;
    private FirebaseFirestore fstore;

    private String DoctorID;
    private FirebaseUser doctor;
    private Button Ceditbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_channeling_details);

        R_Roomnum= findViewById(R.id.roomnum);
        R_Adate = findViewById(R.id.Adate);
        R_Atime = findViewById(R.id.Atime);
        R_Dfee = findViewById(R.id.channelingfee);
        Ceditbtn = findViewById(R.id.Ceditbtn);
        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        DoctorID = auth.getCurrentUser().getUid();
        doctor = auth.getCurrentUser();

        final DocumentReference documentReference = fstore.collection("Doctors").document(DoctorID);

        documentReference.addSnapshotListener(Doctor_channelingDetails.this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                R_Roomnum.setText(documentSnapshot.getString("room number"));
                R_Adate.setText(documentSnapshot.getString("Appointmentdate"));
                R_Atime.setText(documentSnapshot.getString("Appointmenttime"));
                R_Dfee.setText(documentSnapshot.getString("Doctorfee"));



            }
        });

        Ceditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Doctor_channelingDetails_edit.class);
                startActivity(intent);
            }
        });

    }
}