package com.chyour;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.chyour.SignupActivity.inputPassword;


public class accountManagement extends AppCompatActivity implements View.OnClickListener {

    Button bDeleteAccount;
    Button bUpdatePassword;
    Button bGoBack5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        bDeleteAccount = (Button) findViewById(R.id.bDeleteAccount);
        bUpdatePassword = (Button) findViewById(R.id.bUpdatePassword);
        bGoBack5 = (Button) findViewById(R.id.bGoBack5);


        bDeleteAccount.setOnClickListener(this);
        bGoBack5.setOnClickListener(this);
        bUpdatePassword.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bGoBack5:
                startActivity(new Intent(this, settings.class));
                break;

            case R.id.bDeleteAccount:
                startActivity(new Intent(this, accountDeletion.class));
                break;

            case R.id.bUpdatePassword:

                AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                builder.setTitle("Alert");
                builder.setMessage("Change password coming soon :)");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;

        }
    }
}
