package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
import java.io.Serializable;
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
public class PlanificacionSprintControlador implements Serializable {

    private static Logger LOG = Logger.getLogger(PlanificacionSprintControlador.class);

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private final HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();

    private List<HistoriaUsuario> historiaUsuariosDisponibles;

    private List<HistoriaUsuario> historiaUsuariosAsignadas;

    @PostConstruct
    public void init() {
        setHistoriaUsuariosDisponibles(new ArrayList<HistoriaUsuario>());
        setHistoriaUsuariosAsignadas(new ArrayList<HistoriaUsuario>());
        buscar();
    }

    public void buscar() {
        setHistoriaUsuariosDisponibles(historiaUsuarioServicio.buscarPorProyectoSinSprint(
                sesionControlador.getProyecto().getId()));
        setHistoriaUsuariosAsignadas(historiaUsuarioServicio.buscarPorProyectoConSprint(
                sesionControlador.getProyecto().getId(), sesionControlador.getSprint().getId()));
    }

    public void onDropAsignar(DragDropEvent ddEvent) {
        HistoriaUsuario hu = ((HistoriaUsuario) ddEvent.getData());
        hu.setSprint(sesionControlador.getSprint());
        historiaUsuarioServicio.guardar(hu);
        historiaUsuariosAsignadas.add(hu);
        historiaUsuariosDisponibles.remove(hu);
    }

    public void onDropQuitar(DragDropEvent ddEvent) {
        HistoriaUsuario hu = ((HistoriaUsuario) ddEvent.getData());
        hu.setSprint(null);
        historiaUsuarioServicio.guardar(hu);
        historiaUsuariosDisponibles.add(hu);
        historiaUsuariosAsignadas.remove(hu);
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
