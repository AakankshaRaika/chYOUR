package com.chyour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import chyourgui.signIn;
import chyourgui.tasks;

public class faq extends AppCompatActivity implements View.OnClickListener {

    Button bGoBack94;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        bGoBack94 = (Button) findViewById(R.id.bGoBack94);
        bGoBack94.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bGoBack94:
                startActivity(new Intent(this, signIn.class));
                break;
        }
    }
}