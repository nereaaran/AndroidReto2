package com.example.androidreto2.Interface;

import com.example.androidreto2.Modelo.Usuario;

import org.simpleframework.xml.Root;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Root(name = "usuario")
public interface UsuarioAPI {

    @GET("usuario/{id}")
    Call<Usuario> find(@Path("id") String id);

    @POST
    Call<Usuario> create(@Body Usuario usuario);

    @GET("usuario/loginYPassword/{login}/{password}")
    public Call<Usuario> buscarLoginYContrasenia(@Path("login") String login, @Path("password") String password);

    @GET("login/{login}")
    public Call<Usuario> buscarUsuarioPorLogin(@Path("login") String login);



    }

