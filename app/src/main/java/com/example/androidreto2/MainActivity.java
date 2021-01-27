package com.example.androidreto2;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidreto2.Interface.LibroAPI;
import com.example.androidreto2.Interface.StudentAPI;
import com.example.androidreto2.Interface.UsuarioAPI;
import com.example.androidreto2.Modelo.Student;
import com.example.androidreto2.Modelo.Usuario;
import com.example.androidreto2.Retrofit.StudentFacadeREST;
import com.example.androidreto2.Retrofit.UsuarioFacadeREST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.androidreto2.Modelo.TipoUsuario.ALUMNO;
import static com.example.androidreto2.Modelo.UserPrivilege.USER;
import static com.example.androidreto2.Modelo.UserStatus.ENABLED;

public class MainActivity extends AppCompatActivity {

    private TextView tt;
    private StudentAPI s;
    private UsuarioAPI u;
    private LibroAPI l;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = findViewById(R.id.txtView);
        listView = findViewById(R.id.listado);


        //login();
        //modificar();
        //listarLibroQuery();
        //buscarIdLibro();
        //buscarId();
        createStudent();
        //createBook();
        //listarLibros();
        //crearUsuarioAlumno();

    }

    private void login() {
       u = UsuarioFacadeREST.getClient();
       Call<Usuario> call = u.buscarLoginYContrasenia("nereaaa", "nereaaa");
       call.enqueue(new Callback<Usuario>() {
           @Override
           public void onResponse(Call<Usuario> call, Response<Usuario> response) {
               if (response.isSuccessful()){
                   Usuario user = response.body();

                   tt.setText("entro");
               }
           }

           @Override
           public void onFailure(Call<Usuario> call, Throwable t) {

           }
       });
    }


    private void createStudent() {
        Student student = new Student();
        student.setEmail("correo@gmail.com");
        student.setFullName("jonatha");
        student.setLastAccess("2020-12-10T08:47:03+01:00");
        student.setLastPasswordChange("2020-12-10T08:47:03+01:00");
        student.setLogin("jvc");
        student.setPassword("1234");
        student.setPrivilege(USER);
        student.setStatus(ENABLED);
        student.setTipoUsuario(ALUMNO);
        student.setDni("xxxxxxx");
        student.setFechaNacimiento("1999-03-24T00:00:00+01:00");
        student.setIdUsuario(99);

        s = StudentFacadeREST.getClient();
        Call<Student> call = s.create(student);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()){
                    Student student1 = response.body();
                    tt.setText("ya");
                    Toast.makeText(getApplicationContext(), student1.getFullName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                    tt.setText(t.getMessage().toString());
            }
        });
    }

    /*
    private void modificar() {

       l = LibroFacadeREST.getClient();
       Call<Libro> call = l.find("1");
       call.enqueue(new Callback<Libro>() {
           @Override
           public void onResponse(Call<Libro> call, Response<Libro> response) {
               if (response.isSuccessful()){
                   Libro libro = response.body();
                   tt.setText(libro.getAutor());
               }else{
                   tt.setText("sssssssss");
           }

           @Override
           public void onFailure(Call<Libro> call, Throwable t) {
               tt.setText(t.getMessage());
           }
       });

    }

    @Override
    public void onResponse(Call<Student> call, Response<Student> response) {
        if (response.isSuccessful()){
            Student student = (Student) response.body();
            tt.setText("CREO");
        }else{
            tt.setText(response.toString());
        }
    }

    @Override
    public void onFailure(Call<Student> call, Throwable t) {
        tt.setText(t.getMessage().toString());
    }*/
}
