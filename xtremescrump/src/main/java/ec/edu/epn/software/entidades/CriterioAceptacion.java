package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;

@Entity
@Index
public class CriterioAceptacion implements Serializable {

    @Id
    private Long id;

    private String descripcion;

    private Boolean cumple;

    private Ref<Tarea> tarea;

    /**
     * Constructor vacio.
     */
    public CriterioAceptacion() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param descripcion
     * @param cumple
     * @param tarea
     */
    public CriterioAceptacion(String descripcion, Boolean cumple, Tarea tarea) {
        this.descripcion = descripcion;
        this.cumple = cumple;
        this.tarea = Ref.create(tarea);
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

    /**
     * @return the cumple
     */
    public Boolean getCumple() {
        return cumple;
    }

    /**
     * @param cumple the cumple to set
     */
    public void setCumple(Boolean cumple) {
        this.cumple = cumple;
    }

    /**
     * @return the tarea
     */
    public Tarea getTarea() {
        return tarea.get();
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(Tarea tarea) {
        this.tarea = Ref.create(tarea);
    }
}
