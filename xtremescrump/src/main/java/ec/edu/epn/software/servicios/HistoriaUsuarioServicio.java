package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Proyecto;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class HistoriaUsuarioServicio extends ServicioBase<HistoriaUsuario> {

    public HistoriaUsuarioServicio() {
        super(HistoriaUsuario.class, HistoriaUsuarioServicio.class);
    }

    public List<HistoriaUsuario> buscarPorProyecto(Proyecto p) {
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, p.getId());
        return ofy().load().type(HistoriaUsuario.class).filter("proyecto", proyectoKey).list();
    }

}
