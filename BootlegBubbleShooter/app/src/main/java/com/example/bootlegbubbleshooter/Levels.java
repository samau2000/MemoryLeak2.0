package com.example.bootlegbubbleshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Levels extends AppCompatActivity {
    ImageButton rocketButton;

    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        rocketButton = (ImageButton)findViewById(R.id.imageButton6);

        rocketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Levels.this, "It works", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                rocketButton.setX((int) event.getX() - 165);
                rocketButton.setY(900);
        }
        return true;
    }



}
