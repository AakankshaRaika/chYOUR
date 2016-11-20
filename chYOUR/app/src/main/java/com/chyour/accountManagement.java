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
    EditText currentPassword1;
    EditText newPassword2;
    EditText confirmPassword1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        bDeleteAccount = (Button) findViewById(R.id.bDeleteAccount);
        bUpdatePassword = (Button) findViewById(R.id.bUpdatePassword);
        bGoBack5 = (Button) findViewById(R.id.bGoBack5);

        currentPassword1 = (EditText) findViewById(R.id.currentPassword1);
        newPassword2 = (EditText) findViewById(R.id.newPassword2);
        confirmPassword1 = (EditText) findViewById(R.id.confirmPassword1);

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

                if (currentPassword1.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if (newPassword2.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                if (confirmPassword1.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if (currentPassword1.getText().toString() != inputPassword.getText().toString()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Wrong Password");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if (newPassword2.getText().toString() != confirmPassword1.getText().toString()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                    builder.setTitle("Alert");
                    builder.setMessage("New Password and Confirm Password arent the same");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(accountManagement.this);
                builder.setTitle("Alert");
                builder.setMessage("Password has been updated");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                startActivity(new Intent(this, settings.class));
                break;

        }
    }
}
