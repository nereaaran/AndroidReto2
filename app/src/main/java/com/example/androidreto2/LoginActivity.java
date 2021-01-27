package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

    private SQLiteDatabase dataBase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeObjects();

        rememberMeGetData(1);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        myBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTextFieldsNotEmpty()) {

                    encode("hola");/////////////////////////////

                    rememberMeImplementation();
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.text_error_empty_fields, Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         * When "Login" text fields loses focus.
         */
        myEditTxtLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    rememberMeGetData(2);
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
         * When the ForgotPassword text view is touched it goes to the RestorePassword activity.
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

    /**
     * Sends the password to the "EncodePassword" class and returns it encoded and in hexadecimal.
     * @param password The password to be encoded.
     * @return Te password encoded.
     */
    private String encode(String password){
        EncodePassword encoder = new EncodePassword(this);
        return encoder.encodeWithPublicKey(password);
    }

    /**
     * Searches in the database for user login and password and fills the text fields with the data.
     *
     * @param number A number to know if it is called from "OnCreate" or when "myEditTxtLogin" looses focus.
     */
    private void rememberMeGetData(int number) {
        try {
            dataBase = openOrCreateDatabase("library_db", Context.MODE_PRIVATE, null);
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS logindata(login VARCHAR, password VARCHAR);");
            Cursor cursor = null;

            if (number == 1) {
                cursor = dataBase.rawQuery("SELECT * FROM logindata", null);
            } else if (number == 2) {
                cursor = dataBase.rawQuery("SELECT * FROM logindata WHERE login='" + myEditTxtLogin.getText().toString() + "'", null);
            }

            if (cursor.getCount() > 0) {
                String login = null;
                String password = null;
                while (cursor.moveToNext()) {
                    login = cursor.getString(0);
                    password = cursor.getString(1);
                }
                myEditTxtLogin.setText(login);
                myEditTxtPassword.setText(password);
                myChkRememberMe.setChecked(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * When Login button is pressed it verifies if "Remember Me" is checked and saves the login
     * information in the database. If it is not checked it erases it.
     */
    private void rememberMeImplementation() {
        try {
            dataBase = openOrCreateDatabase("library_db", Context.MODE_PRIVATE, null);
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS logindata(login VARCHAR, password VARCHAR);");
            if (myChkRememberMe.isChecked()) {
                dataBase.execSQL("INSERT INTO logindata VALUES ('" + myEditTxtLogin.getText().toString() + "', '" + myEditTxtPassword.getText().toString() + "')");
            } else {
                dataBase.execSQL("DELETE FROM logindata WHERE login='" + myEditTxtLogin.getText().toString() + "' AND password='" + myEditTxtPassword.getText().toString() + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if all the text fields contain text.
     *
     * @return A variable indicating if all text fields contain text or not.
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

