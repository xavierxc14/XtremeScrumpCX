package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.HistoriaUsuario;
import ec.edu.epn.software.entidades.Tarea;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class TareaServicio extends ServicioBase<Tarea> {

    public TareaServicio() {
        super(Tarea.class, TareaServicio.class);
    }

    public List<Tarea> buscarPorHU(Long idHistoriaUsuario) {
        Key<HistoriaUsuario> historiaUsuarioKey = Key.create(HistoriaUsuario.class, idHistoriaUsuario);
        Query<Tarea> query = ofy().load().type(Tarea.class);
        List<Tarea> list = query.filter("historia", historiaUsuarioKey).list();
        return list;
    }

}
