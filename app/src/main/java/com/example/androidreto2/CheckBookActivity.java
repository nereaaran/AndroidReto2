package com.example.androidreto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidreto2.Interface.UsuarioAPI;
import com.example.androidreto2.Modelo.User;
import com.example.androidreto2.Retrofit.UsuarioFacadeREST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckBookActivity extends AppCompatActivity {

    Intent intent = null;
    Integer idUser;
    private UsuarioAPI usuarioAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book);

        User user = (User) getIntent().getSerializableExtra("User");
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

            }
        });



    }
}

