package com.matthiasbruns.chromameditation.ui.help;

import com.matthiasbruns.chromameditation.R;
import com.matthiasbruns.chromameditation.content.ColorSetting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mbruns on 10/02/2017.
 */

public class HelpFragment extends Fragment {

    private static final String TAG = HelpFragment.class.getSimpleName();

    public static final String EXTRA_CONFIGURATION = TAG + "_configuration";

    @BindView(R.id.help_description)
    TextView mDescriptionTextView;

    @BindView(R.id.help_title)
    TextView mTitleTextView;

    private ColorSetting mColorSetting;

    public static Fragment create(final ColorSetting colorSetting) {
        final HelpFragment helpFragment = new HelpFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CONFIGURATION, colorSetting);
        helpFragment.setArguments(bundle);
        return helpFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }
        mColorSetting = (ColorSetting) savedInstanceState.getSerializable(EXTRA_CONFIGURATION);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_help, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTitleTextView.setText(mColorSetting.mTitle);
        mDescriptionTextView.setText(mColorSetting.mDescription);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                getActivity().onBackPressed();
            }
        });
    }
}
