package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Tarea;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
import ec.edu.epn.software.servicios.TareaServicio;
import ec.edu.epn.software.utils.MensajesError;
import ec.edu.epn.software.utils.MensajesInformacion;
import ec.edu.epn.software.utils.MensajesPagina;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class HistoriaUsuarioControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(HistoriaUsuarioControlador.class);

    private static final String LISTA = "/paginas/historia_usuario/product_backlog_table.jsf";

    private final HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();

    private final TareaServicio tareaServicio = new TareaServicio();

    private HistoriaUsuario historiaUsuario;

    private List<HistoriaUsuario> historiasUsuarios;

    private Tarea tarea;

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private TreeNode root;

    @PostConstruct
    @Override
    public void init() {
        setHistoriaUsuarios(new ArrayList<HistoriaUsuario>());
        tarea = new Tarea();
        buscar();
    }

    @Override
    public String buscar() {
        try {
            getHistoriaUsuarios().clear();
            setHistoriaUsuarios(historiaUsuarioServicio.buscarPorProyecto(sesionControlador.getProyecto().getId()));
            for (HistoriaUsuario hu : historiasUsuarios) {
                hu.setTareas(tareaServicio.buscarPorHU(hu.getId()));
            }
            //llenarArbol();
        } catch (Exception ex) {
            LOG.error("Error al realizar la busqueda de proyectos", ex);
        }
        return getLISTA();
    }

    @Override
    public String nuevo() {
        setHistoriaUsuario(new HistoriaUsuario());
        historiaUsuario.setProyecto(sesionControlador.getProyecto());
        ejecutarJSPrimefaces("PF('dlgHistoriaUsuario').show()");
        return null;
    }

    @Override
    public String editar() {
        return null;
    }

    @Override
    public String guardar() {
        try {
            Boolean existePrioridad = existePrioridadHU();
            if (existePrioridad) {
                MensajesPagina.mostrarMensajeError("Ya existe una Historia de Usuario con esa Prioridad.");
            } else {
                if (historiaUsuario.getId() == null) {
                    historiaUsuarioServicio.guardar(historiaUsuario);
                    MensajesPagina
                            .mostrarMensajeInformacion(MensajesInformacion.HU_CREADO);
                } else {
                    historiaUsuarioServicio.guardar(historiaUsuario);
                    MensajesPagina
                            .mostrarMensajeInformacion(MensajesInformacion.HU_ACTUALIZADO);
                }
                cerrarDialogo();
            }
        } catch (Exception e) {
            MensajesPagina.mostrarMensajeError(MensajesError.ERROR_HU_CREADO);
        }
        return buscar();
    }

    private Boolean existePrioridadHU() {
        Boolean existePrioridad = Boolean.FALSE;
        for (HistoriaUsuario hu : historiasUsuarios) {
            if (hu.getPrioridad().equals(historiaUsuario.getPrioridad())) {
                existePrioridad = Boolean.TRUE;
            }
        }
        return existePrioridad;
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgHistoriaUsuario').hide()");
        ejecutarJSPrimefaces("PF('dlgTarea').hide()");
        return null;
    }

    @Override
    public String borrar() {
        historiaUsuarioServicio.eliminar(historiaUsuario);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.HU_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimHistoriaUsuario').hide()");
        return buscar();
    }

    public String nuevaTarea() {
        setTarea(new Tarea());
        ejecutarJSPrimefaces("PF('dlgTarea').show()");
        return null;
    }

    public String guardarTarea() {
        try {
            tarea.setHistoria(historiaUsuario);
            tareaServicio.guardar(tarea);
            MensajesPagina
                    .mostrarMensajeInformacion(MensajesInformacion.HU_CREADO);
            cerrarDialogo();
        } catch (Exception e) {
            MensajesPagina.mostrarMensajeError(MensajesError.ERROR_HU_CREADO);
        }
        return buscar();
    }
    public String borrarTarea() {
        tareaServicio.eliminar(tarea);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.HU_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimTarea').hide()");
        return buscar();
    }

    /**
     * @return the LISTA
     */
    public String getLISTA() {
        return LISTA;
    }

    public String llenarArbol() {
        root = new DefaultTreeNode("raiz", null);
        for (HistoriaUsuario hu : historiasUsuarios) {
            TreeNode nodoHistoria = new DefaultTreeNode("historia", hu, root);
            List<Tarea> tareas = historiaUsuarioServicio.buscarTareasPorHU(hu.getId());
            for (Tarea t : tareas) {
//                Tarea t = new Tarea();
//                t.setDescripcion("Tarea prueba " + j);
//                t.setEsfuerzo(2);
                TreeNode nodoTarea = new DefaultTreeNode("tarea", t, nodoHistoria);
            }
        }
        return null;
    }

    /**
     * @return the historiaUsuario
     */
    public HistoriaUsuario getHistoriaUsuario() {
        return historiaUsuario;
    }

    /**
     * @param historiaUsuario the historiaUsuario to set
     */
    public void setHistoriaUsuario(HistoriaUsuario historiaUsuario) {
        this.historiaUsuario = historiaUsuario;
    }

    /**
     * @return the historiasUsuarios
     */
    public List<HistoriaUsuario> getHistoriaUsuarios() {
        return historiasUsuarios;
    }

    /**
     * @param historiaUsuarios the historiasUsuarios to set
     */
    public void setHistoriaUsuarios(List<HistoriaUsuario> historiaUsuarios) {
        this.historiasUsuarios = historiaUsuarios;
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
     * @return the tarea
     */
    public Tarea getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
