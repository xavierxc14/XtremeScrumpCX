package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;

@Entity
@Index
public class Usuario implements Serializable {

    @Id
    private Long id;

    private String nombre;

    private String username;

    private String password;

    private Ref<Rol> rol;

    /**
     * Constructor vacio.
     */
    public Usuario() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param nombre
     * @param username
     * @param password
     * @param rol
     */
    public Usuario(String nombre, String username, String password, Rol rol) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.rol = Ref.create(rol);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol.get();
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = Ref.create(rol);
    }
}