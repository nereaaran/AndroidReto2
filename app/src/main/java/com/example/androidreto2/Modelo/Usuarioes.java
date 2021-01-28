package com.example.androidreto2.Modelo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Collection;

@Root(name = "usuarioes")
public class Usuarioes {
    @ElementList(name = "usuario", inline = true)
    private Collection<User> user;

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }
}
