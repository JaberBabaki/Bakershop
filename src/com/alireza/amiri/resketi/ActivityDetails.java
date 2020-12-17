package com.alireza.amiri.resketi;

import Model.Bakeries;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ActivityDetails extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        G.currentActivity = this;
    }

    public String  txtNamet;
    public String  txtBakert;
    public String  txtPhonet;
    public String  txtAddresst;
    public String  txtHolidayt;
    public String  txtVarCookingt;
    public String  txtWorkingt;
    public String  bread;
    public String  cookingt;
    public int     imgBakert;
    public int     imgLiket;
    public int[]   continent = { R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12 };
    public boolean check     = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            txtNamet = extras.getString("name");
            txtBakert = extras.getString("baker");
            txtPhonet = extras.getString("phone");
            txtAddresst = extras.getString("address");
            txtHolidayt = extras.getString("holiday");
            txtVarCookingt = extras.getString("cooking");
            txtWorkingt = extras.getString("hour");
            cookingt = extras.getString("cooking");
            bread = extras.getString("bread");
            imgBakert = extras.getInt("photo");
            imgLiket = extras.getInt("like");
        }

        TextView txtName = (TextView) findViewById(R.id.txt_named);
        TextView txtBaker = (TextView) findViewById(R.id.txt_baker);
        final TextView txtPhone = (TextView) findViewById(R.id.txt_phone);
        final TextView txtAddress = (TextView) findViewById(R.id.txt_address);
        TextView txtHoliday = (TextView) findViewById(R.id.txt_holiday);
        TextView txtVarCooking = (TextView) findViewById(R.id.txt_var_cook);
        CustomTextView txtWorking = (CustomTextView) findViewById(R.id.txt_f);
        CustomTextView txt_w_2 = (CustomTextView) findViewById(R.id.txt_s);
        CustomTextView txt_bread = (CustomTextView) findViewById(R.id.txt_bread);
        ImageView imgBaker = (ImageView) findViewById(R.id.img_ba);
        ImageView imgCall = (ImageView) findViewById(R.id.img_call);
        Button btn_send_data = (Button) findViewById(R.id.btn_send_data);
        final ImageView imgLike = (ImageView) findViewById(R.id.img_liked);

        txtName.setText("" + txtNamet);
        txtBaker.setText("" + txtBakert);
        txtPhone.setText("" + txtPhonet);
        txtAddress.setText("" + txtAddresst);
        txtHoliday.setText("" + txtHolidayt + " هرماه ");
        txtVarCooking.setText("" + txtVarCookingt);
        String[] str = bread.split("-");
        String br1 = "";
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("1")) {
                br1 = br1 + "-" + "بربری";
            } else if (str[i].equals("2")) {
                br1 = br1 + "-" + "سنگک";
            }
            else if (str[i].equals("3")) {
                br1 = br1 + "-" + "تافتون";
            }
            else if (str[i].equals("4")) {
                br1 = br1 + "-" + "لواش";
            }
        }

        txt_bread.setText("" + br1.substring(1, br1.length()));
        String[] array = txtWorkingt.split("-");
        String f1 = array[0].substring(0, 2);
        String f2 = array[0].substring(2, 4);
        String s1 = array[1].substring(2, 4);
        String s2 = array[1].substring(2, 4);
        txtWorking.setText("" + s1 + "-" + s2);
        txt_w_2.setText("" + f1 + "-" + f2);
        //
        G.lickSet = imgLiket;
        /*if (imgBakert - 1 > continent.length) {
            imgBaker.setBackgroundResource(R.drawable.temp);

        } else {*/

        //}
        imgBaker.setBackgroundResource(continent[imgBakert - 1]);
        if (G.lickSet == 1) {
            imgLike.setImageResource(R.drawable.faveyes);
        } else {
            imgLike.setImageResource(R.drawable.faveno);
        }
        imgLike.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (G.lickSet == 1) {
                    imgLike.setImageResource(R.drawable.faveno);
                    G.lickSet = 0;

                    // Toast.makeText(G.context, "fdf", Toast.LENGTH_LONG).show();
                } else {
                    imgLike.setImageResource(R.drawable.faveyes);
                    G.lickSet = 1;
                }
                Bakeries baker = new Bakeries();
                baker.setId(imgBakert);
                baker.setLike(G.lickSet);
                baker.updateLike();
                //check = !check;
            }
        });
        btn_send_data.setTypeface(G.font);
        btn_send_data.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                sendIntent.putExtra("sms_body", "" + txtAddresst + "\n" + txtPhonet + "\n" + "------------" + "\n" + "اپلیکشن نان آور" + "\n" + "www.nanavar.com");
                startActivity(sendIntent);
            }
        });
        imgCall.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txtPhonet));
                startActivity(intent);
            }
        });

    }

}