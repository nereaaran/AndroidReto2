package com.example.androidreto2.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Collection;

@Root(name = "bibliotecario")
public class Bibliotecario extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Element(name ="libros")
    private Collection<Libro> libros;

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }
}
