package com.tegprogramming.personal_diet_assistant.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tegprogramming.personal_diet_assistant.R;

/**
 * Created by TroysMacBook on 10/24/17.
 */

public class PdaProvider extends ContentProvider{

    /** Tag for the log messages */
    public static final String LOG_TAG = PdaProvider.class.getSimpleName();
    private MyDbHelper myHelper;

    static final int MEAL = 100;
    static final int DISH = 101;
    static final int INGREDIENT = 102;
    static final int INGREDIENTS = 103;
    //create uri matcher
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = DatabaseContract.CONTENT_AUTHORITY;

        //add uris to the matcher
        matcher.addURI(authority, DatabaseContract.PATH_MEALS, MEAL);
        matcher.addURI(authority, DatabaseContract.PATH_DISH, DISH);
        matcher.addURI(authority, DatabaseContract.PATH_INGREDIENTS, INGREDIENT);
        matcher.addURI(authority, DatabaseContract.PATH_INGREDIENTS+"/*", INGREDIENTS);


        return matcher;
    }

    private MyDbHelper myDBHelper;


    @Override
    public boolean onCreate() {
        myDBHelper = new MyDbHelper(getContext());


        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {


        // Get readable database
        SQLiteDatabase database = myDBHelper.getReadableDatabase();

        // This cursor will hold the result of the query
        Cursor cursor;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match) {
            case MEAL:
                selection = DatabaseContract.MealEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(DatabaseContract.MealEntry.TABLE_NAME,projection,selection,selectionArgs,
                        null,null, sortOrder);
                break;

            case DISH:
                selection = DatabaseContract.DishEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                cursor = database.query(DatabaseContract.DishEntry.TABLE_NAME,projection,selection,selectionArgs,
                        null,null, sortOrder);
                break;

            case INGREDIENT:
                selection = DatabaseContract.IngredientEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                cursor = database.query(DatabaseContract.IngredientEntry.TABLE_NAME,projection,selection,selectionArgs,
                        null,null, sortOrder);
                break;

            case INGREDIENTS:
                cursor = database.query(DatabaseContract.IngredientEntry.TABLE_NAME,projection,selection,selectionArgs,
                        null,null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException(getContext().getString(R.string.unknown_uri) + uri);
        }


        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {


        final int match = sUriMatcher.match(uri);

        switch (match){
            case MEAL:
                return insertMeal(uri,contentValues);

            default:
                throw new IllegalArgumentException(getContext().getString(R.string.insertion_not_supported)+ uri);

        }

    }

    private Uri insertMeal(Uri uri, ContentValues values) {

        SQLiteDatabase database = myDBHelper.getWritableDatabase();

        long id = database.insert(DatabaseContract.MealEntry.TABLE_NAME, null, values);
        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            Log.e(LOG_TAG, getContext().getString(R.string.failed_to_insert_row) + uri);
            return null;
        }
        return ContentUris.withAppendedId(uri, id);

    }



    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
