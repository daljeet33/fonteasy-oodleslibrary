package com.oodles.fonteasy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by daljeet on 8/1/18.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        useCustomFont(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        useCustomFont(context, attrs);
    }

    private void useCustomFont(Context context, AttributeSet attrs) {
        //get array of all attributes of CustomTextView
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        //get font name from the font attribute of the attribute array
        String fontName = attrArray.getString(R.styleable.CustomTextView_textFont);
        Typeface customFont = selectTypeFace(context, fontName);
        setTypeface(customFont);
        attrArray.recycle();
    }

    private Typeface selectTypeFace(Context context, String fontName) {
            return FontCache.getTypeface(fontName, context);
    }
}
