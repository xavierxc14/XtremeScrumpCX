package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Proyecto;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Sesion {

    private Proyecto proyecto;

    @PostConstruct
    public void init() {
        setProyecto(new Proyecto());
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
}
