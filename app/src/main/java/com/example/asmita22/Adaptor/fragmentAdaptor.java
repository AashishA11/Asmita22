package com.example.asmita22.Adaptor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.asmita22.Fragment.FixturesFragment;
import com.example.asmita22.Fragment.InfoFragment;
import com.example.asmita22.Fragment.OrgnaziersFragment;
import com.example.asmita22.Fragment.ResultsFragment;

public class fragmentAdaptor extends FragmentPagerAdapter {
    public fragmentAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    public fragmentAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InfoFragment();
            case 1:
                return new FixturesFragment();
            case 2:
                return new ResultsFragment();
            case 3:
                return new OrgnaziersFragment();
            default:
                return new InfoFragment();
        }    }

    @Override
    public int getCount() {
        return 4;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;

        if (position==0){
            title="Info";

        }
        else if (position==1){
            title="Fixtures";
        }
        else if (position==2){
            title="Results";
        }
        else if (position==3){
            title="Organizers";
        }
        return title;
    }

}
