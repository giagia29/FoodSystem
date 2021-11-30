package com.example.foodsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreditCard extends AppCompatActivity {
    String cnum,cdate,cardv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        Button button = findViewById(R.id.button);
        TextView cvv,cn,ed;
        EditText num,cv,date;
        num = findViewById(R.id.Num);
        cv = findViewById(R.id.CV);
        date = findViewById(R.id.Date);
        cvv = findViewById(R.id.CVV);
        cn = findViewById(R.id.CN);
        ed = findViewById(R.id.ED);
        cvv.setPaintFlags(cvv.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG|Paint.UNDERLINE_TEXT_FLAG);
        cn.setPaintFlags(cn.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG|Paint.UNDERLINE_TEXT_FLAG);
        ed.setPaintFlags(ed.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG|Paint.UNDERLINE_TEXT_FLAG);

        button.setOnClickListener(v -> {
            if(cv.getText().toString().isEmpty() || num.getText().toString().isEmpty()|| date.getText().toString().isEmpty()){
                cvv.setText("");
                cn.setText("");
                ed.setText("");
                Toast.makeText(this,"No input try again",Toast.LENGTH_SHORT).show();
            }else if(cv.getText().toString().length() < 3 || cv.getText().toString().length() > 3){
                Toast.makeText(this,"Card Cvv should be 3 digits",Toast.LENGTH_SHORT).show();
            }else if (num.getText().toString().length() < 16 || num.getText().toString().length() > 16){

                Toast.makeText(this,"Card Number should be 16 digits",Toast.LENGTH_SHORT).show();

            }else if (date.getText().toString().length() < 10 || date.getText().toString().length() > 10){
                Toast.makeText(this,"Exp not valid should be in month/date/year 04/15/2021 format",Toast.LENGTH_SHORT).show();
            }else{
                Intent downloadIntent = new Intent(getApplicationContext(),DeliveryMethod.class);
                startActivity(downloadIntent);
            }
        });



    }
}