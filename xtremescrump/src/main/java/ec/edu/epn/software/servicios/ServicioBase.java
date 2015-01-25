package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ServicioBase<T> implements Serializable {

    private Class<T> tipoEntidad;
    private Class<?> tipoServicio;
    //protected static Logger LOG=Logger.getLogger();
    //private Objectify ofy = ObjectifyService.begin();

    public ServicioBase(Class<T> tipoEntidad, Class<?> tipoServicio) {
        this.tipoEntidad = tipoEntidad;
        this.tipoServicio = tipoServicio;
    }

    public void guardar(T entidad) {
        //LOG.log(Level.INFO, "Insertando Entidad>>{0}", entidad);
        ofy().save().entity(entidad).now();
    }

    private void actualizar(T entidad) {
        //LOG.log(Level.INFO, "Actualizando Entidad>>{0}", entidad);
    }

    public void eliminar(T entidad) {
        //LOG.log(Level.INFO, "Eliminando Entidad>>{0}", entidad);
        ofy().delete().entity(entidad).now();
    }

    public T buscarPorId(Integer id) {
        //LOG.log(Level.INFO, "Buscando Entidad con id>>{0}", id);
        Key<T> k = Key.create(tipoEntidad, id);
        return ofy().load().key(k).now();
    }

    public List<T> buscarTodos() {
        return ofy().load().type(tipoEntidad).list();
    }

}
