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
        canvas = holder.lockCanvas(null);
        this.paint = paint;
        this.holder = holder;
    }
    public void DrawObject(int[] cord, Bitmap picture){
        canvas = holder.lockCanvas(null);
        canvas.drawBitmap(picture, cord[0], cord[1], paint);
        if (canvas != null) {
            // отрисовка выполнена. выводим результат на экран
            holder.unlockCanvasAndPost(canvas);
        }
    }
}
