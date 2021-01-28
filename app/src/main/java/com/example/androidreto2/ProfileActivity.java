package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    Intent intent = null;

    private TextView myTxtFieldName = null;
    private TextView myTxtFieldUser = null;
    private TextView myTxtFieldEmail = null;
    private TextView myTxtFieldDni = null;
    private TextView myTxtFieldBirthDate = null;
    private EditText myEditTxtOldPass = null;
    private EditText myEditTxtNewPass = null;
    private EditText myEditTxtRepeatNewPass = null;

    private Button myBtnGoBack = null;
    private Button myBtnChangePassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initializeObjects();

        /**
         * When the Log Out button is pressed it goes to the CheckBook activity.
         */
        myBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CheckBookActivity.class);
                startActivity(intent);
                ProfileActivity.super.finish();
            }
        });

        /**
         * When the Change Password button is pressed it checks if the requirements are fulfilled.
         */
        myBtnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTextFieldsNotEmpty()) {
                    if (myEditTxtNewPass.getText().toString().equals(myEditTxtRepeatNewPass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), R.string.text_password_changed, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.text_error_passwords_not_match, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.text_error_empty_fields, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Checks if all the text fields contain text.
     *
     * @return A variable indicating if all text fields contain text or not.
     */
    private boolean checkTextFieldsNotEmpty() {
        if (myEditTxtOldPass.getText().toString().isEmpty() || myEditTxtNewPass.getText().toString().isEmpty() || myEditTxtRepeatNewPass.getText().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * References the objects used in this class with the ones of the layout.
     */
    private void initializeObjects() {
        myTxtFieldName = (TextView) findViewById(R.id.txtFieldName_profile);
        myTxtFieldUser = (TextView) findViewById(R.id.txtFieldUser_profile);
        myTxtFieldEmail = (TextView) findViewById(R.id.txtFieldEmail_profile);
        myTxtFieldDni = (TextView) findViewById(R.id.txtFieldDni_profile);
        myTxtFieldBirthDate = (TextView) findViewById(R.id.txtFieldBirthDate_profile);

        myEditTxtOldPass = (EditText) findViewById(R.id.editTextOldPass_profile);
        myEditTxtNewPass = (EditText) findViewById(R.id.editTextNewPass_profile);
        myEditTxtRepeatNewPass = (EditText) findViewById(R.id.editTextRepeatNewPass_profile);

        myBtnGoBack = (Button) findViewById(R.id.btnGoBack_profile);
        myBtnChangePassword = (Button) findViewById(R.id.btnChangePassword_profile);
    }
}

