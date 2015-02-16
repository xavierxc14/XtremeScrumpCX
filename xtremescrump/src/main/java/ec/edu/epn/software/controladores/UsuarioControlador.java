package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Rol;
import ec.edu.epn.software.entidades.Usuario;
import ec.edu.epn.software.servicios.RolServicio;
import ec.edu.epn.software.servicios.UsuarioServicio;
import ec.edu.epn.software.utils.MensajesInformacion;
import ec.edu.epn.software.utils.MensajesPagina;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class UsuarioControlador extends ControladorBase {

    private static Logger LOG = Logger.getLogger(UsuarioControlador.class);

    public static final String LISTA = "/paginas/usuario/usuarios.jsf";

    private final UsuarioServicio usuarioServicio = new UsuarioServicio();

    private final RolServicio rolServicio = new RolServicio();

    private Usuario usuario;

    private List<Usuario> usuarios;

    private List<Rol> roles;

    private Integer IdRol;

    @PostConstruct
    @Override
    public void init() {
        setUsuario(new Usuario());
        setUsuarios(new ArrayList<Usuario>());
        buscar();
        buscarRoles();
    }

    @Override
    public String buscar() {
        try {
            setUsuarios(usuarioServicio.buscarTodos());
        } catch (Exception ex) {
            LOG.error("Error al buscar usuarios", ex);
        }
        return LISTA;
    }

    @Override
    public String nuevo() {
        setUsuario(new Usuario());
        setIdRol(0);
        ejecutarJSPrimefaces("PF('dlgUsuario').show()");
        return null;
    }

    @Override
    public String editar() {
        ejecutarJSPrimefaces("PF('dlgUsuario').show()");
        return null;
    }

    @Override
    public String guardar() {
        usuarioServicio.guardar(getUsuario());
        cerrarDialogo();
        return nuevo();
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgUsuario').hide()");
        return null;
    }

    @Override
    public String borrar() {
        usuarioServicio.eliminar(usuario);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.USUARIO_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimUsuario').hide()");
        return buscar();
    }

    public void buscarRoles() {
        setRoles(rolServicio.buscarTodos());
    }

    /**
     * @return the LISTA
     */
    public String getLISTA() {
        return LISTA;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

}
