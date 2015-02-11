package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.Rol;
import ec.edu.epn.software.servicios.RolServicio;
import ec.edu.epn.software.utils.MensajesInformacion;
import ec.edu.epn.software.utils.MensajesPagina;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class RolControlador extends ControladorBase {
    
    private static Logger LOG = Logger.getLogger(RolControlador.class);
    
    public static final String LISTA = "/paginas/roles/roles.jsf";
    
    private final RolServicio rolServicio = new RolServicio();
    
    private Rol rol;
    
    private List<Rol> roles;
    
    @PostConstruct
    @Override
    public void init() {
        setRoles(new ArrayList<Rol>());
        buscar();
    }
    
    @Override
    public String buscar() {
        try {
            setRoles(rolServicio.buscarTodos());
        } catch (Exception ex) {
            LOG.error("Error al hacer la buscqueda de roles", ex);
        }
        return LISTA;
    }
    
    @Override
    public String nuevo() {
        setRol(new Rol());
        ejecutarJSPrimefaces("PF('dlgRol').show()");
        return null;
    }

    @Override
    public String editar() {
        ejecutarJSPrimefaces("PF('dlgRol').show()");
        return null;
    }

    @Override
    public String guardar() {
        rolServicio.guardar(rol);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.ROL_CREADO);
        cerrarDialogo();
        return buscar();
    }

    @Override
    public String cerrarDialogo() {
        ejecutarJSPrimefaces("PF('dlgRol').show()");
        return null;
    }

    @Override
    public String borrar() {
        rolServicio.eliminar(rol);
        MensajesPagina.mostrarMensajeInformacion(MensajesInformacion.ROL_ELIMINADO);
        ejecutarJSPrimefaces("PF('dlgElimRol').hide()");
        return buscar();
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the roles
     */
    public List<Rol> getRoles() {
        return roles;
    }

    /**
     * @param roles the proyectos to set
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
