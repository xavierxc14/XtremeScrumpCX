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
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class ProyectoControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(ProyectoControlador.class);

    public static final String LISTA = "/paginas/proyecto/proyectos.jsf";

    private final ProyectoServicio proyectoServicio = new ProyectoServicio();

    private Proyecto proyecto;

    private List<Proyecto> proyectos;

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

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
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.PROYECTO_CREADO);
        cerrarDialogo();
        return buscar();
    }

    public void cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dialogoProyecto').hide()");
    }

    public void redirectHistorias(SelectEvent evt) {
        redirect(evt, HistoriaUsuarioControlador.LISTA);
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
