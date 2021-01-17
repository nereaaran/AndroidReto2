package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.airbnb.lottie.LottieAnimationView;
import com.example.androidreto2.security.EncodePassword;

public class LoginActivity extends AppCompatActivity {

    private Button myBtnLogin = null;
    private Button myBtnSignup = null;
    private ToggleButton myTgBtnAnimation = null;
    private TextView myTxtForgotPassword = null;
    private CheckBox myChkRememberMe = null;
    private LottieAnimationView myViewAnimationBook = null;
    private EditText myEditTxtLogin = null;
    private EditText myEditTxtPassword = null;
    private Intent intent = null;

    private SharedPreferences mySharedPrefrences = null;
    private static final String PREFS_NAME = "PreferencesFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeObjects();

        mySharedPrefrences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        getPreferencesData();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        myBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTextFieldsNotEmpty()) {
                    rememberMeImplementation();


                    cifrar();

                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.text_error_empty_fields, Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         * When the Signup button is pressed it goes to the Signup activity.
         */
        myBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

        /**
         * When the ForgotPassword textview is touched it goes to the RestorePassword activity.
         */
        myTxtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), RestorePasswordActivity.class);
                startActivity(intent);
            }
        });

        /**
         * When the Animation toggle button is pressed it plays and stops the lottie animation
         * depending on the state of the toggle button.
         */
        myTgBtnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myTgBtnAnimation.isChecked()) {
                    myViewAnimationBook.playAnimation();
                } else {
                    myViewAnimationBook.pauseAnimation();
                }
            }
        });
    }



    private void cifrar(){
        String hola="hola";
        String cif = "";

        EncodePassword encoder = new EncodePassword();
        //cif= encoder.cifrarConClavePublica(hola);

        myTxtForgotPassword.setText(cif);

        encoder = new EncodePassword();
        //cif= encoder.cifrarConClavePublica(hola);

        //myEditTxtLogin.setText(cif);
    }



    private void getPreferencesData() {


    }

    private void rememberMeImplementation() {
        if (myChkRememberMe.isChecked()) {
            SharedPreferences.Editor editor = mySharedPrefrences.edit();
            editor.putString("pref_name", myEditTxtLogin.getText().toString());
            editor.putString("pref_pass", myEditTxtPassword.getText().toString());
            editor.putBoolean("pref_check", myChkRememberMe.isChecked());
            editor.apply();
        } else {
            mySharedPrefrences.edit().clear().apply();
        }
    }




    /**
     * Checks if all the textields contain text.
     * @return A variable indicating if all textfields contain text or not.
     */
    private boolean checkTextFieldsNotEmpty() {
        if (myEditTxtLogin.getText().toString().isEmpty() || myEditTxtPassword.getText().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * References the objects used in this class with the ones of the layout.
     */
    private void initializeObjects() {
        myBtnLogin = (Button) findViewById(R.id.btnLogin_login);
        myBtnSignup = (Button) findViewById(R.id.btnSignUp_login);
        myTgBtnAnimation = (ToggleButton) findViewById(R.id.tgBtnAnimation);
        myTxtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword_login);

        myChkRememberMe = (CheckBox) findViewById(R.id.chkRememberMe_login);
        myViewAnimationBook = (LottieAnimationView) findViewById(R.id.viewAnimationBook);
        myViewAnimationBook.pauseAnimation();

        myEditTxtLogin = (EditText) findViewById(R.id.editTxtLogin_login);
        myEditTxtLogin.requestFocus();
        myEditTxtPassword = (EditText) findViewById(R.id.editTxtPassword_login);
    }
}

