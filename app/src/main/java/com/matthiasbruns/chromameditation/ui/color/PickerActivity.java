package com.matthiasbruns.chromameditation.ui.color;

import com.matthiasbruns.chromameditation.R;
import com.matthiasbruns.chromameditation.content.ColorSetting;
import com.matthiasbruns.chromameditation.ui.BaseAcvitiy;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import butterknife.BindViews;

/**
 * Created by mbruns on 09/02/2017.
 */

public class PickerActivity extends BaseAcvitiy {

    final View.OnClickListener mColorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.view_chrome_purple:
                    launchColorFragment(v, getColorSupport(R.color.chroma_purple),
                            getString(R.string.chroma_purple_title),
                            getString(R.string.chroma_purple_description));
                    break;
                case R.id.view_chrome_indigo:
                    launchColorFragment(v, getColorSupport(R.color.chroma_indigo),
                            getString(R.string.chroma_indigo_title),
                            getString(R.string.chroma_indigo_description));
                    break;
                case R.id.view_chrome_blue:
                    launchColorFragment(v, getColorSupport(R.color.chroma_blue),
                            getString(R.string.chroma_blue_title),
                            getString(R.string.chroma_blue_description));
                    break;
                case R.id.view_chrome_green:
                    launchColorFragment(v, getColorSupport(R.color.chroma_green),
                            getString(R.string.chroma_green_title),
                            getString(R.string.chroma_green_description));
                    break;
                case R.id.view_chrome_yellow:
                    launchColorFragment(v, getColorSupport(R.color.chroma_yellow),
                            getString(R.string.chroma_yellow_title),
                            getString(R.string.chroma_yellow_description));
                    break;
                case R.id.view_chrome_orange:
                    launchColorFragment(v, getColorSupport(R.color.chroma_orange),
                            getString(R.string.chroma_orange_title),
                            getString(R.string.chroma_orange_description));
                    break;
                case R.id.view_chrome_red:
                    launchColorFragment(v, getColorSupport(R.color.chroma_red),
                            getString(R.string.chroma_red_title),
                            getString(R.string.chroma_red_description));
                    break;
            }

        }
    };

    @BindViews({R.id.view_chrome_purple, R.id.view_chrome_indigo, R.id.view_chrome_blue,
            R.id.view_chrome_green, R.id.view_chrome_yellow, R.id.view_chrome_orange,
            R.id.view_chrome_red})
    protected View[] mColorViews;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picker);

        for (final View child : mColorViews) {
            child.setOnClickListener(mColorClickListener);
        }
    }

    public static Intent create(final Context context) {
        return new Intent(context, PickerActivity.class);
    }

    private int getColorSupport(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getColor(colorRes);
        }
        return getResources().getColor(colorRes);

    }

    private void launchColorFragment(@NonNull final View view, final int color, final String title,
            final String description) {

        ViewCompat.setTransitionName(view, getString(R.string.transition_color_view));
        final Intent intent = ColorActivity
                .create(this, new ColorSetting(color, title, description));

        final ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view,
                        getString(R.string.transition_color_view));
        startActivity(intent, options.toBundle());
    }
}
