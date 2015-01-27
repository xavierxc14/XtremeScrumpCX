package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Index
public class Rol implements Serializable {

    @Id
    private Long id;

    private String nombre;

    private String descripcion;

    private List<Ref<Usuario>> usuarios = new ArrayList<>();

    /**
     * Constructor vacio.
     */
    public Rol() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param nombre
     * @param descripcion
     */
    public Rol(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
