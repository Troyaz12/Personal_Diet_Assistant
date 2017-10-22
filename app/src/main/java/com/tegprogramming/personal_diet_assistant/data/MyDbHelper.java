package com.tegprogramming.personal_diet_assistant.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tegprogramming.personal_diet_assistant.data.DatabaseContract.MealEntry;

/**
 * Created by TroysMacBook on 10/22/17.
 */

public class MyDbHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "personal_diet_assistant.db";




    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //write sql to create the needed tables
       final String SQL_CREATE_MEAL_TABLE = "CREATE TABLE " + MealEntry.TABLE_NAME + " (" +
                MealEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                MealEntry.FOODITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                MealEntry.MEAL_NAME + " TEXT NOT NULL " +
                " );";

  /*      final String SQL_CREATE_EXERCISESENTRY_TABLE = "CREATE TABLE " + ExercisesEntry.TABLE_NAME + " (" +
                ExercisesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ExercisesEntry.R_ID + " TEXT NOT NULL, " +
                ExercisesEntry.EXERCISE_NAME + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_SETSENTRY_TABLE = "CREATE TABLE " + SetsEntry.TABLE_NAME + " (" +
                SetsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SetsEntry.E_ID + " TEXT NOT NULL, " +
                SetsEntry.REPS + " TEXT NOT NULL, " +
                SetsEntry.WEIGHT_LIFTED + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_PROFILEENTRY_TABLE = "CREATE TABLE " + ProfileEntry.TABLE_NAME + " (" +
                ProfileEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ProfileEntry.SEX + " TEXT NOT NULL, " +
                ProfileEntry.WEIGHT + " TEXT NOT NULL, " +
                ProfileEntry.HEIGHTCM + " TEXT NOT NULL, " +
                ProfileEntry.HEIGHTFT + " TEXT NOT NULL, " +
                ProfileEntry.HEIGHTIN + " TEXT NOT NULL, " +
                ProfileEntry.BODY_FAT + " TEXT NOT NULL, " +
                ProfileEntry.WAIST + " TEXT NOT NULL, " +
                ProfileEntry.HIPS + " TEXT NOT NULL, " +
                ProfileEntry.NECK + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_GROUPENTRY_TABLE = "CREATE TABLE " + GroupEntry.TABLE_NAME + " (" +
                GroupEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                GroupEntry.USER_NAME + " TEXT NOT NULL, " +
                GroupEntry.FIREBASE_KEY + " TEXT NOT NULL, " +
                GroupEntry.LAT + " TEXT NOT NULL, " +
                GroupEntry.LONG + " TEXT NOT NULL, " +
                GroupEntry.MESSAGE + " TEXT NOT NULL, " +
                GroupEntry.MONTH + " TEXT NOT NULL, " +
                GroupEntry.DAY + " TEXT NOT NULL, " +
                GroupEntry.YEAR + " TEXT NOT NULL, " +
                GroupEntry.HOUR + " TEXT NOT NULL, " +
                GroupEntry.MINUTES + " TEXT NOT NULL " +
                " );";


        final String SQL_CREATE_MYMESSAGESENTRY_TABLE = "CREATE TABLE " + MyMessagesEntry.TABLE_NAME + " (" +
                MyMessagesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                MyMessagesEntry.FIREBASE_KEY + " TEXT NOT NULL, " +
                MyMessagesEntry.LAT + " TEXT NOT NULL, " +
                MyMessagesEntry.LONG + " TEXT NOT NULL, " +
                MyMessagesEntry.MESSAGE + " TEXT NOT NULL, " +
                MyMessagesEntry.MONTH + " TEXT NOT NULL, " +
                MyMessagesEntry.DAY + " TEXT NOT NULL, " +
                MyMessagesEntry.YEAR + " TEXT NOT NULL, " +
                MyMessagesEntry.HOUR + " TEXT NOT NULL, " +
                MyMessagesEntry.MINUTES + " TEXT NOT NULL " +
                " );";

        //create the tables
        sqLiteDatabase.execSQL(SQL_CREATE_ROUTINE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_EXERCISESENTRY_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_SETSENTRY_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PROFILEENTRY_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_GROUPENTRY_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_MYMESSAGESENTRY_TABLE);  */

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Note that this only fires if you change the version number for your database.

  /*      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RoutineEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ExercisesEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SetsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProfileEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GroupEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MyMessagesEntry.TABLE_NAME);


        onCreate(sqLiteDatabase);
*/
    }






}
