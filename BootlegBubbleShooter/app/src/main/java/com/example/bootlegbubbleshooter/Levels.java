package com.example.bootlegbubbleshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Levels extends AppCompatActivity {
    ImageButton rocketButton;
    ImageView bullet;

    float x, y;
    float x_bullet,y_bullet;

    //Question text
    public static TextView q_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

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
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Toast.makeText(Levels.this, "It works", Toast.LENGTH_LONG).show();

            case MotionEvent.ACTION_MOVE:
                rocketButton.setX((int) event.getX() - 165);
                rocketButton.setY(900);
        }
        return true;
    }



}
