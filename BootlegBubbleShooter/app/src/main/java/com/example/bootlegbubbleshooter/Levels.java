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

    ImageView cloudA = (ImageView)findViewById(R.id.CloudA);
    ImageView cloudB = (ImageView)findViewById(R.id.CloudB);
    ImageView cloudC = (ImageView)findViewById(R.id.CloudC);
    ImageView cloudD = (ImageView)findViewById(R.id.CloudD);


    //Question text
    public static TextView q_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

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

    public void changePos()
    {

        y_bullet-=10;


        if(bullet.getY() < (float)screenHeight)
        {
            y_bullet = -195.0f;
        }

        bullet.setY(y_bullet);
        /*
        cloud1Y +=10;
        if(cloud1.getY() > screenHeight)
        {
            cloud1X = 1*screenWidth/5;//(float)Math.floor(Math.random() * (screenWidth - cloud1.getWidth()));
            cloud1Y = -195.0f;
        }
        cloud1.setX(cloud1X);
        cloud1.setY(cloud1Y);

        cloud2Y +=10;
        if(cloud2.getY() > screenHeight)
        {
            cloud2X = screenWidth/1000;//(float)Math.floor(Math.random() * (screenWidth - cloud2.getWidth()));
            cloud2Y = -100.0f;
        }
        cloud2.setX(cloud2X);
        cloud2.setY(cloud2Y);

        cloud3Y +=10;
        if(cloud3.getY() > screenHeight)
        {
            cloud3X = 1*screenWidth/2;//(float)Math.floor(Math.random() * (screenWidth - cloud3.getWidth()));
            cloud3Y = -100.0f;
        }
        cloud3.setX(cloud3X);
        cloud3.setY(cloud3Y);
    */
    }


}
