package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Proyecto;
import ec.edu.epn.software.entidades.Sprint;
import ec.edu.epn.software.entidades.Tarea;
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

    public List<HistoriaUsuario> buscarSinSprint() {
        Query<HistoriaUsuario> query = ofy().load().type(HistoriaUsuario.class);
        List<HistoriaUsuario> list = query.filter("sprint", null).list();
        return list;
    }

    public List<HistoriaUsuario> buscarPorSprint(Long idSprint) {
        Key<Sprint> sprintKey = Key.create(Sprint.class, idSprint);
        Query<HistoriaUsuario> query = ofy().load().type(HistoriaUsuario.class);
        List<HistoriaUsuario> list = query.filter("sprint", sprintKey).list();
        return list;
    }

    public List<Tarea> buscarTareasPorHU(Long idHistoriaUsuario) {
        Key<HistoriaUsuario> historiaUsuarioKey = Key.create(HistoriaUsuario.class, idHistoriaUsuario);
        Query<Tarea> query = ofy().load().type(Tarea.class);
        List<Tarea> list = query.filter("historia", historiaUsuarioKey).list();
        return list;
    }
}
