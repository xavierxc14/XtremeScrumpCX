package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.servicios.ProyectoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class ProyectoControlador extends ControladorBase {

    private static Logger logger = Logger.getLogger(ProyectoControlador.class);

    public static final String LISTA = "/paginas/proyecto/lista_proyecto.jsf";

    private final ProyectoServicio proyectoServicio = new ProyectoServicio();

    private Proyecto proyecto;

    private List<Proyecto> proyectos;

    @PostConstruct
    @Override
    public void init() {
        buscar();
        setProyectos(new ArrayList<Proyecto>());
    }

    @Override
    public String buscar() {
        try {
            setProyectos(proyectoServicio.buscarTodos());
        } catch (Exception e) {
        }
        return LISTA;
    }

    @Override
    public String nuevo() {
        setProyecto(new Proyecto());
        ejecutarJSPrimefaces("PF('dialogoProyecto').show()");
        return null;
    }

    @Override
    public String editar() {
        ejecutarJSPrimefaces("PF('dialogoProyecto').show()");
        return null;
    }

    @Override
    public String guardar() {
        proyectoServicio.guardar(proyecto);
        return nuevo();
    }

    @Override
    public String borrar() {
        proyectoServicio.eliminar(proyecto);
        return buscar();
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
     * @return the proyectos
     */
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
