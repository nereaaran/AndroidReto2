package com.example.androidreto2.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name="usuario")
public class Usuario implements Serializable {

    private static final long seriaLVersionUID = 1L;

    @Element(name ="idUsuario")
    private Integer idUsuario;
    @Element(name ="login")
    private String login;
    @Element(name ="email")
    private String email;
    @Element(name ="fullName")
    private String fullName;
    @Element(name ="status")
    private UserStatus status;
    @Element(name ="privilege")
    private UserPrivilege privilege;
    @Element(name ="tipoUsuario")
    private TipoUsuario tipoUsuario;
    @Element(name ="password")
    private String password;
    @Element(name ="lastAccess")
    private String lastAccess;
    @Element(name ="lastPasswordChange")
    private String lastPasswordChange;


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserPrivilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(UserPrivilege privilege) {
        this.privilege = privilege;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(String lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }
}
