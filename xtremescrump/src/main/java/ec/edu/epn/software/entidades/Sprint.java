package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Index
public class Sprint implements Serializable {

    @Id
    private Long id;

    private String nombre;

    private Date fechaInicio;

    private Date fechaFin;

    private List<HistoriaUsuario> historiasUsuario;

    /**
     * Constructor vacio.
     */
    public Sprint() {
        this.historiasUsuario = new ArrayList<>();
    }

    /**
     * Constructor con argumentos.
     *
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     */
    public Sprint(String nombre, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.historiasUsuario = new ArrayList<>();
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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the historiasUsuario
     */
    public List<HistoriaUsuario> getHistoriasUsuario() {
        return historiasUsuario;
    }

    /**
     * @param historiasUsuario the historiasUsuario to set
     */
    public void setHistoriasUsuario(List<HistoriaUsuario> historiasUsuario) {
        this.historiasUsuario = historiasUsuario;
    }
}
