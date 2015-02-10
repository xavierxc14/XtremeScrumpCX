package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Tarea;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
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

    private HistoriaUsuario historiaUsuario;

    private List<HistoriaUsuario> historiasUsuarios;

    private HistoriaUsuario historiaUsuarioSeleccionada;
    private List<Tarea> tareas;

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @PostConstruct
    @Override
    public void init() {
        setHistoriaUsuarios(new ArrayList<HistoriaUsuario>());
        setTareas(new ArrayList<Tarea>());
//        buscar();
        llenarArbol();
    }

    @Override
    public String buscar() {
        try {
            setHistoriaUsuarios(historiaUsuarioServicio.buscarTodos());
            getHistoriaUsuarios().clear();
//            setHistoriaUsuarios(historiaUsuarioServicio.buscarPorProyecto(sesionControlador.getProyecto()));
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
        for (int i = 1; i < historiasUsuarios.size(); i++) {

            HistoriaUsuario historia = historiasUsuarios.get(i);
            TreeNode nodoHistoria = new DefaultTreeNode(historia, root);

            setTareas(historiaUsuarioServicio.buscarTareasPorHU(historia));

            for (int j = 0; j < tareas.size(); j++) {
                {
                    Tarea tarea = tareas.get(j);
                    TreeNode nodoTarea = new DefaultTreeNode(tarea, nodoHistoria);
                }
            }
        }
        return root;
    }

    public void nuevaTarea() {

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
}
