package doge.thecraftcod.myapplication.ui.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import doge.thecraftcod.myapplication.R;


/**
 * Created by Gerardo
 */
public class MemeSettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
