package com.tegprogramming.personal_diet_assistant.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by TroysMacBook on 10/21/17.
 */

public class DatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.tegprogramming.android.personal_diet_assistant";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_MEALS = "meals";
    public static final String PATH_INGREDIENTS = "ingredients";
    public static final String PATH_DISH = "dish";

    //table to meals
    public static final class MealEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MEALS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MEALS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MEALS;

        //table name
        public static final String TABLE_NAME = "meals";

        //holds the name of meal
        public static final String MEAL_NAME = "meal_name";

        //holds the id of routine
        public static final String FOODITEM_ID = "fooditem_id";

        public static Uri buildMealUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static Uri sortOrder(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static String getMealsFromUri(Uri uri) {
            return uri.getPathSegments().get(0);
        }


    }

    //table to dish
    public static final class DishEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_DISH).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DISH;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DISH;

        //table name
        public static final String TABLE_NAME = "dish";

        //holds the name of dish
        public static final String DISH_NAME = "dish_name";

        //holds the id of routine
        public static final String FOODITEM_ID = "fooditem_id";

        public static Uri buildDishUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static Uri sortOrder(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static String getDishFromUri(Uri uri) {
            return uri.getPathSegments().get(0);
        }


    }

    //table to dish
    public static final class IngredientEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_INGREDIENTS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INGREDIENTS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INGREDIENTS;

        //table name
        public static final String TABLE_NAME = "ingredient";

        //holds the name of ingredient
        public static final String INGREDIENT_NAME = "ingredient_name";

        //holds protien in grams
        public static final String PROTIEN = "protien";

        //holds carbs in grams
        public static final String CARBS = "carbs";

        //holds protien in grams
        public static final String FAT = "fat";

        //holds calories
        public static final String CALORIES = "calories";

        public static Uri buildIngredientUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static Uri sortOrder(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static String getIngredientFromUri(Uri uri) {
            return uri.getPathSegments().get(0);
        }


    }





}
