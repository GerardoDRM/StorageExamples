package doge.thecraftcod.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import doge.thecraftcod.myapplication.utils.StorageType;


/**
 * Created by Gerardo
 */
public class MemeMakerApplicationSettings {

    SharedPreferences mSharedPreferences;

    public MemeMakerApplicationSettings(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public String getStoragePreference() {
        return mSharedPreferences.getString("Storage", StorageType.INTERNAL);

    }

    public void setmSharedPreferences(String storageType) {
        mSharedPreferences
                .edit()
                .putString("Storage", storageType)
                .apply();
    }
}
