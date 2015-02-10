package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;

@Entity
@Index
public class Tarea extends TreeNodeHistoria implements Serializable {

    @Id
    private Long id;

    private String descripcion;

    private Integer prioridad;

    private Integer esfuerzo;

    private Ref<HistoriaUsuario> historia;

    /**
     * Constructor vacio.
     */
    public Tarea() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param descripcion
     * @param prioridad
     * @param esfuerzo
     * @param sprint
     */
    public Tarea(String descripcion, Integer prioridad, Integer esfuerzo, HistoriaUsuario historia) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.esfuerzo = esfuerzo;
        this.historia = Ref.create(historia);
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
     * @return the prioridad
     */
    public Integer getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the esfuerzo
     */
    public Integer getEsfuerzo() {
        return esfuerzo;
    }

    /**
     * @param esfuerzo the esfuerzo to set
     */
    public void setEsfuerzo(Integer esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the historia de usuario
     */
    public HistoriaUsuario getHistoria() {
        return historia.get();
    }

    /**
     * @param historia the backlog to set
     */
    public void setBacklog(HistoriaUsuario historia) {
        this.historia = Ref.create(historia);
    }

}
