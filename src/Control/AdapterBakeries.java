package Control;

import java.util.ArrayList;
import Model.DataBakery;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alireza.amiri.resketi.ActivityDetails;
import com.alireza.amiri.resketi.CustomTextView;
import com.alireza.amiri.resketi.G;
import com.alireza.amiri.resketi.R;


public class AdapterBakeries extends ArrayAdapter<DataBakery> {

    public AdapterBakeries(ArrayList<DataBakery> array) {
        super(G.context, R.layout.item, array);

    }


    private static class ViewHolder {

        public CustomTextView txtName;
        public CustomTextView txtFirstTime;
        public CustomTextView txtSecondTime;
        public ImageView      imgBaker;
        public LinearLayout   linName;
        public LinearLayout   linAll;
        public int[]          continent = { R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12 };


        public ViewHolder(View view) {

            txtName = (CustomTextView) view.findViewById(R.id.txt_name);
            txtFirstTime = (CustomTextView) view.findViewById(R.id.txt_first_time);
            txtSecondTime = (CustomTextView) view.findViewById(R.id.txt_second_time);
            imgBaker = (ImageView) view.findViewById(R.id.img_baker);
            linName = (LinearLayout) view.findViewById(R.id.lin_name);
            linAll = (LinearLayout) view.findViewById(R.id.lin_all);

        }


        public void fill(ArrayAdapter<DataBakery> adapter, final DataBakery item, int position) {
            txtName.setText("" + item.name);
            String[] array = item.hour.split("-");
            String f1 = array[0].substring(0, 2);
            String f2 = array[0].substring(2, 4);
            String s1 = array[1].substring(0, 2);
            String s2 = array[1].substring(2, 4);
            txtFirstTime.setText(f1 + "-" + f2);
            txtSecondTime.setText(s1 + "-" + s2);

            imgBaker.setBackgroundResource(continent[item.id - 1]);

            linAll.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent(G.currentActivity, ActivityDetails.class);
                    intent.putExtra("address", item.address);
                    intent.putExtra("name", item.name);
                    intent.putExtra("like", item.like);
                    intent.putExtra("bread", item.bread);
                    intent.putExtra("cooking", item.cooking);
                    intent.putExtra("holiday", item.holiday);
                    intent.putExtra("hour", item.hour);
                    intent.putExtra("phone", item.phone);
                    intent.putExtra("photo", item.id);
                    intent.putExtra("baker", item.baker);
                    G.currentActivity.startActivity(intent);
                }
            });

        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        DataBakery item = getItem(position);
        if (convertView == null) {
            convertView = G.inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(this, item, position);
        Animation animation = AnimationUtils.loadAnimation(G.currentActivity,
                android.R.anim.slide_in_left);
        convertView.startAnimation(animation);
        return convertView;
    }
}