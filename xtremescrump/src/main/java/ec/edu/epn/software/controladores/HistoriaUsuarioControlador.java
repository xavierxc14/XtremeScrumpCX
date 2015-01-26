package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class HistoriaUsuarioControlador extends ControladorBase {

    private static Logger logger = Logger.getLogger(HistoriaUsuarioControlador.class);

    public static final String LISTA = "/paginas/historia_usuario/lista_historia_usuario.jsf";
    public static final String FORMULARIO = "/paginas/historia_usuario/historia_usuario.jsf";

    private final HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();

    private HistoriaUsuario historiaUsuario;

    private List<HistoriaUsuario> historiaUsuarios;

    @PostConstruct
    @Override
    public void init() {
        buscar();
    }

    @Override
    public String buscar() {
        try {
            setHistoriaUsuarios(historiaUsuarioServicio.buscarTodos());
        } catch (Exception e) {
        }
        return LISTA;
    }

    @Override
    public String nuevo() {
        setHistoriaUsuario(new HistoriaUsuario());
        return FORMULARIO;
    }

    @Override
    public String editar() {
        return FORMULARIO;
    }

    @Override
    public String guardar() {
        historiaUsuarioServicio.guardar(historiaUsuario);
        return nuevo();
    }

    @Override
    public String borrar() {
        historiaUsuarioServicio.eliminar(historiaUsuario);
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

}
