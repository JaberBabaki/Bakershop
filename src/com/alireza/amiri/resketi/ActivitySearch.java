package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Control.AdapterBakeriesList;
import Model.Bakeries;
import Model.DataBakery;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ActivitySearch extends Activity {

    public String         name  = "";

    ArrayList<DataBakery> Data  = new ArrayList<DataBakery>();
    ArrayList<DataBakery> Data2 = new ArrayList<DataBakery>();

    public ListView       gride;
    public ArrayAdapter   adapter;


    @Override
    protected void onResume() {
        super.onResume();
        G.currentActivity = this;
        //GetData();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_root);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ViewGroup layMessage = (ViewGroup) findViewById(R.id.lay_message);
        ViewGroup lay_about = (ViewGroup) findViewById(R.id.lay_about);
        //ViewGroup lay_search = (ViewGroup) findViewById(R.id.lay_search);
        ViewGroup lay_program = (ViewGroup) findViewById(R.id.lay_program);
        ViewGroup lay_idea = (ViewGroup) findViewById(R.id.lay_idea);
        ViewGroup layAllSliding = (ViewGroup) findViewById(R.id.lay_all_sliding);
        TextView txt_search_slide = (TextView) findViewById(R.id.txt_search_slide);
        txt_search_slide.setText("صفحه اصلی ");

        txt_search_slide.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(ActivitySearch.this, ActivityBakeries.class);
                ActivitySearch.this.startActivity(intent);
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

        ImageView imgMen = (ImageView) findViewById(R.id.men_search);
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

        GetData();
        gride = (ListView) findViewById(R.id.lst_search);
        adapter = new AdapterBakeriesList(Data);
        gride.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        gride.setTextFilterEnabled(true);
        final EditText edtSearch = (EditText) findViewById(R.id.edt_search);
        name = "";
        edtSearch.setTypeface(G.font);
        edtSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
                String searchString = edtSearch.getText().toString().trim();

                int textLength = searchString.length();

                Data2.clear();
                for (int i = 0; i <= (Data.size() - 1); i++) {

                    name = Data.get(i).name;

                    if (textLength <= name.length()) {

                        if (searchString.equalsIgnoreCase(name.substring(0, textLength)))
                            Data2.add(Data.get(i));
                    }
                }
                adapter = new AdapterBakeriesList(Data2);
                gride.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2,
                                          int arg3) {

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void GetData() {
        Bakeries bakerShop = new Bakeries();
        Data = bakerShop.getAllOfBakeries();

    }
}
