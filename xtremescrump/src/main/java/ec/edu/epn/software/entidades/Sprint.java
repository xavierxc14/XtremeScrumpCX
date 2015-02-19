package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
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

    private Ref<Proyecto> proyecto;

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
     * @param proyecto
     */
    public Sprint(String nombre, Date fechaInicio, Date fechaFin, Proyecto proyecto) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.proyecto = Ref.create(proyecto);
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
