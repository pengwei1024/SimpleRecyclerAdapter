package com.apkfuns.simplerecycleradapterdemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by pengwei08 on 15/11/9.
 */
public class MainActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);
    }
}
