package ec.edu.epn.software.servicios.objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import ec.edu.epn.software.entidades.CriterioAceptacion;
import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Rol;
import ec.edu.epn.software.entidades.Sprint;
import ec.edu.epn.software.entidades.Tarea;
import ec.edu.epn.software.entidades.Usuario;

public class OfyService {

    static {

        factory().register(Proyecto.class);
        factory().register(HistoriaUsuario.class);
        factory().register(Usuario.class);
        factory().register(Tarea.class);
        factory().register(Rol.class);
        factory().register(Sprint.class);
        factory().register(CriterioAceptacion.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
