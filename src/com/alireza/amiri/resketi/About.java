package com.alireza.amiri.resketi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_root);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ImageView imgMen = (ImageView) findViewById(R.id.men_about);
        ViewGroup layMessage = (ViewGroup) findViewById(R.id.lay_message);
        ViewGroup lay_about = (ViewGroup) findViewById(R.id.lay_about);
        ViewGroup lay_idea = (ViewGroup) findViewById(R.id.lay_idea);
        ViewGroup lay_search = (ViewGroup) findViewById(R.id.lay_search);
        ViewGroup lay_program = (ViewGroup) findViewById(R.id.lay_program);
        TextView txtAbout = (TextView) findViewById(R.id.txt_about);

        imgMen.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
        txtAbout.setText("صفحه اصلی ");
        lay_search.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivitySearch.class);
                G.currentActivity.startActivity(intent);
            }
        });
        lay_about.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityBakeries.class);
                G.currentActivity.startActivity(intent);
            }
        });
        layMessage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityMessage.class);
                G.currentActivity.startActivity(intent);
            }
        });
        lay_idea.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent browserIntent1 = new Intent(
                        Intent.ACTION_EDIT,
                        Uri.parse("http://wwww.martyriran.ir"));
                startActivity(browserIntent1);

            }
        });
        lay_program.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent browserIntent1 = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://wwww.martyriran.ir"));
                startActivity(browserIntent1);

            }
        });
    }

}
