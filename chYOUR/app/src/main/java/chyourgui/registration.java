package com.example.brian.chyourgui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class registration extends AppCompatActivity implements View.OnClickListener {

    static Map<String, List<String>> map = new HashMap<>();

    Button bSignUp;
    Button bGoBack;
    EditText fName;
    EditText lName;
    EditText emailVar;
    EditText passwordVar;
    EditText confirmPasswordVar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fName =  (EditText)findViewById(R.id.fName);
        lName =  (EditText)findViewById(R.id.lName);
        passwordVar =  (EditText)findViewById(R.id.passwordVar);
        confirmPasswordVar =  (EditText)findViewById(R.id.confirmPasswordVar);
        emailVar =  (EditText)findViewById(R.id.emailVar);
        bSignUp =  (Button) findViewById(R.id.bSignUp);
        bGoBack =  (Button) findViewById(R.id.bGoBack);
        bSignUp.setOnClickListener(this);
        bGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bSignUp:
                List info = new ArrayList<>();
                info.add(emailVar.getText().toString());
                info.add(passwordVar.getText().toString());
                info.add(fName.getText().toString());
                info.add(lName.getText().toString());
                info.add(confirmPasswordVar.getText().toString());

                if(fName.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(registration.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if(lName.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(registration.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                if(emailVar.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(registration.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                    }
                if(passwordVar.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(registration.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if(confirmPasswordVar.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(registration.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if(passwordVar.getText().toString().equals(confirmPasswordVar.getText().toString()) == false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(registration.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Passwords are not the Same");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                map.put(emailVar.getText().toString(), info);
                startActivity(new Intent(this, signIn.class));
                break;


            case R.id.bGoBack:
                startActivity(new Intent(this, signIn.class));
                break;
        }
    }
}

