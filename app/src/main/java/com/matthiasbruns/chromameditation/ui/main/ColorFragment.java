package com.matthiasbruns.chromameditation.ui.main;

import com.matthiasbruns.chromameditation.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import butterknife.ButterKnife;

/**
 * Created by mbruns on 09/02/2017.
 */

public class ColorFragment extends Fragment {

    public static class Configuration implements Serializable {

        public int mColor;

        public String mDescription;

        public String mTitle;

        public Configuration(final int color, final String description, final String title) {
            mColor = color;
            mDescription = description;
            mTitle = title;
        }
    }

    private static final String TAG = ColorFragment.class.getSimpleName();

    public static final String EXTRA_CONFIGURATION = TAG + "_configuration";

    private Configuration mConfiguration;

    public static Fragment create(final Configuration configuration) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CONFIGURATION, configuration);
        final ColorFragment colorFragment = new ColorFragment();
        colorFragment.setArguments(bundle);
        return colorFragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_color, container, false);

        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }
        mConfiguration = (Configuration) savedInstanceState.getSerializable(EXTRA_CONFIGURATION);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable(EXTRA_CONFIGURATION, mConfiguration);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(mConfiguration.mColor);
    }
}
