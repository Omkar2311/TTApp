package demo.vega.com.ttdemo.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import demo.vega.com.ttdemo.Fragment.SearchActivityFragments.HashtagsFragment;
import demo.vega.com.ttdemo.Fragment.SearchActivityFragments.SoundsFragment;
import demo.vega.com.ttdemo.Fragment.SearchActivityFragments.UserFragment;

public class SearchActivtyTabsPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public SearchActivtyTabsPagerAdapter(@NonNull FragmentManager fm, int NoOfTabs) {
        super(fm);
        this.mNumOfTabs = NoOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                UserFragment userFragment = new UserFragment();
                return  userFragment;
            case 1:
                SoundsFragment soundsFragment = new SoundsFragment();
                return  soundsFragment;
            case 2:
                HashtagsFragment hashtagsFragment = new HashtagsFragment();
                return hashtagsFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
