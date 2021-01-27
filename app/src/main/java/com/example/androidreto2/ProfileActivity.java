package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /**
         * Prueba de viajes entre pantalla. Borrarlos al final.
         */
        Button principal = (Button) findViewById(R.id.irAPrincipial_profile);
        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                ProfileActivity.super.finish();
            }
        });
        Button checkbox = (Button) findViewById(R.id.irACheckbook_profile);
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CheckBookActivity.class);
                startActivity(intent);
                ProfileActivity.super.finish();
            }
        });



    }
}
