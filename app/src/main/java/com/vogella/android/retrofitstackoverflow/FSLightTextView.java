package com.vogella.android.retrofitstackoverflow;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Sifat on 2/6/2016.
 */
public class FSLightTextView extends TextView {

    public FSLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/fslight.otf"));
    }
}
