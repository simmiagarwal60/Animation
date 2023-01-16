package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView animationView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        animationView = findViewById(R.id.splash_circle);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationView.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                animationView.playAnimation();

                Thread td = new Thread(){
                    public void run(){
                        try{
                            sleep(5000);

                        } catch(Exception ex){
                            ex.printStackTrace();
                        }
                        finally{
                            Intent intent = new Intent(MainActivity.this, Detail_activity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }; td.start();
            }
        });
    }
}