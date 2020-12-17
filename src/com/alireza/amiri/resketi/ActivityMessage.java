package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Control.AdapterMessage;
import Model.DataMessage;
import Model.Message;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ActivityMessage extends Activity {

    ArrayList<DataMessage> Data = new ArrayList<DataMessage>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_root);
        getData();
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ImageView imgMen = (ImageView) findViewById(R.id.men_message);
        ViewGroup layMessage = (ViewGroup) findViewById(R.id.lay_message);
        ViewGroup lay_about = (ViewGroup) findViewById(R.id.lay_about);
        ViewGroup lay_idea = (ViewGroup) findViewById(R.id.lay_idea);
        ViewGroup lay_search = (ViewGroup) findViewById(R.id.lay_search);
        ViewGroup lay_program = (ViewGroup) findViewById(R.id.lay_program);
        TextView txtMessageSlide = (TextView) findViewById(R.id.txt_message_slide);

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
        txtMessageSlide.setText("صفحه اصلی ");
        lay_search.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivitySearch.class);
                G.currentActivity.startActivity(intent);
            }
        });
        layMessage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityBakeries.class);
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
        lay_about.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, About.class);
                G.currentActivity.startActivity(intent);
            }
        });
    }


    public void getData() {
        Message message = new Message();
        Data = message.getAllOfMessage();
        Log.i("LOG", "" + Data.size());
        ListView listView = (ListView) findViewById(R.id.lst_message);
        ArrayAdapter adapter = new AdapterMessage(Data);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.setTextFilterEnabled(true);

    }
}
