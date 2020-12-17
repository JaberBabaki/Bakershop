package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Control.AdapterBakeries;
import Model.DataBakery;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class FragmentAll extends Fragment {

    ArrayList<DataBakery> Data = new ArrayList<DataBakery>();


    public static Fragment instance() {
        Fragment fregment = new FragmentAll();
        return fregment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fregment_all, null);
        return layout;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GetData();
    }


    @Override
    public void onResume() {
        super.onResume();

        GetData();

    }


    public void GetData() {

        Log.i("LOG", "" + G.DataAll.size());
        GridView gride = (GridView) getView().findViewById(R.id.gridView1);
        ArrayAdapter adapter = new AdapterBakeries(G.DataAll);
        gride.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        gride.setTextFilterEnabled(true);
    }
}
