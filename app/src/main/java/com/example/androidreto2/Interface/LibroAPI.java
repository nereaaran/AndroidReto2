
package com.example.androidreto2.Interface;

import com.example.androidreto2.Modelo.Libro;
import com.example.androidreto2.Modelo.ListarLibros;
import com.example.androidreto2.Modelo.MultiLibros;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LibroAPI {

    @GET("libro/{id}")
    Call<MultiLibros> findx(@Path("id") String id);

    @GET("libro/{id}")
    Call<Libro> find(@Path("id") String id);

    @POST("libro")
    public Call<Libro> create(@Body Libro libro);

    @PUT("libro")
    public Call<ListarLibros> edit(@Body Libro libro);

    //@GET("libro")
    //public Call<MultiLibros> buscarTodosLosLibros();

    @GET("libro")
    public Call<ListarLibros> buscarTodosLosLibros(@Query("buscarTodosLosLibros") String buscarTodosLosLibros);
}
