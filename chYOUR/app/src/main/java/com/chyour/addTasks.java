package com.chyour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

import chyourgui.tasks;

import static chyourgui.TaskManagement.editClicked;
import static chyourgui.tasks.currentId;
import static chyourgui.tasks.taskMap;


public class addTasks extends AppCompatActivity implements View.OnClickListener {

    static int code;
    Button bAdd;
    EditText titleVar;
    EditText descriptionVar;
    EditText rangeVar;
    EditText locationVar;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    private static final String TAG = addTasks.class.getSimpleName();
    String tag_string_req = "uploadTaskList";

    // default place holders
    private int longtiude = 1234,
            lattitude = 1234,
            userId = 0001,
            date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        bAdd = (Button) findViewById(R.id.bAdd);
        titleVar = (EditText) findViewById(R.id.titleVar);
        descriptionVar = (EditText) findViewById(R.id.descriptionVar);
        rangeVar = (EditText) findViewById(R.id.rangeVar);
        locationVar = (EditText) findViewById(R.id.locationVar);
        bAdd.setOnClickListener(this);
        spinner1 = (Spinner) findViewById(R.id.month);
        spinner2 = (Spinner) findViewById(R.id.day);
        spinner3 = (Spinner) findViewById(R.id.hour);
        spinner4 = (Spinner) findViewById(R.id.minute);
        spinner5 = (Spinner) findViewById(R.id.ampm);

        if (editClicked == 1) {

            titleVar.setText(taskMap.get(currentId).get(0));
            descriptionVar.setText(taskMap.get(currentId).get(1));
            rangeVar.setText(taskMap.get(currentId).get(2));
            locationVar.setText(taskMap.get(currentId).get(3));

            ArrayAdapter myAdap1 = (ArrayAdapter) spinner1.getAdapter();
            int spinnerPosition1 = myAdap1.getPosition(taskMap.get(currentId).get(4));
            spinner1.setSelection(spinnerPosition1);

            ArrayAdapter myAdap2 = (ArrayAdapter) spinner2.getAdapter();
            int spinnerPosition2 = myAdap2.getPosition(taskMap.get(currentId).get(5));
            spinner2.setSelection(spinnerPosition2);

            ArrayAdapter myAdap3 = (ArrayAdapter) spinner3.getAdapter();
            int spinnerPosition3 = myAdap3.getPosition(taskMap.get(currentId).get(6));
            spinner3.setSelection(spinnerPosition3);


            ArrayAdapter myAdap4 = (ArrayAdapter) spinner4.getAdapter();
            int spinnerPosition4 = myAdap4.getPosition(taskMap.get(currentId).get(7));
            spinner4.setSelection(spinnerPosition4);

            ArrayAdapter myAdap5 = (ArrayAdapter) spinner5.getAdapter();
            int spinnerPosition5 = myAdap5.getPosition(taskMap.get(currentId).get(8));
            spinner5.setSelection(spinnerPosition5);

        }



    }

    @Override
    public void onClick(View v) {


        String month = spinner1.getSelectedItem().toString();
        String day = spinner2.getSelectedItem().toString();
        String hour = spinner3.getSelectedItem().toString();
        String minute = spinner4.getSelectedItem().toString();
        String ampm = spinner5.getSelectedItem().toString();

        switch (v.getId()) {

            case R.id.bAdd:

                if (titleVar.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if (descriptionVar.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                if (rangeVar.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }



                List list = new ArrayList<>();
                list.add(titleVar.getText().toString());
                list.add(descriptionVar.getText().toString());
                list.add(rangeVar.getText().toString());
                list.add(locationVar.getText().toString());
                list.add(month);
                list.add(day);
                list.add(hour);
                list.add(minute);
                list.add(ampm);

                if (editClicked == 1) {
                    taskMap.put(code, list);

                    editClicked = 0;
                    startActivity(new Intent(this, tasks.class));
                    break;
                } else {
                    date = 110101;
                    registerTask(userId, titleVar.getText().toString() , descriptionVar.getText().toString(),
                            date, locationVar.getText().toString(),rangeVar.getText().toString(), lattitude, longtiude);

                    taskMap.put(code += 1, list);
                    startActivity(new Intent(this, tasks.class));
                    break;
                }

        }
    }


    private void registerTask(final int userId, final String title ,final String descriptionVar, final int date,
                              final String locationVar,final String range, final int lattitude, final int longtiude) {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("128.205.44.23")
                .appendPath("chyour")
                .appendPath("addTask.php")
                .appendQueryParameter("userID", String.valueOf(userId))
                .appendQueryParameter("taskTitle", title)
                .appendQueryParameter("description", descriptionVar)
                .appendQueryParameter("date", String.valueOf(date))
                .appendQueryParameter("address", locationVar)
                .appendQueryParameter("taskRange", String.valueOf(range))
                .appendQueryParameter("latitude", String.valueOf(lattitude))
                .appendQueryParameter("longitude", String.valueOf(longtiude));

        final String uri = builder.build().toString();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                uri, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Saved in jarvis!!!", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "upload error " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}

