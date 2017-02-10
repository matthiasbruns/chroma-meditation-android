package com.matthiasbruns.chromameditation.ui.onboarding;

import com.matthiasbruns.chromameditation.R;
import com.matthiasbruns.chromameditation.ui.BaseAcvitiy;
import com.matthiasbruns.chromameditation.ui.color.PickerActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by mbruns on 09/02/2017.
 */

public class OnboardingActivity extends BaseAcvitiy {

    static class OnboardingPagerAdaper extends FragmentStatePagerAdapter {

        private static final int[] mLayoutIds = new int[]{
                R.layout.fragment_onboaring_intro,
                R.layout.fragment_onboaring_explanation,
                R.layout.fragment_onboaring_final
        };

        public OnboardingPagerAdaper(final FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mLayoutIds.length;
        }

        @Override
        public Fragment getItem(final int position) {
            return OnboardingPagerFragment.create(mLayoutIds[position]);
        }
    }

    @BindView(R.id.onboarding_viewpager)
    protected ViewPager mOnboardingViewPager;

    @BindView(R.id.onboarding_viewpager_indicator)
    protected CircleIndicator mOnboardingViewPagerIndicator;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        final float density = getResources().getDisplayMetrics().density;
        mOnboardingViewPager.setPageMargin((int) (32f * density));
        mOnboardingViewPager.setAdapter(new OnboardingPagerAdaper(getSupportFragmentManager()));
        mOnboardingViewPager.setOffscreenPageLimit(-1);
        mOnboardingViewPagerIndicator.setViewPager(mOnboardingViewPager);
    }

    public static Intent create(final Context context) {
        return new Intent(context, OnboardingActivity.class);
    }


    public void onNextClicked(@NonNull final View view) {
        final int currentItem = mOnboardingViewPager.getCurrentItem();

        if (currentItem < mOnboardingViewPager.getChildCount()) {
            mOnboardingViewPager.setCurrentItem(currentItem + 1, true);
        } else {
            startActivity(PickerActivity.create(getBaseContext()));
            finish();
        }
    }

    public void onPreviousClicked(@NonNull final View view) {
        final int currentItem = mOnboardingViewPager.getCurrentItem();

        if (currentItem > 0) {
            mOnboardingViewPager.setCurrentItem(currentItem - 1, true);
        }
    }
}
