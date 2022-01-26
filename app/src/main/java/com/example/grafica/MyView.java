package com.example.grafica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;



public class MyView extends View {
    private float centerX;
    private float centerY;
    public MyView(Context context) {

        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centerX = getWidth() / 2f;
        centerY = getHeight() / 2f;
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(0,0, centerX, centerY, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(getWidth(),0, centerX, centerY, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(getWidth(),getHeight(), centerX, centerY, paint);
        paint.setColor(Color.parseColor("#fda800"));
        canvas.drawRect(0,centerY, centerX, getHeight(), paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(centerX, centerY, centerX / 2f, paint);



//        if (x + rectWeight == getWidth()) flag = false;
//        else if (x == 0) flag = true;
//        if (flag) x += 1;
//        else x -= 1;
//        canvas.drawRect(x, 60, x + rectWeight, 60 + rectHeight, paint);
//        invalidate();


    }
}
