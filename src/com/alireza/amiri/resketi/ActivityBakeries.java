package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Control.PagerAdapter;
import Model.Bakeries;
import Model.DataBakery;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alireza.amiri.resketi.R;


public class ActivityBakeries extends FragmentActivity {

    ArrayList<DataBakery> Data = new ArrayList<DataBakery>();
    public String         name;


    @Override
    protected void onResume() {
        super.onResume();
        G.currentActivity = this;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_root);
        Log.i("LOG", "Activity");
        Bakeries bakerShop = new Bakeries();
        Data = bakerShop.getAllOfBakeries();
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ViewGroup lay_main = (ViewGroup) findViewById(R.id.lay_main);
        ViewGroup layMessage = (ViewGroup) findViewById(R.id.lay_message);
        ViewGroup lay_about = (ViewGroup) findViewById(R.id.lay_about);
        ViewGroup lay_search = (ViewGroup) findViewById(R.id.lay_search);
        ViewGroup lay_program = (ViewGroup) findViewById(R.id.lay_program);
        ViewGroup lay_idea = (ViewGroup) findViewById(R.id.lay_idea);

        ViewGroup layAllSliding = (ViewGroup) findViewById(R.id.lay_all_sliding);

        lay_main.setVisibility(View.GONE);
        lay_search.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivitySearch.class);
                G.currentActivity.startActivity(intent);
            }
        });
        lay_idea.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent browserIntent1 = new Intent(
                        Intent.ACTION_EDIT,
                        Uri.parse("http://cafebazaar.ir/app/com.jbapp.Martyr/?l=fa"));
                startActivity(browserIntent1);

            }
        });
        lay_program.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent browserIntent1 = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://cafebazaar.ir/app/com.jbapp.Martyr/?l=fa"));
                startActivity(browserIntent1);

            }
        });
        layMessage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, ActivityMessage.class);
                G.currentActivity.startActivity(intent);
            }
        });
        lay_about.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(G.currentActivity, About.class);
                G.currentActivity.startActivity(intent);
            }
        });

        //G.adapter.notifyDataSetChanged();
        layAllSliding.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

            }
        });

        ImageView imgMen = (ImageView) findViewById(R.id.men);
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

        ViewPager vpPager = (ViewPager) findViewById(R.id.view_pager);
        PagerAdapter adapterPage = new PagerAdapter(this, getSupportFragmentManager());
        vpPager.setAdapter(adapterPage);
        SlidingTabLayout sli = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        sli.setViewPager(vpPager);
        sli.setDividerColors(0);
        vpPager.setCurrentItem(2);

    }
}