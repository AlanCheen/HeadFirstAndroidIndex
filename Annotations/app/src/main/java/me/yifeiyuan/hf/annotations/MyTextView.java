package me.yifeiyuan.hf.annotations;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by 程序亦非猿 on 2022/5/25.
 */
class MyTextView extends AppCompatTextView {
    public MyTextView(@NonNull Context context) {
        super(context);
        init();

    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    public void testFeature() {

        setTextColor(Color.parseColor("#00ff00"));

    }

}
