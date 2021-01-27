package com.example.androidreto2.Modelo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Root(name="libro")
public class Libro implements Serializable {

        private static final long serialVersionUID = 1L;
        /**
         * Id para el libro.
         */
        @Element(name ="id")
        private Integer id;
        /**
         * Titulo del libro.
         */
        @Element(name ="titulo")
        private String titulo;
        /**
         * Autora del libro.
         */
        @Element(name ="autor")
        private String autor;
        /**
         * Editorial del libro.
         */
        @Element(name ="editorial")
        private String editorial;
        /**
         * ISBN del libro.
         */
        @Element(name ="isbn")
        private Long isbn;
        /**
         * Genero literario del libro.
         */
        @Element(name ="genero")
        private String genero;
        /**
         * Cantidad total que hay del libro.
         */
        @Element(name ="cantidadTotal")
        private Integer cantidadTotal;
        /**
         * Cantidad disponible que hay del libro.
         */
        @Element(name ="cantidadDisponible")
        private Integer cantidadDisponible;
        /**
         * El libro se puede descargar.
         */
        @Element(name ="descargable")
        private boolean descargable;
        /**
         * Enlace de descarga del libro.
         */
        @Element(name ="linkDescarga")
        private String linkDescarga;

        @ElementList(name = "bibliotecario")
        private List<Usuario> usuarios = new ArrayList<>();

        /**
         * Obtiene el id del libro.
         *
         * @return El valor del id del Libro.
         */
        public Integer getId() {
            return id;
        }

        /**
         * Establece el id para el Libro.
         *
         * @param id El valor del id del libro.
         */
        public void setId(Integer id) {
            this.id= id;
        }

        /**
         * Obtiene el titulo del libro.
         *
         * @return El titulo del libro.
         */
        public String getTitulo() {
            return titulo;
        }

        /**
         * Establece el titulo del libro.
         *
         * @param titulo El titulo del libro.
         */
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        /**
         * Obtiene el autor del libro.
         *
         * @return El autor del libro.
         */
        public String getAutor() {
            return autor;
        }

        /**
         * Establece el autor del libro.
         *
         * @param autor El autor del libro.
         */
        public void setAutor(String autor) {
            this.autor = autor;
        }

        /**
         * Obtiene la editorial del libro.
         *
         * @return La editorial del libro.
         */
        public String getEditorial() {
            return editorial;
        }

        /**
         * Establece la editoriasl del libro.
         *
         * @param editorial La editorial del libro.
         */
        public void setEditorial(String editorial) {
            this.editorial = editorial;
        }

        /**
         * Obtiene el isbn del libro.
         *
         * @return El isbn del libro.
         */
        public Long getIsbn() {
            return isbn;
        }

        /**
         * Establece el isbn del libro.
         *
         * @param isbn El isbn del libro.
         */
        public void setIsbn(Long isbn) {
            this.isbn = isbn;
        }

        /**
         * Obtiene el genero literario del libro.
         *
         * @return El genero literario del libro.
         */
        public String getGenero() {
            return genero;
        }

        /**
         * Establece el genero literario del libro.
         *
         * @param genero El genero literario del libro.
         */
        public void setGenero(String genero) {
            this.genero = genero;
        }

        /**
         * Obtiene la cantidad total del libro.
         *
         * @return La cantidad total del libro.
         */
        public Integer getCantidadTotal() {
            return cantidadTotal;
        }

        /**
         * Establece la cantidad total del libro.
         *
         * @param cantidadTotal La cantidad total del libro.
         */
        public void setCantidadTotal(Integer cantidadTotal) {
            this.cantidadTotal = cantidadTotal;
        }

        /**
         * Obtiene la cantidad disponible del libro.
         *
         * @return La cantidad disponible del libro.
         */
        public Integer getCantidadDisponible() {
            return cantidadDisponible;
        }

        /**
         * Establece la cantidad disponible del libro.
         *
         * @param cantidadDisponible La cantidad disponible del libro.
         */
        public void setCantidadDisponible(Integer cantidadDisponible) {
            this.cantidadDisponible = cantidadDisponible;
        }

        /**
         * Obtiene si el libro es descargable.
         *
         * @return True si el libro se puede descargar.
         */
        public boolean isDescargable() {
            return descargable;
        }

        /**
         * Establece si el libro es descargable.
         *
         * @param descargable Si el libro es descargable.
         */
        public void setDescargable(boolean descargable) {
            this.descargable = descargable;
        }

        /**
         * Obtiene enlace de descarga del libro.
         *
         * @return Enlace de descarga del libro.
         */
        public String getLinkDescarga() {
            return linkDescarga;
        }

        /**
         * Establece enlace de descarga del libro.
         *
         * @param linkDescarga Enlace de descarga del libro.
         */
        public void setLinkDescarga(String linkDescarga) {
            this.linkDescarga = linkDescarga;
        }

        /**
         * Implementacion del metodo hashCode para la entidad.
         *
         * @return Valor integer del hashcode del objeto.
         */
        @Override
        public int hashCode() {
            int hash = 0;
            hash += (id != null ? id.hashCode() : 0);
            return hash;
        }

        /**
         * Metodo que comprueba el idLibro de dos entidades de libro por igualdad.
         *
         * @param obj El objeto a comparar.
         * @return True si los objetos son iguales.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Libro other = (Libro) obj;
            if (this.descargable != other.descargable) {
                return false;
            }
            if (!Objects.equals(this.titulo, other.titulo)) {
                return false;
            }
            if (!Objects.equals(this.autor, other.autor)) {
                return false;
            }
            if (!Objects.equals(this.editorial, other.editorial)) {
                return false;
            }
            if (!Objects.equals(this.genero, other.genero)) {
                return false;
            }
            if (!Objects.equals(this.linkDescarga, other.linkDescarga)) {
                return false;
            }
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            if (!Objects.equals(this.isbn, other.isbn)) {
                return false;
            }
            if (!Objects.equals(this.cantidadTotal, other.cantidadTotal)) {
                return false;
            }
            if (!Objects.equals(this.cantidadDisponible, other.cantidadDisponible)) {
                return false;
            }
            return true;
        }

        public class Usuario{


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
}
