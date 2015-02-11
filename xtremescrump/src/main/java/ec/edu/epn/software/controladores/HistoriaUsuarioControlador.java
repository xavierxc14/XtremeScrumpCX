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

    public static final String LISTA = "/paginas/historia_usuario/product_backlog_tree.jsf";

    private final HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();
    private final TareaServicio tareaServicio = new TareaServicio();

    private HistoriaUsuario historiaUsuario;
    private List<HistoriaUsuario> historiasUsuarios;
    private HistoriaUsuario historiaUsuarioSeleccionada;

    private Tarea tarea;
    private List<Tarea> tareas;
    private Tarea tareaSeleccionada;

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private TreeNode root;

    @PostConstruct
    @Override
    public void init() {
        setHistoriaUsuarios(new ArrayList<HistoriaUsuario>());
        setTareas(new ArrayList<Tarea>());
        tarea = new Tarea();
        buscar();
    }

    @Override
    public String buscar() {
        try {
//            setHistoriaUsuarios(historiaUsuarioServicio.buscarTodos());
            getHistoriaUsuarios().clear();
            setHistoriaUsuarios(historiaUsuarioServicio.buscarPorProyecto(sesionControlador.getProyecto()));
            llenarArbol();
        } catch (Exception ex) {
            LOG.error("Error al realizar la busqueda de proyectos", ex);
        }
        return LISTA;
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
        ejecutarJSPrimefaces("PF('dlgHistoriaUsuario').show()");
        return null;
    }

    @Override
    public String guardar() {
        try {
            historiaUsuarioServicio.guardar(historiaUsuario);
            MensajesPagina
                    .mostrarMensajeInformacion(MensajesInformacion.HU_CREADO);
            cerrarDialogo();
        } catch (Exception e) {
            MensajesPagina.mostrarMensajeError(MensajesError.ERROR_HU_CREADO);
        }
        return buscar();
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgHistoriaUsuario').hide()");
        historiaUsuario = new HistoriaUsuario();
        return null;
    }

    @Override
    public String borrar() {
        historiaUsuarioServicio.eliminar(historiaUsuario);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.HU_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimHistoriaUsuario').hide()");
        return buscar();
    }

    public TreeNode llenarArbol() {
        root = new DefaultTreeNode(new HistoriaUsuario(), null);
        for (HistoriaUsuario hu : historiasUsuarios) {
            TreeNode nodoHistoria = new DefaultTreeNode("historia", hu, root);
            setTareas(historiaUsuarioServicio.buscarTareasPorHU(hu));
            for (Tarea t : tareas) {
//                Tarea t = new Tarea();
//                t.setDescripcion("Tarea prueba " + j);
//                t.setEsfuerzo(2);
                TreeNode nodoTarea = new DefaultTreeNode("tarea", t, nodoHistoria);
            }
        }
        return root;
    }

    public void nuevaTarea() {
        setTarea(new Tarea());
        ejecutarJSPrimefaces("PF('dlgTarea').show()");
    }

    public String guardarTarea() {
        try {
            tareaServicio.guardar(tarea);
            MensajesPagina
                    .mostrarMensajeInformacion(MensajesInformacion.HU_CREADO);
            cerrarDialogo();
        } catch (Exception e) {
            MensajesPagina.mostrarMensajeError(MensajesError.ERROR_HU_CREADO);
        }
        return buscar();
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
     * @return the tareas
     */
    public List<Tarea> getTareas() {
        return tareas;
    }

    /**
     * @param tareas the tareas to set
     */
    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    /**
     * @return the historiaUsuarioSeleccionada
     */
    public HistoriaUsuario getHistoriaUsuarioSeleccionada() {
        return historiaUsuarioSeleccionada;
    }

    /**
     * @param historiaUsuarioSeleccionada the historiaUsuarioSeleccionada to set
     */
    public void setHistoriaUsuarioSeleccionada(HistoriaUsuario historiaUsuarioSeleccionada) {
        this.historiaUsuarioSeleccionada = historiaUsuarioSeleccionada;
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

    /**
     * @return the tareaSeleccionada
     */
    public Tarea getTareaSeleccionada() {
        return tareaSeleccionada;
    }

    /**
     * @param tareaSeleccionada the tareaSeleccionada to set
     */
    public void setTareaSeleccionada(Tarea tareaSeleccionada) {
        this.tareaSeleccionada = tareaSeleccionada;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
