package com.alireza.amiri.resketi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.alireza.amiri.resketi.R;


public class ActivityMessageText extends Activity {

    public String txtNamet;
    public String txtBakert;


    @Override
    protected void onResume() {
        super.onResume();
        G.currentActivity = this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_message);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            txtNamet = extras.getString("title");
            txtBakert = extras.getString("text");

        }
        TextView txt_title_text = (TextView) findViewById(R.id.txt_title_text);
        TextView txtBaker = (TextView) findViewById(R.id.txt_text_text);
        txt_title_text.setText(txtNamet);
        txtBaker.setText(txtBakert);
    }
}
