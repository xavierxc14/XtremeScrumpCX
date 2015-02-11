package ec.edu.epn.software.servicios.objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Rol;
import ec.edu.epn.software.entidades.Tarea;
import ec.edu.epn.software.entidades.Usuario;
import ec.edu.epn.software.entidades.UsuarioProyecto;
    
public class OfyService {

    static {
        factory().register(HistoriaUsuario.class);
        factory().register(Proyecto.class);
        factory().register(Usuario.class);
        factory().register(UsuarioProyecto.class);
        factory().register(Tarea.class);
        factory().register(Rol.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
