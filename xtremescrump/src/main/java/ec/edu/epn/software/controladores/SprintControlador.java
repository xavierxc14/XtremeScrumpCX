package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Sprint;
import ec.edu.epn.software.servicios.SprintServicio;
import ec.edu.epn.software.utils.MensajesInformacion;
import ec.edu.epn.software.utils.MensajesPagina;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class SprintControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(SprintControlador.class);

    public static final String LISTA = "/paginas/sprint/sprints.jsf";

    public static final String PLANEACION = "/paginas/sprint/planificar_sprint.jsf";

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private final SprintServicio sprintServicio = new SprintServicio();

    private Sprint sprint;

    private List<Sprint> sprints;

    @PostConstruct
    @Override
    public void init() {
        setSprints(new ArrayList<Sprint>());
        buscar();
    }

    @Override
    public String buscar() {
        try {
            setSprints(sprintServicio.buscarPorProyecto(sesionControlador.getProyecto().getId()));
        } catch (Exception ex) {
            LOG.error("Error al realizar la buscqueda de sprints", ex);
        }
        return LISTA;
    }

    @Override
    public String nuevo() {
        setSprint(new Sprint());
        ejecutarJSPrimefaces("PF('dlgSprint').show()");
        return null;
    }

    @Override
    public String editar() {
        ejecutarJSPrimefaces("PF('dlgSprint').show()");
        return null;
    }

    @Override
    public String guardar() {
        sprint.setProyecto(sesionControlador.getProyecto());
        if (sprint.getId() == null) {
            sprintServicio.guardar(sprint);
            MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.ROL_CREADO);
        } else {
            sprintServicio.guardar(sprint);
            MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.ROL_ACTUALIZO);
        }
        cerrarDialogo();
        return buscar();
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgSprint').hide()");
        return null;
    }

    @Override
    public String borrar() {
        sprintServicio.eliminar(sprint);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.SPRINT_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimSprint').hide()");
        return buscar();
    }

    public void redirectPlaneacion(SelectEvent evt) {
        redirect(evt, PLANEACION);
    }

    /**
     * @return the LISTA
     */
    public String getLISTA() {
        return LISTA;
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

    /**
     * @return the sprints
     */
    public List<Sprint> getSprints() {
        return sprints;
    }

    /**
     * @param sprints the sprints to set
     */
    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
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
