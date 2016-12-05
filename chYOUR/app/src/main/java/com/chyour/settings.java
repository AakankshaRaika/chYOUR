package com.chyour;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import chyourgui.signIn;
import chyourgui.tasks;

import static chyourgui.tasks.currentId;
import static chyourgui.tasks.taskMap;
import static com.chyour.R.styleable.MenuItem;

public class settings extends AppCompatActivity implements View.OnClickListener {

    static int notifications = 1;
    Button bSignOut;
    Button bNotifications;
    Button bManageAccount;
    Button bGoBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bSignOut = (Button) findViewById(R.id.bSignOut);
        bNotifications = (Button) findViewById(R.id.bNotifications);
        bManageAccount = (Button) findViewById(R.id.bManageAccount);
        bGoBack2 = (Button) findViewById(R.id.bGoBack2);
        bGoBack2.setOnClickListener(this);
        bSignOut.setOnClickListener(this);
        bNotifications.setOnClickListener(this);
        bManageAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSignOut:
                startActivity(new Intent(this, signIn.class));
                break;

            case R.id.bNotifications:
                if(notifications == 1){
                notifications = 0;
            }
                else{
                    notifications = 1;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(settings.this);
                builder.setTitle("Alert");
                builder.setMessage("Notifications coming soon :)");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;

            case R.id.bManageAccount:
                startActivity(new Intent(this, accountManagement.class));
                break;

            case R.id.bGoBack2:
                startActivity(new Intent(this, tasks.class));
                break;

        }
    }
}
