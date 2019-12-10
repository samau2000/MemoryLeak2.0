package com.example.bootlegbubbleshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Levels extends AppCompatActivity {
    ImageButton rocketButton;
    ImageView bullet;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    float x, y;
    float x_bullet,y_bullet;
    float cloudAY;
    float cloudAYorig;

    ImageView cloudA ;
    ImageView cloudB ;
//    ImageView cloudC = (ImageView)findViewById(R.id.CloudC);
//    ImageView cloudD = (ImageView)findViewById(R.id.CloudD);

    //Question text
    public static TextView q_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        cloudA = (ImageView)findViewById(R.id.CloudA);
        cloudA.setX(-46); cloudA.setY(80);
        cloudAY = cloudA.getY();
        cloudAYorig= cloudAY;


//        cloudB.setX(27); cloudB.setY(157);
//        cloudC.setX(87); cloudC.setY(50);
//        cloudD.setX(214); cloudD.setY(124);

        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        changePos();
                    }
                });
            }
        },0,10);

        rocketButton = (ImageButton)findViewById(R.id.imageButton6);
        bullet = (ImageView)findViewById(R.id.imageView2);
        bullet.setVisibility(View.GONE);

        rocketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Levels.this, "It works", Toast.LENGTH_LONG).show();
                x_bullet = rocketButton.getX() + 165;
                y_bullet = rocketButton.getY() - 90;
                bullet.setX(x_bullet);
                bullet.setY(y_bullet);
                bullet.setVisibility(View.VISIBLE);


            }
        });

        //Question Data
        q_data = (TextView) findViewById(R.id.QuestionBox);
        fetchQuestionData process2 = new fetchQuestionData();
        process2.execute();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        rocketButton = (ImageButton)findViewById(R.id.imageButton6);
        bullet = (ImageView)findViewById(R.id.imageView2);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Toast.makeText(Levels.this, "It works", Toast.LENGTH_LONG).show();
                bullet.setVisibility(View.GONE);

            case MotionEvent.ACTION_MOVE:
                rocketButton.setX((int) event.getX() - 165);
                rocketButton.setY(900);
        }
        return true;
    }
    //initialize screen size
    private int screenWidth;
    private int screenHeight;

    //cloudAY = cloudA.getY();
 //   float cloudAYorig= cloudAY;

    public void changePos()
    {

        y_bullet-=10;


        if(bullet.getY() < (float)screenHeight)
        {
           // y_bullet.setVisibility(View.GONE);
        }

        bullet.setY(y_bullet);

   //    float cloudAX = cloudA.getX();

        cloudAY +=10;
       if(cloudA.getY() > 2600) {
           cloudAY=0.0f;
       }
       cloudA.setY(cloudAY);
        {
 //           cloudAX = 1*screenWidth/5;//(float)Math.floor(Math.random() * (screenWidth - cloud1.getWidth()));
//            cloudAY = -195.0f;
//        }
//        cloudA.setX(cloudAX);
//        cloudA.setY(cloudAY + 10);

//        cloud2Y +=10;
//        if(cloud2.getY() > screenHeight)
//        {
//            cloud2X = screenWidth/1000;//(float)Math.floor(Math.random() * (screenWidth - cloud2.getWidth()));
//            cloud2Y = -100.0f;
//        }
//        cloud2.setX(cloud2X);
//        cloud2.setY(cloud2Y);
//
//        cloud3Y +=10;
//        if(cloud3.getY() > screenHeight)
//        {
//            cloud3X = 1*screenWidth/2;//(float)Math.floor(Math.random() * (screenWidth - cloud3.getWidth()));
//            cloud3Y = -100.0f;
//        }
//        cloud3.setX(cloud3X);
//        cloud3.setY(cloud3Y);

    }


}}
