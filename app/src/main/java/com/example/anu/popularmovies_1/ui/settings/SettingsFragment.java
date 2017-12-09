package com.example.anu.popularmovies_1.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import com.example.anu.popularmovies_1.R;

/**
 * SettingsFragment serves as the display for all the user's preferences on movies
 * user can select sort order in which movie names should be displayed
 *
 * popular movies will be displayed by default
 */
public class SettingsFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener{

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        //add created preference xml file
        addPreferencesFromResource(R.xml.movie_pref);

        /*
          set preference summary to each preference that is not a CheckboxPreference
         */
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        SharedPreferences sharedPreferences = preferenceScreen.getSharedPreferences();
        int count = preferenceScreen.getPreferenceCount();
        for (int i=0;i<count;i++){
            Preference preference = preferenceScreen.getPreference(i);
            setPreferenceSummary(preference, sharedPreferences.getString(preference.getKey(), ""));
        }
    }

    /**
     * method to set user's preference summary
     * @param preference preference object which is to be saved
     * @param value preference vlue to be saved
     */
    private void setPreferenceSummary(Preference preference, Object value) {
        if (preference instanceof ListPreference){
            ListPreference listPreference = (ListPreference) preference;
            int index = listPreference.findIndexOfValue(value.toString());
            if (index>=0){
                preference.setSummary(listPreference.getEntries()[index]);
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (null!=preference){
            if (!(preference instanceof CheckBoxPreference)){
                setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
            }
        }
    }

    /**
     * register SettingsFragment (this) as the SharedPreferenceChangedListener
     */
    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    /**
     * unregister SettingsFragment (this) as SharedPreferenceChangedListener
     */
    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
