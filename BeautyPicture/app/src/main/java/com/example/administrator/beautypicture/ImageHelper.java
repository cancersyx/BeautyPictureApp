package com.example.administrator.beautypicture;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by zsf on 2016/12/9.
 */
public class ImageHelper {

    public static Bitmap handleImageEffect(Bitmap bitmap,float hue,float saturation,float lum){
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bitmap,0,0,paint);//注意是bitmap而不是bmp

        return bmp;
    }
}
