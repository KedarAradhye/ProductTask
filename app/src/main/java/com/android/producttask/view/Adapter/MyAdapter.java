package com.android.producttask.view.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android.producttask.view.Fragment.AllFragment;
import com.android.producttask.view.Fragment.PowderedSpicesFragment;
import com.android.producttask.view.Fragment.WholeSpicesFragment;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AllFragment allFragment = new AllFragment();
                return allFragment;
            case 1:
                WholeSpicesFragment wholeFragment = new WholeSpicesFragment();
                return wholeFragment;
            case 2:
                PowderedSpicesFragment powderedFragment = new PowderedSpicesFragment();
                return powderedFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
