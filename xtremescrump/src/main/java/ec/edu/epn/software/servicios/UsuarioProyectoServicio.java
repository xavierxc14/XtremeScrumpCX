package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.UsuarioProyecto;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class UsuarioProyectoServicio extends ServicioBase<UsuarioProyecto> {

    public UsuarioProyectoServicio() {
        super(UsuarioProyecto.class, UsuarioProyectoServicio.class);
    }

    public List<UsuarioProyecto> buscarPorProyecto(Proyecto p) {
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, p.getId());
        Query<UsuarioProyecto> query = ofy().load().type(UsuarioProyecto.class);
        List<UsuarioProyecto> list = query.filter("proyecto", proyectoKey).list();
        return list;
    }
}
