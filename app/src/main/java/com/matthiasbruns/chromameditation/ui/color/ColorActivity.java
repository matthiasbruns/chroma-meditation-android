package com.matthiasbruns.chromameditation.ui.color;

import com.matthiasbruns.chromameditation.R;
import com.matthiasbruns.chromameditation.content.ColorSetting;
import com.matthiasbruns.chromameditation.ui.BaseAcvitiy;
import com.matthiasbruns.chromameditation.ui.help.HelpFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import butterknife.BindView;

/**
 * Created by mbruns on 09/02/2017.
 */

public class ColorActivity extends BaseAcvitiy {

    private static final String TAG = ColorActivity.class.getSimpleName();

    public static final String EXTRA_CONFIGURATION = TAG + "_configuration";

    @BindView(R.id.color_view)
    protected View mColorView;

    @BindView(R.id.help_button)
    protected Button mHelpButton;

    @Nullable
    private ColorSetting mColorSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_color);

        if (savedInstanceState == null) {
            savedInstanceState = getIntent().getExtras();
        }
        mColorSetting = (ColorSetting) savedInstanceState.getSerializable(EXTRA_CONFIGURATION);
        if (mColorSetting == null) {
            finish();
        }

        mColorView.setBackgroundColor(mColorSetting.mColor);

        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                launchColorHelp(v, mColorSetting.mColor, mColorSetting.mTitle,
                        mColorSetting.mDescription);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable(EXTRA_CONFIGURATION, mColorSetting);
        super.onSaveInstanceState(outState);
    }

    public static Intent create(@NonNull final Context context, final ColorSetting colorSetting) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CONFIGURATION, colorSetting);
        final Intent intent = new Intent(context, ColorActivity.class);
        intent.putExtras(bundle);
        return intent;
    }

    private void launchColorHelp(@NonNull final View view, final int color, final String title,
            final String description) {

        getSupportFragmentManager().beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(title)
                .replace(R.id.fragment_container,
                        HelpFragment.create(mColorSetting)).commit();
    }
}
