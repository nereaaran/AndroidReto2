package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RestorePasswordActivity extends AppCompatActivity {

    private Button myBtnGoBack = null;
    private Button myBtnRestore = null;
    private TextView myEditTxtEmail = null;
    private Intent intent = null;
    private Animation animation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore_password);

        initializeObjects();


        myBtnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myEditTxtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.text_error_empty_fields, Toast.LENGTH_LONG).show();
                } else {
                    myBtnRestore.setText("OK");/////////////////////////////////////////////
                }
            }
        });


        /**
         * When the GoBack button is pressed it goes to the Login activity.
         */
        myBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                RestorePasswordActivity.super.finish();
            }
        });
    }


    /**
     * It references the objects used in this class with the ones of the layout.
     */
    private void initializeObjects() {
        myBtnGoBack = (Button) findViewById(R.id.btnBackToLogin_restore_password);
        myBtnRestore = (Button) findViewById(R.id.btnRestore_restore_password);

        myEditTxtEmail = (TextView) findViewById(R.id.editTxtEmail_restore_password);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        myBtnRestore.startAnimation(animation);
    }
}

