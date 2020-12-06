package com.waziristan.tourisam.colors.adapter;

import android.content.Context;

import com.waziristan.tourisam.colors.R;
import com.waziristan.tourisam.colors.fragments.TopSpotsFragment;
import com.waziristan.tourisam.colors.fragments.ReligiousFragment;
import com.waziristan.tourisam.colors.fragments.RestaurantsFragment;
import com.waziristan.tourisam.colors.fragments.ShoppingFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    // fm is the fragment manager that will keep each fragment's state in the adapter across swipes.
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new TopSpotsFragment();
        else if (position == 1)
            return new RestaurantsFragment();
        else if (position == 2)
            return new ReligiousFragment();
        else
            return new ShoppingFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return mContext.getString(R.string.category_topspots);
        else if (position == 1)
            return mContext.getString(R.string.category_restaurants);
        else if (position == 2)
            return mContext.getString(R.string.category_religious);
        else
            return mContext.getString(R.string.category_shopping);
    }
}
