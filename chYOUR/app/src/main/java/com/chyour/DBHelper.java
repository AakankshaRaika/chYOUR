package com.chyour;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.StreamConfigurationMap;

/**
 * Created by yoseph on 9/29/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_version = 1;
    


    public static final String DB_NAME = "chyour_db";
    public static final String TABLE_NAME = "task_table";
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "NAME";
    public static final String COLUMN_3 = "LOCATION";
    public static final String COLUMN_4 = "START_TIME";
    public static final String COLUMN_5 = "END_TIME";
    
    
    /* 
        Create_table is a string used to mimic SQL statment that is passed to the SQLite db.
        it creates a table with all the above columns and  ID as the primary key
    */
    public static final String Create_table = "CREATE TABLE " + TABLE_NAME +
            " (" + COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_2 + "TEXT" + COLUMN_3 + "TEXT" + COLUMN_4 + " TEXT NOT NULL"+
            COLUMN_5 +" TEXT NOT NULL );";



    public DBHelper(Context context) {          //constructor
        super(context, DB_NAME, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {   // creates the above mentioned table

        db.execSQL(Create_table);

    }
    
    
    // deletes previous table if a new version comes along, then calls on create to create a new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }
    
    
    //  this function takes in name, location, start and finish time inserts them to their corrosponding column

    public boolean insert (String name, String location, String startTime , String endTime){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        
        //sets each values to its respective column
        contentValues.put(COLUMN_2, name);
        contentValues.put(COLUMN_3, location);
        contentValues.put(COLUMN_4, startTime);
        contentValues.put(COLUMN_5, endTime);
        
        // inserts it into the above table
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;


    }
}

