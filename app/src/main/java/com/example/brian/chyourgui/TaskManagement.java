package com.example.brian.chyourgui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static com.example.brian.chyourgui.addTasks.taskInfo;
import static com.example.brian.chyourgui.tasks.currentId;

public class TaskManagement extends AppCompatActivity implements View.OnClickListener {

    Button gpsVar;
    Button toggleVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_management);

        gpsVar =  (Button) findViewById(R.id.gpsVar);
        toggleVar=  (Button) findViewById(R.id.toggleVar);
        gpsVar.setOnClickListener(this);
        toggleVar.setOnClickListener(this);

        LinearLayout layout = (LinearLayout) findViewById(R.id.tmLayout);

        TextView tv = new TextView(this);
        tv.setTextSize(15);
        tv.setGravity(Gravity.CENTER);
        tv.setText(taskInfo.get(currentId).toString());
        layout.addView(tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gpsVar:
                break;

            case R.id.toggleVar:
                taskInfo.remove(currentId);
                startActivity(new Intent(this, tasks.class));
                break;
        }
    }
}
