package ec.edu.epn.software.servicios;

import ec.edu.epn.software.entidades.Tarea;

public class TareaServicio extends ServicioBase<Tarea> {

    public TareaServicio() {
        super(Tarea.class, TareaServicio.class);
    }

}
