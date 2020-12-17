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


public class AdapterBakeriesList extends ArrayAdapter<DataBakery> {

    public AdapterBakeriesList(ArrayList<DataBakery> array) {
        super(G.context, R.layout.item_listview, array);

    }


    private static class ViewHolder {

        public CustomTextView txtNameList;
        public CustomTextView txtFirstTimeList;
        public CustomTextView txtSecondTimeList;
        public CustomTextView txtAddress;
        public ImageView      imgBakerList;
        public LinearLayout   linName;
        public LinearLayout   linAllList;
        public int[]          continent = { R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12 };


        public ViewHolder(View view) {

            txtNameList = (CustomTextView) view.findViewById(R.id.txt_nam_list);
            txtFirstTimeList = (CustomTextView) view.findViewById(R.id.txt_first_list);
            txtSecondTimeList = (CustomTextView) view.findViewById(R.id.txt_second_list);
            txtAddress = (CustomTextView) view.findViewById(R.id.txt_address_listview);
            imgBakerList = (ImageView) view.findViewById(R.id.img_bakp);
            linName = (LinearLayout) view.findViewById(R.id.lin_name);
            linAllList = (LinearLayout) view.findViewById(R.id.lin_all_list);

        }


        public void fill(ArrayAdapter<DataBakery> adapter, final DataBakery item, int position) {
            txtNameList.setText("" + item.name);
            String[] array = item.hour.split("-");
            String f1 = array[0].substring(0, 2);
            String f2 = array[0].substring(2, 4);
            String s1 = array[1].substring(0, 2);
            String s2 = array[1].substring(2, 4);
            txtFirstTimeList.setText(f1 + "-" + f2);
            txtSecondTimeList.setText(s1 + "-" + s2);
            /* if (item.id - 1 > continent.length) {
                 imgBakerList.setBackgroundResource(R.drawable.temp);

             } else {*/
            imgBakerList.setBackgroundResource(continent[item.id - 1]);
            // }
            txtAddress.setText(item.address);
            linAllList.setOnClickListener(new OnClickListener() {

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
            convertView = G.inflater.inflate(R.layout.item_listview, parent, false);
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