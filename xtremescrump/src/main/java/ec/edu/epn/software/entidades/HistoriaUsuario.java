package ec.edu.epn.software.entidades;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import java.io.Serializable;

@Entity
public class HistoriaUsuario implements Serializable {

    @Id
    private Long id;

    private String codigo;

    private String titulo;

    private Integer prioridad;

    private Integer esfuerzo;

    /**
     * Constructor vacio.
     */
    public HistoriaUsuario() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param codigo
     * @param titulo
     * @param prioridad
     * @param esfuerzo
     */
    public HistoriaUsuario(String codigo, String titulo, Integer prioridad, Integer esfuerzo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.esfuerzo = esfuerzo;
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

}
