package com.example.du_an_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    TextView txtWC, txt_nameWC,txt_khWC,txt_hdsdWC;
    Button btnlogin_wc,btnregister_wc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView img_logo = findViewById(R.id.img_logo);
        txtWC = findViewById(R.id.txt_wc);
        txt_nameWC = findViewById(R.id.txt_nameWC);
        txt_khWC = findViewById(R.id.txt_khWC);
        txt_hdsdWC = findViewById(R.id.txt_hdsdWC);
        btnlogin_wc = findViewById(R.id.btnlogin_wc);
        btnregister_wc= findViewById(R.id.btnregister_wc);

        Animation sideanim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        Animation bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        img_logo.setAnimation(sideanim);
        txtWC.setAnimation(bottomanim);
        txt_nameWC.setAnimation(sideanim);
        txt_khWC.setAnimation(bottomanim);
        txt_hdsdWC.setAnimation(bottomanim);

        btnlogin_wc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this,login.class));
            }
        });
        btnregister_wc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this,register.class));
            }
        });
    }
}