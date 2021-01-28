package com.example.androidreto2.Modelo;

import org.simpleframework.xml.Element;

public enum TipoUsuario {
    /**
     * El usuario es un bibliotecario.
     */
    @Element(name ="BIBLIOTECARIO")
    BIBLIOTECARIO,
    /**
     * El usuario es un profesor
     */
    @Element(name ="PROFESOR")
    PROFESOR,
    /**
     * El usuario es un alumno.
     */
    @Element(name ="ALUMNO")
    ALUMNO;
}
