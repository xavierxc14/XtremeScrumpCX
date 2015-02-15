package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Usuario;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class UsuarioServicio extends ServicioBase<Usuario> {

    public UsuarioServicio() {
        super(Usuario.class, UsuarioServicio.class);
    }

    public List<Usuario> buscarPorProyecto(Proyecto p) {
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, p.getId());
        Query<Usuario> query = ofy().load().type(Usuario.class);
        List<Usuario> list = query.filter("proyecto", proyectoKey).list();
        return list;
    }

    public List<Usuario> buscarSinProyecto() {
        Query<Usuario> query = ofy().load().type(Usuario.class);
        List<Usuario> list = query.filter("proyecto", null).list();
        return list;
    }
}
