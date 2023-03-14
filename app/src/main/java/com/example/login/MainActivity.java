package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Username;
    EditText Password;
    AppCompatButton Login;
    AppCompatButton Change;

    public static final String PASS = "Buzzinga!";

    String CheckPass = "Buzzinga!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Newpass);
        Login = findViewById(R.id.cng_pass);
        Change = findViewById(R.id.Change);

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Forgot_Pass.class));
            }
        });

        Intent i = getIntent();
        String passwrd = i.getStringExtra(Forgot_Pass.PASS);
        if (passwrd != null){
            CheckPass = passwrd;
        }



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = Username.getText().toString();
                String inputPassword = Password.getText().toString();

                if (inputName.equals("Sheldon") && inputPassword.equals(CheckPass)){
                    Intent i2 = new Intent(MainActivity.this, Upload.class);
                    i2.putExtra(PASS,CheckPass);
                    startActivity(i2);
                }
                else{
                    Toast.makeText(MainActivity.this, "INVALID USERNAME OR PASSWORD",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    }
