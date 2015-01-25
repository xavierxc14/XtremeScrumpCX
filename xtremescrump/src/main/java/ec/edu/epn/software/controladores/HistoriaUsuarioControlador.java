package ec.edu.epn.software.controladores;

import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.servicios.HistoriaUsuarioServicio;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Xavier Naunay <xavier.naunay@markasoft.ec>
 */
@ManagedBean
@SessionScoped
public class HistoriaUsuarioControlador extends ControladorBase {

    private static Logger logger;
    private HistoriaUsuarioServicio historiaUsuarioServicio = new HistoriaUsuarioServicio();
    private HistoriaUsuario historiaUsuario;
    private List<HistoriaUsuario> historiaUsuarios;

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
        return null;
    }

    @Override
    public String guardar() {
        historiaUsuario = new HistoriaUsuario("HU01", "Levantar ambiente", 1, 8);
        historiaUsuarioServicio.guardar(historiaUsuario);
        historiaUsuario = new HistoriaUsuario();
        return "welcome";
    }

    @Override
    public String borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String iniciarCreacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
