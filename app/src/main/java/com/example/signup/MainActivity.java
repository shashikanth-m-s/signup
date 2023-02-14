package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button signup;
    String regExp="^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=findViewById(R.id.signup);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString().trim();
                String pwd=password.getText().toString().trim();
                if(validatePassword(pwd))
                {
                    Bundle bundle=new Bundle();
                    bundle.putString("username",uname);
                    bundle.putString("password",pwd);
                    Intent intent=new Intent(MainActivity.this,signin.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else
                    {
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validatePassword(String pwd){
        Pattern pattern=Pattern.compile(regExp);
       Matcher matcher= pattern.matcher(pwd);

       return matcher.matches();
    }
}