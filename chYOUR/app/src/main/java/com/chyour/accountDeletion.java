package com.chyour;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import chyourgui.signIn;

public class accountDeletion extends AppCompatActivity implements View.OnClickListener {

    EditText deleteVar1;
    EditText deleteVar2;
    EditText deleteVar3;

    Button bGoback6;
    Button bDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_deletion);

        bGoback6 = (Button) findViewById(R.id.bGoBack6);
        bDelete = (Button) findViewById(R.id.bDelete);

        deleteVar1 = (EditText) findViewById(R.id.deleteVar1);
        deleteVar2 = (EditText) findViewById(R.id.deleteVar2);
        deleteVar3 = (EditText) findViewById(R.id.deleteVar3);

        bGoback6.setOnClickListener(this);
        bDelete.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bGoBack6:
                startActivity(new Intent(this, accountManagement.class));
                break;

            case R.id.bDelete:

                if (deleteVar1.getText().toString().length() < 1 ||
                        deleteVar2.getText().toString().length() < 1 ||
                        deleteVar3.getText().toString().length() < 1 ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountDeletion.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                if (!(deleteVar2.getText().toString().equals(deleteVar3.getText().toString()))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountDeletion.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Password and Confirm Password aren't the same");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }



                startActivity(new Intent(this, signIn.class));
                break;


        }
    }
}
