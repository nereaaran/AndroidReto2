package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.airbnb.lottie.LottieAnimationView;

public class SignupActivity extends AppCompatActivity {

    private Button myBtnGoBack = null;
    private Button myBtnSignup = null;
    private ProgressBar myProgressBar = null;
    private EditText myEditTxtLogin = null;
    private EditText myEditTxtPassword = null;
    private EditText myEditTxtName = null;
    private EditText myEditTxtEmail = null;
    private EditText myEditTxtDni = null;
    private EditText myEditTxtBirthDate = null;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializeObjects();

        /**
         * When the Signup button is pressed itchecks the textfields to sign up the user.
         */
        myBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTextFieldsNotEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.text_user_signup, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.text_error_empty_fields, Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         * A thread that is running to check the state of the textfields and update the progress bar.
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int progress = 0;
                    if (!myEditTxtLogin.getText().toString().isEmpty()) {
                        progress = progress + 1;
                    }
                    if (!myEditTxtPassword.getText().toString().isEmpty()) {
                        progress = progress + 1;
                    }
                    if (!myEditTxtEmail.getText().toString().isEmpty()) {
                        progress = progress + 1;
                    }
                    if (!myEditTxtName.getText().toString().isEmpty()) {
                        progress = progress + 1;
                    }
                    if (!myEditTxtDni.getText().toString().isEmpty()) {
                        progress = progress + 1;
                    }
                    if (!myEditTxtBirthDate.getText().toString().isEmpty()) {
                        progress = progress + 1;
                    }
                    myProgressBar.setProgress(progress);
                }
            }
        }).start();

        /**
         * When the GoBack button is pressed it goes to the Login activity.
         */
        myBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                SignupActivity.super.finish();
            }
        });
    }

    /**
     * Checks if all the textields contain text.
     *
     * @return A variable indicating if all textfields contain text or not.
     */
    private boolean checkTextFieldsNotEmpty() {
        if (myEditTxtLogin.getText().toString().isEmpty() || myEditTxtPassword.getText().toString().isEmpty()
                || myEditTxtName.getText().toString().isEmpty() || myEditTxtEmail.getText().toString().isEmpty()
                || myEditTxtDni.getText().toString().isEmpty() || myEditTxtBirthDate.getText().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * References the objects used in this class with the ones of the layout.
     */
    private void initializeObjects() {
        myBtnGoBack = (Button) findViewById(R.id.btnBackToLogin_signup);
        myBtnSignup = (Button) findViewById(R.id.btnSignup_signup);

        myProgressBar = (ProgressBar) findViewById(R.id.progressBar_signup);

        myEditTxtLogin = (EditText) findViewById(R.id.editTxtLogin_signup);
        myEditTxtLogin.requestFocus();
        myEditTxtPassword = (EditText) findViewById(R.id.editTxtPassword_signup);
        myEditTxtName = (EditText) findViewById(R.id.editTxtName_signup);
        myEditTxtEmail = (EditText) findViewById(R.id.editTxtEmail_signup);
        myEditTxtDni = (EditText) findViewById(R.id.editTxtDni_signup);
        myEditTxtBirthDate = (EditText) findViewById(R.id.editTxtBirthDate_signup);
    }
}
