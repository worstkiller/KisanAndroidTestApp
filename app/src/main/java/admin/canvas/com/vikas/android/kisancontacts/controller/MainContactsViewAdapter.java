package admin.canvas.com.vikas.android.kisancontacts.controller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import admin.canvas.com.vikas.android.kisancontacts.view.ContactsFragment;
import admin.canvas.com.vikas.android.kisancontacts.view.MessagesFragment;

/**
 * Created by vikas on 5/10/2017.
 */

public class MainContactsViewAdapter extends FragmentPagerAdapter {
    private String[] titles = {"Contacts", "Messages"};

    public MainContactsViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = ContactsFragment.getInstance();
                break;
            case 1:
                fragment = MessagesFragment.getInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
