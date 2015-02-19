package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Sprint;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
import ec.edu.epn.software.servicios.SprintServicio;
import ec.edu.epn.software.utils.MensajesInformacion;
import ec.edu.epn.software.utils.MensajesPagina;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class SprintControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(SprintControlador.class);

    public static final String LISTA = "/paginas/sprint/sprints.jsf";

    public static final String PLANEACION = "/paginas/sprint/planificar_sprint.jsf";

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private final SprintServicio sprintServicio = new SprintServicio();

    private final HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();

    private Sprint sprint;

    private List<Sprint> sprints;

    private List<HistoriaUsuario> historiaUsuariosDisponibles;

    private List<HistoriaUsuario> historiaUsuariosAsignadas;

    @PostConstruct
    @Override
    public void init() {
        setSprints(new ArrayList<Sprint>());
        setHistoriaUsuariosDisponibles(new ArrayList<HistoriaUsuario>());
        setHistoriaUsuariosAsignadas(new ArrayList<HistoriaUsuario>());
        buscar();
        buscarHistoriasDisponibles();
    }

    @Override
    public String buscar() {
        try {
            setSprints(sprintServicio.buscarPorProyecto(sesionControlador.getSprint().getId()));
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
        sprintServicio.guardar(sprint);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.ROL_CREADO);
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
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.ROL_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimSprint').hide()");
        return buscar();
    }

    public void redirectPlaneacion(SelectEvent evt) {
        buscarHistoriasAsignadas();
        redirect(evt, PLANEACION);
    }

    public void buscarHistoriasDisponibles() {
        setHistoriaUsuariosDisponibles(historiaUsuarioServicio.buscarSinSprint());
    }

    public void buscarHistoriasAsignadas() {
        setHistoriaUsuariosAsignadas(historiaUsuarioServicio.buscarPorSprint(sesionControlador.getSprint().getId()));
    }

    public void onDrop(DragDropEvent ddEvent) {
        HistoriaUsuario hu = ((HistoriaUsuario) ddEvent.getData());
        historiaUsuariosAsignadas.add(hu);
        hu.setSprint(sesionControlador.getSprint());
        historiaUsuarioServicio.guardar(hu);
        historiaUsuariosDisponibles.remove(hu);
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

    /**
     * @return the historiaUsuariosDisponibles
     */
    public List<HistoriaUsuario> getHistoriaUsuariosDisponibles() {
        return historiaUsuariosDisponibles;
    }

    /**
     * @param historiaUsuariosDisponibles the historiaUsuariosDisponibles to set
     */
    public void setHistoriaUsuariosDisponibles(List<HistoriaUsuario> historiaUsuariosDisponibles) {
        this.historiaUsuariosDisponibles = historiaUsuariosDisponibles;
    }

    /**
     * @return the historiaUsuariosAsignadas
     */
    public List<HistoriaUsuario> getHistoriaUsuariosAsignadas() {
        return historiaUsuariosAsignadas;
    }

    /**
     * @param historiaUsuariosAsignadas the historiaUsuariosAsignadas to set
     */
    public void setHistoriaUsuariosAsignadas(List<HistoriaUsuario> historiaUsuariosAsignadas) {
        this.historiaUsuariosAsignadas = historiaUsuariosAsignadas;
    }

}
