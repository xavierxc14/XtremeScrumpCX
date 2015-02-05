package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;

@Entity
@Index
public class UsuarioProyecto implements Serializable {

    @Id
    private Long id;

    private Ref<Usuario> usuario;

    private Ref<Proyecto> proyecto;

    /**
     * Constructor vacio.
     */
    public UsuarioProyecto() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param usuario
     * @param proyecto
     */
    public UsuarioProyecto(Usuario usuario, Proyecto proyecto) {
        this.usuario = Ref.create(usuario);
        this.proyecto = Ref.create(proyecto);
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
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario.get();
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = Ref.create(usuario);
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto.get();
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = Ref.create(proyecto);
    }

}
