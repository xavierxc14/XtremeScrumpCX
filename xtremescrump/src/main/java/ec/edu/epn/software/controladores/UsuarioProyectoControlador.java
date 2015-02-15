package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Usuario;
import ec.edu.epn.software.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

@ManagedBean
@ViewScoped
public class UsuarioProyectoControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(UsuarioProyectoControlador.class);

    @ManagedProperty("#{sesionControlador}")
    private SesionControlador sesionControlador;

    private final UsuarioServicio usuarioServicio = new UsuarioServicio();

    private List<Usuario> usuariosDisponibles;

    private List<Usuario> usuariosAsignados;

    private DualListModel<Usuario> usuarios;

    @PostConstruct
    @Override
    public void init() {
        setUsuariosAsignados(new ArrayList<Usuario>());
        setUsuariosDisponibles(new ArrayList<Usuario>());
        setUsuarios(new DualListModel<>(usuariosDisponibles, usuariosAsignados));
    }

    @Override
    public String buscar() {
        try {
            setUsuariosDisponibles(usuarioServicio.buscarSinProyecto());
            setUsuariosAsignados(usuarioServicio.buscarPorProyecto(getSesionControlador().getProyecto()));
            setUsuarios(new DualListModel<>(usuariosDisponibles, usuariosAsignados));
        } catch (Exception ex) {
            LOG.error("Error al realizar la busqueda de usuarios", ex);
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
        for (Usuario u : usuarios.getSource()) {
            u.setProyecto(null);
            usuarioServicio.guardar(u);
        }
        for (Usuario u : usuarios.getTarget()) {
            u.setProyecto(getSesionControlador().getProyecto());
            usuarioServicio.guardar(u);
        }
        return buscar();
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgTeam').hide()");
        return null;
    }

    @Override
    public String borrar() {
        return null;
    }

    public String agregarTeam() {
        buscar();
        ejecutarJSPrimefaces("PF('dlgTeam').show()");
        return null;
    }

    /**
     * @return the usuariosDisponibles
     */
    public List<Usuario> getUsuariosDisponibles() {
        return usuariosDisponibles;
    }

    /**
     * @param usuariosDisponibles the usuariosDisponibles to set
     */
    public void setUsuariosDisponibles(List<Usuario> usuariosDisponibles) {
        this.usuariosDisponibles = usuariosDisponibles;
    }

    /**
     * @return the usuariosAsignados
     */
    public List<Usuario> getUsuariosAsignados() {
        return usuariosAsignados;
    }

    /**
     * @param usuariosAsignados the usuariosAsignados to set
     */
    public void setUsuariosAsignados(List<Usuario> usuariosAsignados) {
        this.usuariosAsignados = usuariosAsignados;
    }

    /**
     * @return the usuarios
     */
    public DualListModel<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(DualListModel<Usuario> usuarios) {
        this.usuarios = usuarios;
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
