package com.example.infinitymobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    ImageButton btnregister, btnseta;
    EditText urname, urpassword, urconfpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_register);
        btnregister = (ImageButton)findViewById(R.id.imageButtonCadastrar);
        btnseta = (ImageButton)findViewById(R.id.imageButtonSeta2);
        urname = (EditText)findViewById(R.id.editTextLogin);
        urpassword = (EditText)findViewById(R.id.editTxtPassword);
        urconfpass = (EditText)findViewById(R.id.editTxtConfirmPassword);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(RegisterActivity.this, HomeActivity.class);
                in.putExtra("EXTRA_MESSAGE_NAME", urname.getText().toString());
                in.putExtra("EXTRA_MESSAGE_CONFPASSWORD", urconfpass.getText().toString());
                in.putExtra("EXTRA_MESSAGE_PASSWORD", urpassword.getText().toString());
                Toast.makeText(getBaseContext(),"Cadastro Realizado com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(in);
                finish();
            }
        });

        btnseta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(inte);
            }
        });
    }
}