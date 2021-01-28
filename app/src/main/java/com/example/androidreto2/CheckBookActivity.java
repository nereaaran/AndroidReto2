package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class CheckBookActivity extends AppCompatActivity {

    private Button myBtnMyProfile = null;
    private Button myBtnLogOut = null;
    private ListView myListViewBooks = null;

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book);

        retrofit();

        initializeObjects();

        /**
         * When the My Profile button is pressed it goes to the Profile activity.
         */
        myBtnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CheckBookActivity.super.finish();
            }
        });

        /**
         * When the Log Out button is pressed it goes to the Login activity.
         */
        myBtnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                CheckBookActivity.super.finish();
            }
        });
    }

    /**
     * References the objects used in this class with the ones of the layout.
     */
    private void initializeObjects() {
        myBtnMyProfile = (Button) findViewById(R.id.btnMyProfile_checkBook);
        myBtnLogOut = (Button) findViewById(R.id.btnLogOut_chekBook);
        myListViewBooks = (ListView) findViewById(R.id.listViewBooks_checkbook);
    }

    private void retrofit() {
        /*
        User user = (User) getIntent().getSerializableExtra("User");
        usuarioAPI = UsuarioFacadeREST.getClient();
        Call<User> call = usuarioAPI.find(user.getIdUsuario().toString());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    User user = response.body();
                    intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent.putExtra("User", user);
                    startActivity(intent);
                    CheckBookActivity.super.finish();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
       */
    }
}

