package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {

    EditText usernames,passwords;
    Button signin;
    int counter=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        usernames=findViewById(R.id.usernames);
        passwords=findViewById(R.id.passwords);
        signin=findViewById(R.id.signin);

        Bundle bundle=getIntent().getExtras();
        String uname=bundle.getString("username");
        String pass=bundle.getString("password");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= usernames.getText().toString().trim();
                String pwd=passwords.getText().toString().trim();

                if(user.equals(uname) && pwd.equals(pass)){
                    Toast.makeText(signin.this, "login success", Toast.LENGTH_SHORT).show();
                }else
                {
                    counter=counter-1;
                    Toast.makeText(signin.this, "Login Failed, you have" +counter +"remaining attempts", Toast.LENGTH_SHORT).show();
                    if(counter==0){
                        signin.setEnabled(false);
                    }
                }
            }
        });

    }
}