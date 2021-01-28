package com.example.androidreto2.Interface;

import com.example.androidreto2.Modelo.Usuarioes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioesAPI {

    @GET("usuario")
    public Call<Usuarioes> consultarTodosAlumnos();
}
