package com.matthiasbruns.chromameditation.ui.onboarding;

import com.matthiasbruns.chromameditation.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mbruns on 10/02/2017.
 */

public class OnboardingPagerFragment extends Fragment {

    private static final String TAG = OnboardingPagerFragment.class.getSimpleName();

    public static final String EXTRA_LAYOUT_ID = TAG + "_extra_layout_id";

    @BindView(R.id.img_logo)
    protected ImageView mLogoImageView;

    private int mLayoutId = 0;

    public static OnboardingPagerFragment create(final int layoutId) {
        final Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_LAYOUT_ID, layoutId);
        final OnboardingPagerFragment onboardingPagerFragment = new OnboardingPagerFragment();
        onboardingPagerFragment.setArguments(bundle);
        return onboardingPagerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }
        mLayoutId = savedInstanceState.getInt(EXTRA_LAYOUT_ID);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(mLayoutId, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        outState.putInt(EXTRA_LAYOUT_ID, mLayoutId);
        super.onSaveInstanceState(outState);
    }
}
