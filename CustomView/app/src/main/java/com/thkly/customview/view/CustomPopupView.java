package com.thkly.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.thkly.customview.R;

/**
 * Created by toushou on 02/01/2018.
 */

public class CustomPopupView extends View {
    String mText;
    int mWidth;
    int mRectWidth;
    int mHeight;
    int mRectHeight;
    double mRectPercent = 0.8;
    Paint mPaint;
    Rect mBound;

    public CustomPopupView(Context context) {
        this(context, null);
    }
    public CustomPopupView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public CustomPopupView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomPopupView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i =0; i<n; i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomPopupView_text:
                    mText = a.getString(attr);
                    break;
            }
        }
        a.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(23);
        mBound = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(widthMode == MeasureSpec.EXACTLY){
            mWidth = widthSize;
            mRectWidth = (int)(mWidth *mRectPercent);
        }
        if(heightMode == MeasureSpec.EXACTLY){
            mHeight = heightSize;
            mRectHeight = (int)(mHeight * mRectPercent + 0.1);
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.parseColor("#2C97DE"));
        p.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(0,0, mRectWidth, mRectHeight),
                10, 10, p);
        Path path = new Path();
        path.moveTo(mRectWidth/2-30, mRectHeight);
        path.lineTo(mRectWidth/2, mRectHeight+20);
        path.lineTo(mRectWidth/2+30, mRectHeight);
        path.close();
        canvas.drawPath(path, p);

        float drawTextWidth;
//        drawTextWidth = getWidth()/2 - mBound.width()/2;
        drawTextWidth = getWidth()/2;
        mText = mWidth+"," +drawTextWidth;
        canvas.drawText(mText, drawTextWidth,
                getHeight()/2 - mBound.height()/2, mPaint);
        super.onDraw(canvas);
    }
}
