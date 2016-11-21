package com.chyour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import chyourgui.signIn;

public class contactUs extends AppCompatActivity implements View.OnClickListener {

    Button buttonContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttoncontact);

        buttonContact = (Button) findViewById(R.id.buttonContact);
        buttonContact.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonContact:
                startActivity(new Intent(this, signIn.class));
                break;
        }
    }
}