package com.tegprogramming.personal_diet_assistant.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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



    @Override
    public boolean onCreate() {


        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
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
