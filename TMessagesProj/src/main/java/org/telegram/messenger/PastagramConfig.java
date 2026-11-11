package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;

public class PastagramConfig {
    private static SharedPreferences preferences;

    // 4 главные фишки Pastagram
    public static boolean localPremium = true;
    public static boolean fakeStarsEnabled = true;
    public static long fakeStarsBalance = 999999L;
    public static boolean fakeGiftPurchase = true;
    public static boolean pluginsEnabled = true;

    public static void loadConfig() {
        if (preferences != null) return;
        preferences = ApplicationLoader.applicationContext.getSharedPreferences("pastagram_config", Context.MODE_PRIVATE);
        localPremium = preferences.getBoolean("localPremium", true);
        fakeStarsEnabled = preferences.getBoolean("fakeStarsEnabled", true);
        fakeStarsBalance = preferences.getLong("fakeStarsBalance", 999999L);
        fakeGiftPurchase = preferences.getBoolean("fakeGiftPurchase", true);
        pluginsEnabled = preferences.getBoolean("pluginsEnabled", true);
    }

    public static void saveConfig() {
        if (preferences == null) return;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("localPremium", localPremium);
        editor.putBoolean("fakeStarsEnabled", fakeStarsEnabled);
        editor.putLong("fakeStarsBalance", fakeStarsBalance);
        editor.putBoolean("fakeGiftPurchase", fakeGiftPurchase);
        editor.putBoolean("pluginsEnabled", pluginsEnabled);
        editor.apply();
    }
}
