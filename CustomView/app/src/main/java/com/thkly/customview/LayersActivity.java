package com.thkly.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LayersActivity extends AppCompatActivity {

    /*
    source: Android 2D Graphics学习（二）、Canvas篇1、Canvas基本使用
    link: http://blog.csdn.net/lonelyroamer/article/details/8264189
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SampleView(this));
    }

    private static class SampleView extends View {
        private static final int LAYER_FLAGS = Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG
                | Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.FULL_COLOR_LAYER_SAVE_FLAG
                | Canvas.CLIP_TO_LAYER_SAVE_FLAG;
        private Paint mPaint;

        public SampleView(Context context){
            super(context);
            setFocusable(true);
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }

        @SuppressLint("WrongConstant")
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.translate(10, 10);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(75, 75, 75, mPaint);
            canvas.saveLayerAlpha(0, 0, 200, 300, 0x88, LAYER_FLAGS);
            mPaint.setColor(Color.GREEN);
            canvas.drawCircle(125, 125, 75, mPaint);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(155, 155, 75, mPaint);
            canvas.restore();
            mPaint.setColor(Color.GREEN);
            canvas.drawCircle(250, 250, 75, mPaint);
        }
    }
}
