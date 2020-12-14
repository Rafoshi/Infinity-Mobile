package com.example.infinitymobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText urname, urpassword;
    ImageButton btnlogin, btnreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        btnlogin = (ImageButton)findViewById(R.id.ButtonLogin);
        btnreturn = (ImageButton)findViewById(R.id.imageButtonSeta);
        urname = (EditText)findViewById(R.id.editTextLogin);
        urpassword = (EditText)findViewById(R.id.editTxtPassword);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(urname.getText().toString().equals("Vitor") && urpassword.getText().toString().equals("123456"))
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                else
                    Toast.makeText(getBaseContext(),"Login ou senha inválidos", Toast.LENGTH_SHORT).show();

            }
        });

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}