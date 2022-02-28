package com.example.grafica;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceHolder = getHolder();
        canvas = surfaceHolder.lockCanvas();

        Paint paint = new Paint();

        Physics physics = new Physics(canvas.getWidth(), canvas.getHeight());

        Draw draw = new Draw(canvas, paint);

        DrawThread drawThread = new DrawThread(surfaceHolder);
        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}

class DrawThread extends Thread {
    private SurfaceHolder surfaceHolder;
    public boolean runFlag = true;

    DrawThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void setRunning(boolean flag){
        runFlag = flag;
    }

    @Override
    public void run() {
        Canvas canvas;
        long lastActuation = 0;
        while (runFlag) {
            long now = System.currentTimeMillis();
            if (now - lastActuation >= 16){
                lastActuation = now;
                canvas = surfaceHolder.lockCanvas();


            }


        }
    }
}