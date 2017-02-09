package com.matthiasbruns.chromameditation.ui.main;

import com.matthiasbruns.chromameditation.R;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mbruns on 09/02/2017.
 */

public class ColorActivity extends AppCompatActivity {

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

    private static final String TAG = ColorActivity.class.getSimpleName();

    public static final String EXTRA_CONFIGURATION = TAG + "_configuration";

    @BindView(R.id.color_view)
    protected View mColorView;

    private Configuration mConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_color);

        if (savedInstanceState == null) {
            savedInstanceState = getIntent().getExtras();
        }
        mConfiguration = (Configuration) savedInstanceState.getSerializable(EXTRA_CONFIGURATION);

        ButterKnife.bind(this);

        mColorView.setBackgroundColor(mConfiguration.mColor);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable(EXTRA_CONFIGURATION, mConfiguration);
        super.onSaveInstanceState(outState);
    }

    public static Intent create(@NonNull final Context context, final Configuration configuration) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CONFIGURATION, configuration);
        final Intent intent = new Intent(context, ColorActivity.class);
        intent.putExtras(bundle);
        return intent;
    }
}
