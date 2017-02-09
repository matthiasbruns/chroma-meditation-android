package com.matthiasbruns.chromameditation.ui.main;

import com.matthiasbruns.chromameditation.R;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindViews({R.id.view_chrome_purple, R.id.view_chrome_indigo, R.id.view_chrome_blue,
            R.id.view_chrome_green, R.id.view_chrome_yellow, R.id.view_chrome_orange,
            R.id.view_chrome_red})
    protected View[] mColorViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        for (final View view : mColorViews) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.view_chrome_purple:
                launchColorFragment(getColorSupport(R.color.chroma_purple),
                        getString(R.string.chroma_purple_title),
                        getString(R.string.chroma_purple_description));
                break;
            case R.id.view_chrome_indigo:
                launchColorFragment(getColorSupport(R.color.chroma_indigo),
                        getString(R.string.chroma_indigo_title),
                        getString(R.string.chroma_indigo_description));
                break;
            case R.id.view_chrome_blue:
                launchColorFragment(getColorSupport(R.color.chroma_blue),
                        getString(R.string.chroma_blue_title),
                        getString(R.string.chroma_blue_description));
                break;
            case R.id.view_chrome_green:
                launchColorFragment(getColorSupport(R.color.chroma_green),
                        getString(R.string.chroma_green_title),
                        getString(R.string.chroma_green_description));
                break;
            case R.id.view_chrome_yellow:
                launchColorFragment(getColorSupport(R.color.chroma_yellow),
                        getString(R.string.chroma_yellow_title),
                        getString(R.string.chroma_yellow_description));
                break;
            case R.id.view_chrome_orange:
                launchColorFragment(getColorSupport(R.color.chroma_orange),
                        getString(R.string.chroma_orange_title),
                        getString(R.string.chroma_orange_description));
                break;
            case R.id.view_chrome_red:
                launchColorFragment(getColorSupport(R.color.chroma_red),
                        getString(R.string.chroma_red_title),
                        getString(R.string.chroma_red_description));
                break;
        }
    }

    private int getColorSupport(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getColor(colorRes);
        }
        return getResources().getColor(colorRes);

    }

    private void launchColorFragment(final int color, final String title,
            final String description) {
        final Fragment fragment = ColorFragment
                .create(new ColorFragment.Configuration(color, toString(), description));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(title)
                .commit();
    }
}
