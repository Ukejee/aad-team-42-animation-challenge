package com.aad_team_42.travelmanticsrebranded.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtils {
    private static SharedPreferences preferences;
    private static PreferencesUtils preferencesUtils;

    private PreferencesUtils(){}

    public static void initPreferences(Context context){
        if (preferencesUtils == null){
            preferencesUtils = new PreferencesUtils();
            preferences = context.getSharedPreferences("app_state", Context.MODE_PRIVATE);
        }
    }

    public static void setOpened(Boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("value", value);
        editor.apply();
    }

    public static Boolean openedBefore(){
        return preferences.getBoolean("value", false);
    }
}
