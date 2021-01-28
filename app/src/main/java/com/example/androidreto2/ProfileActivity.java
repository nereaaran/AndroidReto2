package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidreto2.Modelo.User;

public class ProfileActivity extends AppCompatActivity {

    Intent intent = null;

    private TextView userName;
    private TextView email;
    private TextView login;
    private TextView dni;
    private TextView birthDate;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = (User) getIntent().getSerializableExtra("User");

        initializeObjects();
        getUserData();
        /**
         * Prueba de viajes entre pantalla. Borrarlos al final.
         */
        /*Button principal = (Button) findViewById(R.id.irAPrincipial_profile);
        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                ProfileActivity.super.finish();
            }
        });*/
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

    private void initializeObjects() {
        userName = (TextView) findViewById(R.id.txtFieldName_profile);
        email =  (TextView) findViewById(R.id.txtFieldEmail_profile);
        login =  (TextView) findViewById(R.id.txtFieldUser_profile);
        dni =  (TextView) findViewById(R.id.txtFieldDni_profile);
        birthDate =  (TextView) findViewById(R.id.txtFieldBirthDate_profile);

    }

    private void getUserData() {

        userName.setText(user.getFullName());
        

    }
}

