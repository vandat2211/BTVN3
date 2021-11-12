package com.example.btvn3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editTextuser,editTextpass,editTextpass2;
TextView text1;
Button buttontt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextuser=(EditText)findViewById(R.id.eduser) ;
        editTextpass2=(EditText)findViewById(R.id.edpass2) ;
        editTextpass=(EditText)findViewById(R.id.edpass) ;
        buttontt=(Button) findViewById(R.id.bt)   ;
        text1=(TextView)findViewById(R.id.textViewnote) ;
        buttontt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =editTextuser.getText().toString();
                String pass =editTextpass.getText().toString().trim();
                String pass2 =editTextpass2.getText().toString().trim();
               boolean check = validateinfo(user,pass,pass2);
               if (check==true){
                   Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
               }
               else Toast.makeText(getApplicationContext(),"vui long nhap lai",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateinfo(String user, String pass, String pass2) {
        if (user.isEmpty()) {
            text1.setText("vui long nhap");
            return false;
        }
        else if (user.length() < 6) {
            text1.setText("user toi thieu 6 ki tu");
            return false;
        }
        else if (pass.length() < 8) {
            text1.setText("mat khau phai co it nhat 8 ki tu");
            return false;
        }
        else if(!pass.equals(pass2)){
            text1.setText("mat khau ko trung khop");
            return false;
        }
        else {
            text1.setText("");
            return true;
        }

    }
}