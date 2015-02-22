package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Sprint;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class HistoriaUsuarioServicio extends ServicioBase<HistoriaUsuario> {

    public HistoriaUsuarioServicio() {
        super(HistoriaUsuario.class, HistoriaUsuarioServicio.class);
    }

    public List<HistoriaUsuario> buscarPorProyecto(Long idProyecto) {
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, idProyecto);
        Query<HistoriaUsuario> query = ofy().load().type(HistoriaUsuario.class);
        List<HistoriaUsuario> list = query.filter("proyecto", proyectoKey).list();
        return list;
    }

    public List<HistoriaUsuario> buscarPorProyectoSinSprint(Long idProyecto) {
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, idProyecto);
        Query<HistoriaUsuario> query = ofy().load().type(HistoriaUsuario.class);
        List<HistoriaUsuario> list = query.filter("proyecto", proyectoKey).filter("sprint", null).list();
        return list;
    }

    public List<HistoriaUsuario> buscarPorProyectoConSprint(Long idProyecto, Long idSprint) {
        Key<Proyecto> proyectoKey = Key.create(Proyecto.class, idProyecto);
        Key<Sprint> sprintKey = Key.create(Sprint.class, idSprint);
        Query<HistoriaUsuario> query = ofy().load().type(HistoriaUsuario.class);
        List<HistoriaUsuario> list = query.filter("proyecto", proyectoKey).filter("sprint", sprintKey).list();
        return list;
    }
}
