package com.example.asus.finaltime;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ViewFlipper;

public class Activity28 extends AppCompatActivity {
    ViewFlipper v_flipper;
    Button clk;
    VideoView videov;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_28);
        clk=(Button)findViewById(R.id.button7);
        videov=(VideoView)findViewById(R.id.videoView);
        mediaC=new MediaController(this);

        int images[]={R.drawable.de1,R.drawable.de2,R.drawable.de3};
        v_flipper=findViewById(R.id.v_flippers);
        for(int image:images){
            flipperImages(image);
        }
    }
    public  void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);


        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this,android.R.anim.slide_out_right);
    }
    public void videoplay(View v){
        String videopath="android.resource://com.example.asus.finaltime/"+R.raw.m;
        Uri uri= Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();
    }
}
