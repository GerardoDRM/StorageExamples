package doge.thecraftcod.myapplication;


import android.preference.PreferenceManager;

import doge.thecraftcod.myapplication.utils.FileUtilities;

/**
 * Created by Gerardo
 */
public class MemeMakerApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FileUtilities.saveAssetImage(this, "dogmess.jpg");
        FileUtilities.saveAssetImage(this, "excitedcat.jpg");
        FileUtilities.saveAssetImage(this, "guiltypup.jpg");

        PreferenceManager.setDefaultValues(this, R.xml.preferences,false);
    }
}
