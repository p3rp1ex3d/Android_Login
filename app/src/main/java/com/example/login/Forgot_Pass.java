package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Forgot_Pass extends AppCompatActivity {

    Button cng_pass;
    EditText User,newPass,conPass;

    public static final String PASS = "Buzzinga!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        Intent i = new Intent(Forgot_Pass.this, MainActivity.class);

        RelativeLayout relativeLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        cng_pass = findViewById(R.id.cng_pass);
        User=findViewById(R.id.Username);
        newPass=findViewById(R.id.Newpass);
        conPass=findViewById(R.id.Conpass);


        cng_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (User.getText().toString().equals("Sheldon")){
                    String pass = newPass.getText().toString();
                    String con = conPass.getText().toString();
                    if (pass.equals(con)){
                        i.putExtra(PASS,pass);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(Forgot_Pass.this, "PASSWORD NOT MATCHING!!",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Forgot_Pass.this, "INVALID USERNAME",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}