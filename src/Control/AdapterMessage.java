package Control;

import java.util.ArrayList;
import Model.DataMessage;
import Model.Message;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import com.alireza.amiri.resketi.ActivityMessageText;
import com.alireza.amiri.resketi.CustomTextView;
import com.alireza.amiri.resketi.G;
import com.alireza.amiri.resketi.R;


public class AdapterMessage extends ArrayAdapter<DataMessage> {

    public AdapterMessage(ArrayList<DataMessage> array) {
        super(G.context, R.layout.item_message, array);

    }


    private static class ViewHolder {

        public CustomTextView txtTitleList;
        public LinearLayout   linRead;
        public LinearLayout   linAllList;


        public ViewHolder(View view) {

            txtTitleList = (CustomTextView) view.findViewById(R.id.txt_Title);
            linRead = (LinearLayout) view.findViewById(R.id.lay_read);
            linAllList = (LinearLayout) view.findViewById(R.id.lay_all_message);

        }


        public void fill(ArrayAdapter<DataMessage> adapter, final DataMessage item, int position) {
            txtTitleList.setText(item.title);
            if (item.read == 1) {
                linRead.setBackgroundColor(Color.parseColor("#d84315"));
            } else {
                linRead.setBackgroundColor(Color.parseColor("#C4C4C4"));
            }
            linAllList.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent(G.currentActivity, ActivityMessageText.class);
                    intent.putExtra("id", item.id);
                    intent.putExtra("title", item.title);
                    intent.putExtra("text", item.text);
                    G.currentActivity.startActivity(intent);
                    if (item.read == 1) {
                        linRead.setBackgroundColor(Color.parseColor("#c4c4c4"));
                        Message message = new Message();
                        message.setId(item.id);
                        message.updateReadMessage();
                    }
                }
            });

        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        DataMessage item = getItem(position);
        if (convertView == null) {
            convertView = G.inflater.inflate(R.layout.item_message, parent, false);
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