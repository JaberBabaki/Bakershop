package Control;

import com.alireza.amiri.resketi.FragmentAll;
import com.alireza.amiri.resketi.FragmentFavorite;
import com.alireza.amiri.resketi.FragmentRuning;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {

    private Context context;


    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "برگزیده";
            case 1:
                return "درحال پخت";
            case 2:
                return "همه";
            default:
                return "همه ";

        }
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return FragmentFavorite.instance();
            case 1:
                return FragmentRuning.instance();
            case 2:
                return FragmentAll.instance();
            default:
                return FragmentAll.instance();
        }
    }


    @Override
    public int getCount() {
        return 3;
    }

}