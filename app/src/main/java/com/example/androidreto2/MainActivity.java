package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// Prueba de viajes entre pantalla. Borrarlos al final.

        Button checkbox = (Button) findViewById(R.id.irACheckBook_main);
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CheckBookActivity.class);
                startActivity(intent);
            }
        });
        Button miperfil = (Button) findViewById(R.id.irAMiPerfil_main);
        miperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });



    }
}