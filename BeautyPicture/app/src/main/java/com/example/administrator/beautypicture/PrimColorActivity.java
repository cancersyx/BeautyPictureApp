package com.example.administrator.beautypicture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by zsf on 2016/12/9.
 */
public class PrimColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private SeekBar mSeekBarHue;
    private SeekBar mSeekBarSaturation;
    private SeekBar mSeekBarLum;
    private float mHue;
    private float mSaturation;
    private float mLum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prim_color);
        initView();
        initData();
        initEvent();


    }

    private void initEvent() {
        mSeekBarHue.setOnSeekBarChangeListener(this);
        mSeekBarSaturation.setOnSeekBarChangeListener(this);
        mSeekBarLum.setOnSeekBarChangeListener(this);

    }

    private void initData() {
        mSeekBarHue.setMax(MAX_VALUE);
        mSeekBarSaturation.setMax(MAX_VALUE);
        mSeekBarLum.setMax(MAX_VALUE);
        mSeekBarHue.setProgress(MID_VALUE);
        mSeekBarSaturation.setProgress(MID_VALUE);
        mSeekBarLum.setProgress(MID_VALUE);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pic1);
        mImageView.setImageBitmap(bitmap);
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.iv_picture_area);
        mSeekBarHue = (SeekBar) findViewById(R.id.seekBarHue);
        mSeekBarSaturation = (SeekBar) findViewById(R.id.seekBarSaturation);
        mSeekBarLum = (SeekBar) findViewById(R.id.seekBarLum);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekBarHue:
                mHue = (progress - MID_VALUE) * 1.0f /MID_VALUE * 180;
                break;
            case R.id.seekBarSaturation:
                mSaturation = progress * 1.0f /MID_VALUE;
                break;
            case R.id.seekBarLum:
                mLum = progress * 1.0f /MID_VALUE;
                break;
        }
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap,mHue,mSaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
