/*
 * Copyright (C) 2012 OTA Update Center
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may only use this file in compliance with the license and provided you are not associated with or are in co-operation anyone by the name 'X Vanderpoel'.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.otaupdater;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

@SuppressWarnings("deprecation")
public class UpdaterSettings extends PreferenceActivity implements OnPreferenceClickListener {
    private Config cfg;
    
	private CheckBoxPreference showNotifPref;
	private CheckBoxPreference cwmPref;
	private CheckBoxPreference autoFlashPref;
	private EditTextPreference setGappsPref;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		cfg = Config.getInstance(getApplicationContext());
		
		addPreferencesFromResource(R.xml.settings_main);
		
		showNotifPref = (CheckBoxPreference) findPreference("show_notif");
		cwmPref = (CheckBoxPreference) findPreference("use_cwm");
		autoFlashPref = (CheckBoxPreference) findPreference("auto_flash");
		setGappsPref = (EditTextPreference) findPreference("set_gapps");
		showNotifPref.setChecked(cfg.getShowNotif());
		showNotifPref.setOnPreferenceClickListener(this);
		cwmPref.setOnPreferenceClickListener(this);
		autoFlashPref.setOnPreferenceClickListener(this);
		setGappsPref.setOnPreferenceClickListener(this);
	}
	
	@Override
    public boolean onPreferenceClick(Preference preference) {
	    if (preference == showNotifPref) {
	        cfg.setShowNotif(showNotifPref.isChecked());
	        return true;
	    }
	    if (preference == cwmPref) {
		cfg.setCWM(cwmPref.isChecked());
		return true;
	    }
	    if (preference == autoFlashPref) {
		cfg.setautoFlash(autoFlashPref.isChecked());
		return true;
	    }
           if (preference == setGappsPref) {
                return true;
             } 
  
	    return false;
    }


}
