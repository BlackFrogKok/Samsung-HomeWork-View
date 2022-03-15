package com.example.grafica;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;

public class Physics {
    private int weightScreen;
    private int heightScreen;
    private SurfaceHolder holder;
    private int x, y;
    private static int reverseX, reverseY;
    private int speed = 2;
    private int[] cord = new int[2];

    Physics(int weightScreen, int heightScreen, Bitmap picture){
        this.weightScreen = weightScreen;
        this.heightScreen = heightScreen;
        cord[0] = weightScreen / 2;
        cord[1] = heightScreen / 2;
        x = picture.getWidth();
        y = picture.getHeight();

    }

    public int[] getCord() {
        return cord;
    }

    public void CheckCollision(){
        if (cord[0] + x >= weightScreen) {
            reverseX = -1;
        } else if (cord[1] + y >= heightScreen) {
            reverseY = -1;
        }
        else if (cord[0] <= 0){
            reverseX = 1;
        }
        else if (cord[1] <= 0){
            reverseY = 1;
        }
    }
    public int[] CountingPhysics(){
        cord[0] = cord[0] + (reverseX * speed * 9);
        cord[1] = cord[1] + (reverseY * speed * 16);
        return cord;
    }
}
