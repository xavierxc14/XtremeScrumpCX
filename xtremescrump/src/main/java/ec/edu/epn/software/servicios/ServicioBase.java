package ec.edu.epn.software.servicios;

import com.googlecode.objectify.Key;
import static ec.edu.epn.software.servicios.objectify.OfyService.ofy;
import java.io.Serializable;
import java.util.List;

public abstract class ServicioBase<T> implements Serializable {

    private Class<T> tipoEntidad;
    private Class<?> tipoServicio;

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

    public T buscarPorId(Long id) {
        //LOG.log(Level.INFO, "Buscando Entidad con id>>{0}", id);
        Key<T> k = Key.create(tipoEntidad, id);
        return ofy().load().key(k).now();
    }

    public List<T> buscarTodos() {
        return ofy().load().type(tipoEntidad).list();
    }

}
