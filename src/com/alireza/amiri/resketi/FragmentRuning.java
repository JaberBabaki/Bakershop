package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Control.AdapterBakeriesList;
import Model.Bakeries;
import Model.DataBakery;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentRuning extends Fragment {

    ArrayList<DataBakery> Data = new ArrayList<DataBakery>();


    public static Fragment instance() {
        Fragment fregment = new FragmentRuning();
        return fregment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fregment_runing, null);
        return layout;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();

    }


    @Override
    public void onResume() {
        super.onResume();
        getData();
    }


    public void getData() {
        Bakeries bakerShop = new Bakeries();
        Data = bakerShop.getAllOfRuning();
        Log.i("LOG", "" + Data.size());
        TextView txtNo = (TextView) getView().findViewById(R.id.txt_no);
        ListView listView = (ListView) getView().findViewById(R.id.list_runing);
        if (Data.size() == 0) {
            txtNo.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        } else {
            //  Data.set(1, id) int id = getResources().getIdentifier("yourpackagename:drawable/" + Data.get(1).bread, null, null);

            ArrayAdapter adapter = new AdapterBakeriesList(Data);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            listView.setTextFilterEnabled(true);
        }
    }
}
