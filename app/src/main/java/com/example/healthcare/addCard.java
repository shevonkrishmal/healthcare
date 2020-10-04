package com.example.healthcare;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;

public class addCard extends AppCompatActivity {

        CardForm cardForm;
        Button buy;
        AlertDialog.Builder alertBuilder;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_card);


            cardForm = findViewById(R.id.card_form);
            buy = findViewById(R.id.btnBuy);
            cardForm.cardRequired(true)
                    .expirationRequired(true)
                    .cvvRequired(true)


                    .mobileNumberExplanation("SMS is required on this number")
                    .setup(addCard.this);
            cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    if (cardForm.isValid()) {
                        alertBuilder = new AlertDialog.Builder(addCard.this);
                        alertBuilder.setTitle("Confirm before purchase");
                        alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                                "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                                "Card CVV: " + cardForm.getCvv() + "\n" +


                        alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Toast.makeText(addCard.this, "Thank you for purchase", Toast.LENGTH_LONG).show();
                            }
                        }));
                        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        AlertDialog alertDialog = alertBuilder.create();
                        alertDialog.show();

                    } else {
                        Toast.makeText(addCard.this, "Please complete the form", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }