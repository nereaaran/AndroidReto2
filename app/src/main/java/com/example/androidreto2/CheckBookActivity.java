package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckBookActivity extends AppCompatActivity {

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book);

        /**
         * Prueba de viajes entre pantalla. Borrarlos al final.
         */
        Button principal = (Button) findViewById(R.id.irAPrincipal_chekBook);
        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                CheckBookActivity.super.finish();
            }
        });
        Button miperfil = (Button) findViewById(R.id.irAMiPerfil_checkBox);
        miperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CheckBookActivity.super.finish();
            }
        });



    }
}

