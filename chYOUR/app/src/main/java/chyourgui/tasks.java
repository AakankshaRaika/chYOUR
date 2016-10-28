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

public class tasks extends AppCompatActivity implements View.OnClickListener {

    static List taskID = new ArrayList<>();
    static int currentId;
    Button bAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        addTasks addTasks = new addTasks();
        List taskInfo = new ArrayList();
        taskInfo = addTasks.taskInfo;
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        if(taskInfo.size() < 1){
            TextView tv = new TextView(this);
            tv.setTextSize(50);
            tv.setGravity(Gravity.CENTER);
            tv.setText("Currently no tasks");
            layout.addView(tv);
        }

        for (int i = 0; i < taskInfo.size(); i++)
        {
            Button bt = new Button(this);
            bt.setTextSize(10);
            bt.setBackgroundColor(0xffff0000);
            bt.setText(taskInfo.get(i).toString());
            layout.addView(bt);

            bt.setId(i);
            taskID.add(bt.getId());
            bt.setOnClickListener(this);
        }

        bAddTask = (Button) findViewById(R.id.bAddTask);
        bAddTask.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bAddTask:
                startActivity(new Intent(this, addTasks.class));
                break;

            default:
                if(taskID.contains(v.getId())){
                    currentId = v.getId();
                    startActivity(new Intent(this, TaskManagement.class));
                }
        }
    }
}