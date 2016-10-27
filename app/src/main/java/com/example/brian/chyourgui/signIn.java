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

import java.util.List;
import java.util.Map;

public class signIn extends AppCompatActivity implements View.OnClickListener {

    Button bSignUp;
    Button bSignIn;
    EditText passwordVar;
    EditText emailVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailVar =  (EditText)findViewById(R.id.emailVar);
        passwordVar =  (EditText)findViewById(R.id.passwordVar);
        bSignIn =  (Button) findViewById(R.id.bSignIn);
        bSignUp =  (Button) findViewById(R.id.bSignUp);
        bSignIn.setOnClickListener(this);
        bSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSignIn:
                registration registration = new registration();
                Map<String, List<String>> map;
                map = registration.map;

                if(map.size() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Wrong Username and or Password");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if(map.containsKey(emailVar.getText().toString()) == false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Wrong Username and or Password");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if(map.get(emailVar.getText().toString()).get(1).equals(passwordVar.getText().toString()) == false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Wrong Username and or Password");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                startActivity(new Intent(this, tasks.class));
                break;

            case R.id.bSignUp:
                startActivity(new Intent(this, registration.class));
                break;
        }
    }
}
