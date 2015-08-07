package com.example.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class UnderlineEditText extends EditText {
    private static final String TAG = "UnderlineEditText";
    private Paint mPaint;
    private Rect mRect;
    private float mult = 1.5f;
    private float add = 2.0f;

    public UnderlineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UnderlineEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        mPaint.setAntiAlias(true);
        setLineSpacing(add, mult);
    }


    @Override


    public void onDraw(Canvas canvas) {
        int count = getLineCount();
        int height = getLineHeight();
        for (int i = 0; i < count; i++) {
            getLineBounds(i, mRect);
            int baseline = (i + 1) * getLineHeight()+10;
            canvas.drawLine(mRect.left, height*(i+1), mRect.right, height*(i+1), mPaint);
        }
        super.onDraw(canvas);
    }


}
