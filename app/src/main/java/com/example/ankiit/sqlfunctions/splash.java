package com.example.ankiit.sqlfunctions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Ankiit on 18-Mar-18.
 */

public class splash extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spl);

        iv = (ImageView) findViewById(R.id.iv1);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        iv.startAnimation(myanim);
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);





                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();


                }
            }
        };
        timer.start();
    }
}
