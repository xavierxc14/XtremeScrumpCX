package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import ec.edu.epn.software.entidades.HistoriaUsuario;

public class OfyService {

    static {
        factory().register(HistoriaUsuario.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
