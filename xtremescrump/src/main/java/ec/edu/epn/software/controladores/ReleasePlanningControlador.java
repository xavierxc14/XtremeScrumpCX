package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Sprint;
import ec.edu.epn.software.manejo.SprintHU;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
import ec.edu.epn.software.servicios.SprintServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.event.DragDropEvent;

@ManagedBean
@ViewScoped
public class ReleasePlanningControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(ReleasePlanningControlador.class);

    public static final String LISTA = "/paginas/release_planning/release_planning.jsf";

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private final SprintServicio sprintServicio = new SprintServicio();

    private final HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();

    private Sprint sprint;

    private List<Sprint> sprints;

    private List<HistoriaUsuario> historiaUsuarios;

    private List<SprintHU> sprintHUs;

    @PostConstruct
    @Override
    public void init() {
        setSprints(new ArrayList<Sprint>());
        setSprintHUs(new ArrayList<SprintHU>());
        buscar();
        buscarHistoriasDisponibles();
    }

    @Override
    public String buscar() {
        try {
            setSprints(sprintServicio.buscarPorProyecto(sesionControlador.getProyecto().getId()));
            for (Sprint s : getSprints()) {
                s.setHistoriasUsuario(historiaUsuarioServicio.buscarPorProyectoConSprint(
                        sesionControlador.getProyecto().getId(), s.getId()));
                getSprintHUs().add(new SprintHU(s, s.getHistoriasUsuario()));
            }
        } catch (Exception ex) {
            LOG.error("Error al realizar la buscqueda de sprints", ex);
        }
        return null;
    }

    @Override
    public String nuevo() {
        return null;
    }

    @Override
    public String editar() {
        return null;
    }

    @Override
    public String guardar() {
        return null;
    }

    @Override
    public String cerrarDialogo() {
        return null;
    }

    @Override
    public String borrar() {
        return null;
    }

    public void buscarHistoriasDisponibles() {
        if (sesionControlador.getProyecto() == null || sesionControlador.getProyecto().getId() == null) {
            setHistoriaUsuarios(new ArrayList<HistoriaUsuario>());
        } else {
            setHistoriaUsuarios(historiaUsuarioServicio.buscarPorProyectoSinSprint(
                    sesionControlador.getProyecto().getId()));
        }
    }

    public void onDrop(DragDropEvent ddEvent) {
        HistoriaUsuario hu = ((HistoriaUsuario) ddEvent.getData());
        System.out.println(ddEvent.getDropId());
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
     * @return the historiaUsuarios
     */
    public List<HistoriaUsuario> getHistoriaUsuarios() {
        return historiaUsuarios;
    }

    /**
     * @param historiaUsuarios the historiaUsuarios to set
     */
    public void setHistoriaUsuarios(List<HistoriaUsuario> historiaUsuarios) {
        this.historiaUsuarios = historiaUsuarios;
    }

    /**
     * @return the sprintHUs
     */
    public List<SprintHU> getSprintHUs() {
        return sprintHUs;
    }

    /**
     * @param sprintHUs the sprintHUs to set
     */
    public void setSprintHUs(List<SprintHU> sprintHUs) {
        this.sprintHUs = sprintHUs;
    }

}
