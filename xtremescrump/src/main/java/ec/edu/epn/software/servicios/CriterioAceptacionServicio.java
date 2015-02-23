package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import ec.edu.epn.software.entidades.CriterioAceptacion;
import ec.edu.epn.software.entidades.Tarea;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.util.List;

public class CriterioAceptacionServicio extends ServicioBase<CriterioAceptacion> {

    public CriterioAceptacionServicio() {
        super(CriterioAceptacion.class, CriterioAceptacionServicio.class);
    }

    public List<CriterioAceptacion> buscarPorTarea(Long idTarea) {
        Key<Tarea> tareaKey = Key.create(Tarea.class, idTarea);
        Query<CriterioAceptacion> query = ofy().load().type(CriterioAceptacion.class);
        List<CriterioAceptacion> list = query.filter("tarea", tareaKey).list();
        return list;
    }
}
