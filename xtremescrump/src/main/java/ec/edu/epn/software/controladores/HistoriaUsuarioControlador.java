package ec.edu.epn.software.controladores;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Xavier Naunay <xavier.naunay@markasoft.ec>
 */
@ManagedBean(name = "historiaUsuarioBean")
@SessionScoped
public class HistoriaUsuarioControlador implements Serializable {

    private String saludo;

    /**
     * @return the saludo
     */
    public String getSaludo() {
        return saludo;
    }

    /**
     * @param saludo the saludo to set
     */
    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

}
