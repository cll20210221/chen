package com.bawei.chenlanglang20211228.fragmenr;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Date:2021/12/28
 * Time:10:01
 * author:chenlanglang
 * Describe:
 * <p>
 * .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .-----------------. .----------------.
 * | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
 * | |     ______   | || |  ____  ____  | || |  _________   | || | ____  _____  | || |   _____      | || |      __      | || | ____  _____  | || |    ______    | || |   _____      | || |      __      | || | ____  _____  | || |    ______    | |
 * | |   .' ___  |  | || | |_   ||   _| | || | |_   ___  |  | || ||_   \|_   _| | || |  |_   _|     | || |     /  \     | || ||_   \|_   _| | || |  .' ___  |   | || |  |_   _|     | || |     /  \     | || ||_   \|_   _| | || |  .' ___  |   | |
 * | |  / .'   \_|  | || |   | |__| |   | || |   | |_  \_|  | || |  |   \ | |   | || |    | |       | || |    / /\ \    | || |  |   \ | |   | || | / .'   \_|   | || |    | |       | || |    / /\ \    | || |  |   \ | |   | || | / .'   \_|   | |
 * | |  | |         | || |   |  __  |   | || |   |  _|  _   | || |  | |\ \| |   | || |    | |   _   | || |   / ____ \   | || |  | |\ \| |   | || | | |    ____  | || |    | |   _   | || |   / ____ \   | || |  | |\ \| |   | || | | |    ____  | |
 * | |  \ `.___.'\  | || |  _| |  | |_  | || |  _| |___/ |  | || | _| |_\   |_  | || |   _| |__/ |  | || | _/ /    \ \_ | || | _| |_\   |_  | || | \ `.___]  _| | || |   _| |__/ |  | || | _/ /    \ \_ | || | _| |_\   |_  | || | \ `.___]  _| | |
 * | |   `._____.'  | || | |____||____| | || | |_________|  | || ||_____|\____| | || |  |________|  | || ||____|  |____|| || ||_____|\____| | || |  `._____.'   | || |  |________|  | || ||____|  |____|| || ||_____|\____| | || |  `._____.'   | |
 * | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |
 * | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
 * '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'
 */
public class Fragmentdapter extends FragmentPagerAdapter {


    ArrayList<Fragment> fragments;
    ArrayList<String> strings;

    public Fragmentdapter(@NonNull @NotNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {

    }
}
