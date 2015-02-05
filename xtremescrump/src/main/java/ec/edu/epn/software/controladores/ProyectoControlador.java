package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.servicios.ProyectoServicio;
import ec.edu.epn.software.utils.MensajesInformacion;
import ec.edu.epn.software.utils.MensajesPagina;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class ProyectoControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(ProyectoControlador.class);

    public static final String LISTA = "/paginas/proyecto/proyectos.jsf";

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private final ProyectoServicio proyectoServicio = new ProyectoServicio();

    private Proyecto proyecto;

    private List<Proyecto> proyectos;

    @PostConstruct
    @Override
    public void init() {
        buscar();
    }

    @Override
    public String buscar() {
        try {
            setProyectos(proyectoServicio.buscarTodos());
        } catch (Exception ex) {
            LOG.error("Error al realizar la busqueda de proyectos", ex);
        }
        return LISTA;
    }

    @Override
    public String nuevo() {
        setProyecto(new Proyecto());
        ejecutarJSPrimefaces("PF('dlgProyecto').show()");
        return null;
    }

    @Override
    public String editar() {
        ejecutarJSPrimefaces("PF('dlgProyecto').show()");
        return null;
    }

    @Override
    public String guardar() {
        proyectoServicio.guardar(proyecto);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.PROYECTO_CREADO);
        cerrarDialogo();
        return buscar();
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgProyecto').hide()");
        return null;
    }

    @Override
    public String borrar() {
        proyectoServicio.eliminar(proyecto);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.PROYECTO_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimProyecto').hide()");
        return buscar();
    }

    public String agregarTeam() {
        return null;
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

    /**
     * @return the sesionControlador
     */
    public SesionControlador getSesionControlador() {
        return sesionControlador;
    }

    /**
     * @param sesionControlador the sesionControlador to set
     */
    public void setSesionControlador(SesionControlador sesionControlador) {
        this.sesionControlador = sesionControlador;
    }
}
