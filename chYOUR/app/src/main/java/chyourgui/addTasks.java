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
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class addTasks extends AppCompatActivity implements View.OnClickListener {

    static List taskInfo = new ArrayList<>();
    Button bAdd;
    EditText titleVar;
    EditText descriptionVar;
    EditText rangeVar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        bAdd = (Button) findViewById(R.id.bAdd);
        titleVar = (EditText)findViewById(R.id.titleVar);
        descriptionVar = (EditText)findViewById(R.id.descriptionVar);
        rangeVar = (EditText)findViewById(R.id.rangeVar);

        bAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Spinner spinner1 = (Spinner)findViewById(R.id.month);
        String month = spinner1.getSelectedItem().toString();
        Spinner spinner2 = (Spinner)findViewById(R.id.day);
        String day = spinner2.getSelectedItem().toString();
        Spinner spinner3 = (Spinner)findViewById(R.id.hour);
        String hour = spinner3.getSelectedItem().toString();
        Spinner spinner4 = (Spinner)findViewById(R.id.minute);
        String minute = spinner4.getSelectedItem().toString();
        Spinner spinner5 = (Spinner)findViewById(R.id.ampm);
        String ampm = spinner5.getSelectedItem().toString();

        switch (v.getId()) {
            case R.id.bAdd:

                if(titleVar.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if(descriptionVar.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                if(rangeVar.getText().toString().length() < 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                taskInfo.add(titleVar.getText().toString() +'\n'+ descriptionVar.getText().toString()+'\n'+"Range: "+rangeVar.getText().toString()+'\n'+
                        "Due Date: "+month+"/"+day+'\n'+"Time Due: "+hour+":"+minute+" "+ampm);
                startActivity(new Intent(this, tasks.class));
                break;
        }
    }
}
