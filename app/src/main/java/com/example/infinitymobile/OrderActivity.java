package com.example.infinitymobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    Spinner services;
    ImageButton btn_send_final, btn_checktype;
    EditText namecli,snamecli,celcli,emailcli,descricli;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        services = (Spinner)findViewById(R.id.spinnertipoorder);
        btn_send_final = (ImageButton)findViewById(R.id.imageButtonCadOrder);
        btn_checktype = (ImageButton)findViewById(R.id.imageButtonTypeCheck);
        namecli = (EditText)findViewById(R.id.editTextNameCli);
        snamecli = (EditText)findViewById(R.id.editTextSnameCli);
        celcli = (EditText)findViewById(R.id.editTextCelCli);
        emailcli = (EditText)findViewById(R.id.editTextEmailCli);
        descricli = (EditText)findViewById(R.id.editTextDescriOrder);
        total = (TextView)findViewById(R.id.textViewValueTotal);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tipos_pedido, android.R.layout.simple_spinner_item);
        services.setAdapter(adapter);

        btn_send_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(OrderActivity.this, FinalActivity.class);
                in.putExtra("name_cli", namecli.getText().toString());
                in.putExtra("sname_cli", snamecli.getText().toString());
                in.putExtra("descri_cli", descricli.getText().toString());
                in.putExtra("type_cli", services.getSelectedItem().toString());
                startActivity(in);
                finish();
            }
        });

        btn_checktype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = services.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "O tipo de serviço escolhido foi: " +item, Toast.LENGTH_SHORT).show();
            }
        });
        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = services.getSelectedItem().toString();
                if (item.equals("Web")){
                    total.setText("Valor Total: R$3200");
                }
                else if (item.equals("Mobile")){
                    total.setText("Valor Total: R$5500");
                }
                else if (item.equals("Web e Mobile")) {
                    total.setText("Valor Total: R$8300");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nenhum tipo de serviço foi selecionado", Toast.LENGTH_SHORT).show();
            }
        };

        services.setOnItemSelectedListener(escolha);
    }
}