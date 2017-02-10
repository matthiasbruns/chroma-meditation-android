package com.matthiasbruns.chromameditation.ui;

import com.matthiasbruns.chromameditation.R;
import com.matthiasbruns.chromameditation.content.Config;
import com.matthiasbruns.chromameditation.ui.color.PickerActivity;
import com.matthiasbruns.chromameditation.ui.onboarding.OnboardingActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by mbruns on 10/02/2017.
 */

public class SplashActivity extends BaseAcvitiy {

    protected Config mConfig;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mConfig = new Config(getBaseContext());
        if (mConfig.isFirstLaunch() && !mConfig.isOnboardingPassed()) {
            startActivity(OnboardingActivity.create(getBaseContext()));
        } else {
            startActivity(PickerActivity.create(getBaseContext()));
        }
    }
}
