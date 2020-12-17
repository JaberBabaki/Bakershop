package com.alireza.amiri.resketi;

import Model.Bakeries;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;


public class SplashScreen extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        G.currentActivity = this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Bakeries bakerShop = new Bakeries();
        G.DataAll = bakerShop.getAllOfBakeries();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                finish();

                Intent intent = new Intent(SplashScreen.this,
                        ActivityBakeries.class);
                startActivity(intent);

            }

        }, 2000);
    }
}
