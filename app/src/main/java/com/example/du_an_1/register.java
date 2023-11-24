package com.example.du_an_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_1.Model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class register extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference User;
    TextInputEditText edt_namergt,edt_phonergt,edt_passrgt,edt_mailrgt;
    Button btnback_rgt,btn_register_rgt;
    TextView txtlogin_rgt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_namergt = findViewById(R.id.edt_nameRgt);
        edt_phonergt = findViewById(R.id.edt_phoneRgt);
        edt_mailrgt = findViewById(R.id.edt_mailRgt);
        edt_passrgt = findViewById(R.id.edt_passRgt);

        btnback_rgt = findViewById(R.id.btnback_rgt);
        btn_register_rgt = findViewById(R.id.btnregister_rgt);
        txtlogin_rgt = findViewById(R.id.txtlogin_rgt);

        firebaseDatabase = FirebaseDatabase.getInstance();
        User = firebaseDatabase.getReference("User");
        btn_register_rgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_namergt.getText().toString().equals("")){
                    Toast.makeText(register.this, "Chưa nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                }else if (edt_phonergt.getText().toString().equals("")){
                    Toast.makeText(register.this, "Chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }else if (edt_mailrgt.getText().toString().equals("")){
                    Toast.makeText(register.this, "Chưa nhập email", Toast.LENGTH_SHORT).show();
                }else if (edt_passrgt.getText().toString().equals("")){
                    Toast.makeText(register.this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }else {
                    User.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Calendar c = Calendar.getInstance();
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String formattedDate = df.format(c.getTime());
                            com.example.du_an_1.Model.User user = new User(edt_mailrgt.getText().toString(),edt_namergt.getText().toString(),edt_phonergt.getText().toString(),edt_passrgt.getText().toString(),formattedDate,"false","null");
                            User.child(edt_phonergt.getText().toString()).setValue(user);
                            Toast.makeText(register.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        btnback_rgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtlogin_rgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,login.class));
            }
        });
    }
}