package ec.edu.epn.software.controladores;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

public abstract class ControladorBase implements Serializable {

    /**
     * Logger de la clase.
     */
    private static final Logger LOG = Logger.getLogger(ControladorBase.class);

    public abstract void init();

    /**
     * Este metodo permite obtener los registros existentes.
     *
     * @return String
     */
    public abstract String buscar();

    /**
     * Inicia la creacion de un nuevo registro.
     *
     * @return String
     */
    public abstract String nuevo();

    /**
     * Permite editar un registro.
     *
     * @return String
     */
    public abstract String editar();

    /**
     * Permite guardar un registro.
     *
     * @return String
     */
    public abstract String guardar();

    /**
     * Permite borrar un registro.
     *
     * @return String
     */
    public abstract String borrar();

    /**
     * Metodo para ejecutar una accion JS sobre un componente del contexto
     * Primefaces.
     *
     * @param comando String
     */
    public final void ejecutarJSPrimefaces(final String comando) {
        RequestContext currentInstance = RequestContext.getCurrentInstance();
        if (currentInstance != null) {
            currentInstance.execute(comando);
        }
    }

    /**
     * Metodo que realiza una redireccion a la url deseada.
     *
     * @param evt
     * @param url
     */
    public void redirect(SelectEvent evt, String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            LOG.error("Error al redirigir a la pagina", ex);
        }
    }
}
