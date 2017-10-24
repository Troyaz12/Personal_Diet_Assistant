package com.tegprogramming.personal_diet_assistant.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tegprogramming.personal_diet_assistant.data.DatabaseContract.DishEntry;
import com.tegprogramming.personal_diet_assistant.data.DatabaseContract.MealEntry;
import com.tegprogramming.personal_diet_assistant.data.DatabaseContract.IngredientEntry;

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
                MealEntry.FOODITEM_ID + " TEXT NOT NULL,"+
                MealEntry.MEAL_NAME + " TEXT NOT NULL " +
                " );";

       final String SQL_CREATE_DISHENTRY_TABLE = "CREATE TABLE " + DishEntry.TABLE_NAME + " (" +
                DishEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                DishEntry.FOODITEM_ID + " TEXT NOT NULL, " +
                DishEntry.DISH_NAME + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_INGREDIENT_TABLE = "CREATE TABLE " + IngredientEntry.TABLE_NAME + " (" +
                IngredientEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                IngredientEntry.INGREDIENT_NAME + " TEXT NOT NULL, " +
                IngredientEntry.PROTIEN + " TEXT NOT NULL, " +
                IngredientEntry.CARBS + " TEXT NOT NULL " +
                IngredientEntry.FAT + " TEXT NOT NULL " +
                IngredientEntry.CALORIES + " TEXT NOT NULL " +
                " );";



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Note that this only fires if you change the version number for your database.

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MealEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DishEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IngredientEntry.TABLE_NAME);



        onCreate(sqLiteDatabase);

    }






}
