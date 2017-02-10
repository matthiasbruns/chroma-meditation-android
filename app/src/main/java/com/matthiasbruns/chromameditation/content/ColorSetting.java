package com.matthiasbruns.chromameditation.content;

import java.io.Serializable;

/**
 * Created by mbruns on 09/02/2017.
 */
public class ColorSetting implements Serializable {

    public int mColor;

    public String mDescription;

    public String mTitle;

    public ColorSetting(final int color, final String title, final String description) {
        mColor = color;
        mDescription = description;
        mTitle = title;
    }
}
