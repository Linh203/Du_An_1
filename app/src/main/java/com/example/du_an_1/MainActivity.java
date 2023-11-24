package com.example.du_an_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img_main = findViewById(R.id.img_main);
        TextView txt_main = findViewById(R.id.txt_main);
        TextView txt_power = findViewById(R.id.txt_powerMain);

        //Đối tượng Animation
        Animation sideanim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        Animation bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //thiết lập animation cho component
        img_main.setAnimation(sideanim);
        txt_main.setAnimation(sideanim);
        txt_power.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Welcome.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },3000);
    }
}