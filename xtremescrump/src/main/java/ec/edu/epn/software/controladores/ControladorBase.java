package ec.edu.epn.software.controladores;

import java.io.Serializable;

public abstract class ControladorBase implements Serializable {

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
}
