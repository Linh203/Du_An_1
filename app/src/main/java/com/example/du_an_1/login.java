package com.example.du_an_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_1.Commo.commo;
import com.example.du_an_1.Model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    Button btnback_log,btnlogin_log;
    TextInputEditText txtloginTK,txtloginMK;
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnback_log = findViewById(R.id.btnback_log);
        btnlogin_log = findViewById(R.id.btnlogin_log);
        txtloginTK = findViewById(R.id.txt_loginTK);
        txtloginMK = findViewById(R.id.txt_loginMK);
        firebaseDatabase = FirebaseDatabase.getInstance();
        User = firebaseDatabase.getReference("User");
        btnlogin_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtloginTK.getText().toString().equals("")){
                    Toast.makeText(login.this, "Mày chưa nhập tài khoản", Toast.LENGTH_SHORT).show();
                }else if (txtloginMK.getText().toString().equals("")){
                    Toast.makeText(login.this, "Mày lại chưa nhập mật khẩu đầu khấc", Toast.LENGTH_SHORT).show();
                }else {
                    User.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.child(txtloginTK.getText().toString()).exists()){
                                com.example.du_an_1.Model.User user = snapshot.child(txtloginTK.getText().toString()).getValue(com.example.du_an_1.Model.User.class);
                                user.setPhone(txtloginTK.getText().toString());
                                if (user.getPassword().equals(txtloginMK.getText().toString())){
                                    commo.curentUser = user;
                                    Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(login.this,Home.class));
                                }else {
                                    Toast.makeText(login.this, "Sai mật khẩu hoặc tài khoản", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(login.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        btnback_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}