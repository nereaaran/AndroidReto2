package com.example.androidreto2.Interface;

import com.example.androidreto2.Modelo.Student;

import org.simpleframework.xml.Root;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@Root(name = "alumno")
public interface StudentAPI{

    @POST("alumno")
    public Call<Student> create(@Body Student student);

    //@POST("alumno")
    /*public Call<Student> create(@Field("login") String login,
                                @Field("fullName") String fullName,
                                @Field("status")UserStatus statusl,
                                @Field("privilege")UserPrivilege privilege,
                                @Field("tipoUsuario") TipoUsuario tipoUsuario,
                                @Field("password") String password,
                                @Field("lastAccess")String lastAccess,
                                @Field("lastPasswordChange") String lastPasswordChange);

    */
    @PUT
    public Call<Student> edit(Student student);

    @DELETE("alumno/{id}")
    public Call<Student> remove(@Path("id") String id);

}