package com.example.infinitymobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class InfoActivity extends AppCompatActivity {

    ImageButton seta,homebtn,orderbtn;
    ImageView maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        seta = (ImageButton)findViewById(R.id.imageButtonSeta3);
        homebtn = (ImageButton)findViewById(R.id.imageButtonHome2);
        orderbtn = (ImageButton)findViewById(R.id.imageButtonOrder2);
        maps = (ImageView)findViewById(R.id.imageViewInfoMaps);

        seta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(InfoActivity.this, HomeActivity.class);
                startActivity(in);
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, FinalActivity.class);
                startActivity(intent);
            }
        });

        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(InfoActivity.this, OrderActivity.class);
                startActivity(in);
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:-23.63067834449986,-46.67786097749998");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}