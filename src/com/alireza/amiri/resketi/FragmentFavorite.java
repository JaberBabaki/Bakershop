package com.alireza.amiri.resketi;

import java.util.ArrayList;
import Control.AdapterBakeries;
import Model.Bakeries;
import Model.DataBakery;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import com.alireza.amiri.resketi.R;


public class FragmentFavorite extends Fragment {

    ArrayList<DataBakery> Data = new ArrayList<DataBakery>();


    public static Fragment instance() {
        Fragment fregment = new FragmentFavorite();
        return fregment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fregment_favorite, null);
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

        Data = bakerShop.getAllOfLike();
        Log.i("LOG", "" + Data.size());

        GridView gride = (GridView) getView().findViewById(R.id.gridView1);
        ArrayAdapter adapter = new AdapterBakeries(Data);
        gride.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        gride.setTextFilterEnabled(true);
    }
}
