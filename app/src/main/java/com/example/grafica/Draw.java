package com.example.grafica;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Draw {
    private Canvas canvas;
    private Paint paint;
    private SurfaceHolder holder;
    private Bitmap picture;

    public Draw(Paint paint, SurfaceHolder holder){
        this.paint = paint;
        this.holder = holder;
    }
    public void DrawObject(int[] cord, Bitmap picture){
        canvas = null;
        try {
            // получаем объект Canvas и выполняем отрисовку
            canvas = holder.lockCanvas(null);
            synchronized (holder) {
                canvas.drawColor(Color.WHITE);
                canvas.drawBitmap(picture, cord[0], cord[1], paint);
            }
        }
        finally {
            if (canvas != null) {
                // отрисовка выполнена. выводим результат на экран
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
