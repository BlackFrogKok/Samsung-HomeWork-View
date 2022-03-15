package com.example.grafica;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private DrawThread drawThread;

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

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.bonk);
        Paint paint = new Paint();
        Physics physics = new Physics(canvas.getWidth(), canvas.getHeight(), picture);
        Draw draw = new Draw(paint, surfaceHolder);
        DrawThread drawThread = new DrawThread(surfaceHolder, draw, physics, picture);

        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.setRunning(false);
        try {
            drawThread.join();
        } catch (InterruptedException e) {
        }
    }
}

class DrawThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private Bitmap picture;
    private boolean runFlag = false;
    private Draw draw;
    private Physics physics;
    private int[] cord = new int[2];

    DrawThread(SurfaceHolder surfaceHolder, Draw draw, Physics physics, Bitmap picture) {
        this.picture = picture;
        this.surfaceHolder = surfaceHolder;
        this.draw = draw;
        this.physics = physics;
        cord = physics.getCord();
    }

    public void setRunning(boolean flag){
        runFlag = flag;
    }

    @Override
    public void run() {
        while (runFlag) {
            physics.CheckCollision();
            draw.DrawObject(cord, picture);
            cord = physics.CountingPhysics();
        }
    }
}