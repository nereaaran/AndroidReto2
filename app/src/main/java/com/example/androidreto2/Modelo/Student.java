package com.example.androidreto2.Modelo;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "alumno")
public class Student extends Usuario implements Serializable {

    private static final long seriaLVersionUID = 1L;
    /**
     * DNI del alumno.
     */
    @Element(name ="dni")
    private String dni;
    /**
     * Fecha de nacimiento del alumno.
     */
    @Element(name ="fechaNacimiento")
    private String fechaNacimiento;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
