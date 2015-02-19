package ec.edu.epn.software.servicios;

import ec.edu.epn.software.entidades.Proyecto;

public class ProyectoServicio extends ServicioBase<Proyecto> {

    public ProyectoServicio() {
        super(Proyecto.class, ProyectoServicio.class);
    }

}
