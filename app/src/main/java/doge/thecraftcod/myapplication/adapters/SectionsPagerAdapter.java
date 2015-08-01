package doge.thecraftcod.myapplication.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import doge.thecraftcod.myapplication.R;
import doge.thecraftcod.myapplication.ui.fragments.ImageGridFragment;
import doge.thecraftcod.myapplication.ui.fragments.MemeItemFragment;


/**
 * Created by Evan Anger on 8/10/14.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if(position == 0) {
            fragment = new ImageGridFragment();
        } else {
            fragment = new MemeItemFragment();
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return mContext.getString(R.string.images_fragment_title);
        } else {
            return mContext.getString(R.string.memes_fragment_title);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
