//package com.chyour;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
///*
// * Skeleton code author : @aakanksh @yosephh
// * Task owners sprint 2 : Aakanksha Barry and Yosephh
// * by default a person NEEDS to :
// * 1) add the task title
// * 2)add the date
// * 3)add the category
// * 4) if and only if the category is "other" a person will also be required to specify the location.
// * Adding location and time is completely users choice. is not needed to add the task.
// *
// */
//public class Add extends AppCompatActivity {
//
//    DBHelper myDb;
//    EditText editName, editLocation, editStart ,editFinish;     // variables for input from screen
//    Button btnAddData;                                          // variable for Button
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_tasks);
//        myDb = new DBHelper(this);
//
//
//        //    what i have done below is cast each input and assign them to their corrosponding variables
//
//        editName = (EditText)findViewById(R.id.task_title);
//        editLocation = (EditText)findViewById(R.id.locationVar);
////        editStart = (EditText)findViewById(R.id.editText_start_time);
////        editFinish = (EditText)findViewById(R.id.editText_end_time);
//        btnAddData = (Button) findViewById(R.id.bAdd);
//
//    }
//
//    public Add(){
//        btnAddData.setOnClickListener(                  // listens for when the when the button is pressed
//                                      new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // below the values are converted to a string and added to the table in created by DBhelper
//
//                boolean isInserted =  myDb.insert(editName.getText().toString(),
//                                                  editLocation.getText().toString(),
//                                                  editStart.getText().toString(),
//                                                  editFinish.getText().toString());
//
//                // the if statment below displays confirmation messege to app screen
//                if(isInserted == true)
//                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//    }
//
//
//
//    public void add_task(){
//        /*
//         * this will only be connected to the button and will execute things.
//         */
//    }
//
//    public void set_Task_Name(){
//        //add the task name here
//    }
//
//    public void get_Task_Name(){
//        //returns the task name
//    }
//
//    public void set_Date(){
//        //sets date when the task needs to be done
//    }
//    public void get_Date(){
//        //returns the date
//    }
//    public void set_Time(){
//        //sets time when the tasks needs to be done
//    }
//    public void get_Time(){
//        //returns time
//    }
//    public void set_Location(){
//        //sets location if different from the default
//    }
//    public void get_Location(){
//        //returns location
//    }
//    public void set_Category(){
//        //sets category
//    }
//    public void get_Category(){
//        //returns category
//    }
//}
