package com.matthiasbruns.chromameditation.content;

import net.grandcentrix.tray.TrayPreferences;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by mbruns on 10/02/2017.
 */

public class Config extends TrayPreferences {

    private static final String MODULE = "config";

    private static final int VERSION = 1;

    public static String KEY_IS_FIRST_LAUNCH = "first_launch";

    public static String KEY_IS_ONBOARDING_PASSED = "onboarding_passed";

    public Config(@NonNull final Context context) {
        super(context, MODULE, VERSION);
    }

    public boolean isFirstLaunch() {
        return getBoolean(KEY_IS_FIRST_LAUNCH, true);
    }

    public boolean isOnboardingPassed() {
        return getBoolean(KEY_IS_ONBOARDING_PASSED, false);
    }

    public void setFirstLaunch(boolean firstLaunch) {
        put(KEY_IS_FIRST_LAUNCH, firstLaunch);
    }

    public void setOnboardingPassed(boolean onboardingPassed) {
        put(KEY_IS_ONBOARDING_PASSED, onboardingPassed);
    }
}
