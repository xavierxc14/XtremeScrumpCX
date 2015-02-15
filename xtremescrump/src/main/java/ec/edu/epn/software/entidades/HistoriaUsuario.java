package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;

@Entity
@Index
public class HistoriaUsuario implements Serializable {

    @Id
    private Long id;

    private String codigo;

    private String descripcion;

    private String titulo;

    private Integer prioridad;

    private Integer esfuerzo;

    private Ref<Proyecto> proyecto;

    private Ref<Sprint> sprint;

    /**
     * Constructor vacio.
     */
    public HistoriaUsuario() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param prioridad
     * @param esfuerzo
     * @param sprint
     */
    public HistoriaUsuario(String codigo, String descripcion, String titulo, Integer prioridad, Integer esfuerzo, Sprint sprint) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.esfuerzo = esfuerzo;
        this.sprint = Ref.create(sprint);
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
     * @return the sprint
     */
    public Sprint getSprint() {
        return sprint.get();
    }

    /**
     * @param sprint the sprint to set
     */
    public void setSprint(Sprint sprint) {
        this.sprint = Ref.create(sprint);
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
