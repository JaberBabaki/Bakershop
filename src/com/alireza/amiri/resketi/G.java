package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Model.DataAccess;
import Model.DataBakery;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;


public class G extends Application {

    public static Context               context;

    public static final String          DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String                DB_PATH    = DIR_SDCARD + "/BakeryShop/";
    public static String                DB_NAME    = "DB-bakerShop2.db";

    public static Typeface              font;
    public static LayoutInflater        inflater;
    public static Activity              currentActivity;
    public static int                   lickSet    = 5;
    public static ArrayList<DataBakery> DataAll    = new ArrayList<DataBakery>();
    public static ArrayList<DataBakery> Data3      = new ArrayList<DataBakery>();


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        font = Typeface.createFromAsset(context.getAssets(), "yekan.ttf");
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.i("LOG", "" + DB_PATH + DB_NAME);
        DataAccess dataAccess = new DataAccess();
        dataAccess.copyDatabase();
    }
}
