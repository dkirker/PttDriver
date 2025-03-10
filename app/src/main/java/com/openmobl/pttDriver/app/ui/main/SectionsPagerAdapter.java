package com.openmobl.pttDriver.app.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.openmobl.pttDriver.R;

import java.lang.reflect.Array;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[] {
            R.string.devices,
            R.string.drivers
        };
    private static final DeviceOrDriverListFragment.DataSource[] TAB_MAP = new DeviceOrDriverListFragment.DataSource[] {
            DeviceOrDriverListFragment.DataSource.DEVICES,
            DeviceOrDriverListFragment.DataSource.DRIVERS
        };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return DeviceOrDriverListFragment.newInstance(TAB_MAP[position]);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return Array.getLength(TAB_TITLES);
    }
}
