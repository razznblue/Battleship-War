package edu.byuh.cis.cs203.bw_i18n_2019.ui;

import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;

import edu.byuh.cis.cs203.bw_i18n_2019.R;

public class Prefs extends PreferenceActivity {

    private static final String OPT_SOUND = "soundfx";
    private static final String OPT_RAPID_GUNS = "rapid_guns";
    private static final String OPT_RAPID_DC = "rapid_dc";
    private static final String OPT_NUM_SUBS = "num_subs";
    private static final String OPT_NUM_PLANES = "num_planes";
    private static final String OPT_PLANE_SPEED = "plane_speed";
    private static final String OPT_SUB_SPEED = "sub_speed";

    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);

        CheckBoxPreference speed = new CheckBoxPreference(this);
        speed.setTitle(R.string.soundfx);
        speed.setSummaryOn(R.string.soundfx_on);
        speed.setSummaryOff(R.string.soundfx_off);
        speed.setChecked(true);
        speed.setKey(OPT_SOUND);
        screen.addPreference(speed);

        CheckBoxPreference rapidGuns = new CheckBoxPreference(this);
        rapidGuns.setTitle(R.string.rapid_cannons);
        rapidGuns.setSummaryOn(R.string.rapid_cannons_on);
        rapidGuns.setSummaryOff(R.string.rapid_cannons_off);
        rapidGuns.setChecked(true);
        rapidGuns.setKey(OPT_RAPID_GUNS);
        screen.addPreference(rapidGuns);

        CheckBoxPreference rapidDC = new CheckBoxPreference(this);
        rapidDC.setTitle(R.string.rapid_dc);
        rapidDC.setSummaryOn(R.string.rapid_dc_on);
        rapidDC.setSummaryOff(R.string.rapid_dc_off);
        rapidDC.setChecked(true);
        rapidDC.setKey(OPT_RAPID_DC);
        screen.addPreference(rapidDC);

        ListPreference numSubs = new ListPreference(this);
        numSubs.setTitle(R.string.howmany_subs);
        numSubs.setSummary(R.string.howmany_subs_summary);
        //String[] entries10 = {"1", "2", "3 (default)", "4", "5", "6", "7", "8", "9", "10"};
        String[] values10 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        numSubs.setEntries(R.array.one_to_ten);
        numSubs.setEntryValues(values10);
        numSubs.setKey(OPT_NUM_SUBS);
        screen.addPreference(numSubs);

        ListPreference numPlanes = new ListPreference(this);
        numPlanes.setTitle(R.string.howmany_planes);
        numPlanes.setSummary(R.string.howmany_planes_summary);
        numPlanes.setEntries(R.array.one_to_ten);
        numPlanes.setEntryValues(values10);
        numPlanes.setKey(OPT_NUM_PLANES);
        screen.addPreference(numPlanes);

        ListPreference subSpeed = new ListPreference(this);
        subSpeed.setTitle(R.string.sub_speed);
        subSpeed.setSummary(R.string.sub_speed_summary);
        //String[] speedEntries = {"Fast", "Medium", "Slow"};
        String[] speedValues = {"0.01", "0.00625", "0.001"};
        subSpeed.setEntries(R.array.speed_entries);
        subSpeed.setEntryValues(speedValues);
        subSpeed.setKey(OPT_SUB_SPEED);
        screen.addPreference(subSpeed);

        ListPreference planeSpeed = new ListPreference(this);
        planeSpeed.setTitle(R.string.plane_speed);
        planeSpeed.setSummary(R.string.plane_speed_summary);
        planeSpeed.setEntries(R.array.speed_entries);
        planeSpeed.setEntryValues(speedValues);
        planeSpeed.setKey(OPT_PLANE_SPEED);
        screen.addPreference(planeSpeed);

        setPreferenceScreen(screen);

    }

    //Get the current value of the sound option
    public static boolean getSoundFX(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_SOUND, true);
    }

    public static boolean getRapidGuns(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_RAPID_GUNS, true);
    }

    public static boolean getRapidDC(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_RAPID_DC, false);
    }

    public static int getNumPlanes(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_NUM_PLANES, "3");
        return Integer.parseInt(tmp);
    }

    public static int getNumSubs(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_NUM_SUBS, "3");
        return Integer.parseInt(tmp);
    }

    public static float getPlaneSpeed(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_PLANE_SPEED, "0.00625");
        return Float.parseFloat(tmp);
    }
    public static float getSubSpeed(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_SUB_SPEED, "0.00625");
        return Float.parseFloat(tmp);
    }


}
