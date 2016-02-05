package com.example.alex.homework7android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textName = (TextView)findViewById(R.id.name_second);
        TextView textEmail = (TextView)findViewById(R.id.email_second);
        TextView textPhoneNumber = (TextView)findViewById(R.id.phone_number_second);
        TextView textAdress = (TextView)findViewById(R.id.adress_second);

        String name = "";
        String email = "";
        String phoneNumber = "";
        String adress = "";

        MainActivity.Variables variables = (MainActivity.Variables) getIntent().getParcelableExtra("Variables");
        name = variables.getSname();
        email = variables.getSemail();
        phoneNumber = variables.getSphoneNumber();
        adress = variables.getSadress();

        textName.setText(name);
        textEmail.setText(email);
        textPhoneNumber.setText(phoneNumber);
        textAdress.setText(adress);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



}
