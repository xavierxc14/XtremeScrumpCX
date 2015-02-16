package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Sprint;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SesionControlador implements Serializable {

    private Proyecto proyecto;

    private Sprint sprint;

    private Date fechaActual;

    @PostConstruct
    public void init() {
        setProyecto(new Proyecto());
        setFechaActual(new Date());
    }

    public String getFecha() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formatter.format(fechaActual);
        return hoy;
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @return the fechaActual
     */
    public Date getFechaActual() {
        return fechaActual;
    }

    /**
     * @param fechaActual the fechaActual to set
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     * @return the sprint
     */
    public Sprint getSprint() {
        return sprint;
    }

    /**
     * @param sprint the sprint to set
     */
    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}
