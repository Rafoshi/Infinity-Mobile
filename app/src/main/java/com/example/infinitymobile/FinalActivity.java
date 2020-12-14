package com.example.infinitymobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView name,sname,type,descri,by,status;
    ImageButton btninfo,btnorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = (TextView)findViewById(R.id.textViewNameCli_);
        sname = (TextView)findViewById(R.id.textViewSname);
        type = (TextView)findViewById(R.id.textViewType);
        descri = (TextView)findViewById(R.id.textViewDescri);
        by = (TextView)findViewById(R.id.textViewPor);
        status = (TextView)findViewById(R.id.textViewStatus);
        btnorder = (ImageButton)findViewById(R.id.imageButtonOrder3);
        btninfo = (ImageButton)findViewById(R.id.imageButtonInfo3);

        String value = getIntent().getStringExtra("name_cli");
        name.setText(value);
        String value1 = getIntent().getStringExtra("sname_cli");
        sname.setText(value1);
        String value3 = getIntent().getStringExtra("descri_cli");
        descri.setText(value3);
        String value4 = getIntent().getStringExtra("type_cli");
        type.setText(value4);

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinalActivity.this, OrderActivity.class);
                startActivity(in);
            }
        });

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinalActivity.this, InfoActivity.class);
                startActivity(in);

            }
        });
    }
}