package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Usuario;
import ec.edu.epn.software.servicios.UsuarioServicio;
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

    private Usuario usuario;

    private List<Usuario> usuarios;

    @PostConstruct
    @Override
    public void init() {
        buscar();
        setUsuarios(new ArrayList<Usuario>());
    }

    @Override
    public String buscar() {
        try {
            setUsuarios(usuarioServicio.buscarTodos());
        } catch (Exception e) {
        }
        return LISTA;
    }

    @Override
    public String nuevo() {
        setUsuario(new Usuario());
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
        usuarioServicio.guardar(getUsuario());
        return nuevo();
    }

    @Override
    public String cerrarDialogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrar() {
        usuarioServicio.eliminar(getUsuario());
        return buscar();
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

}
