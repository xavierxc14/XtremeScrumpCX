package ec.edu.epn.software.converters;

import ec.edu.epn.software.entidades.Usuario;
import ec.edu.epn.software.servicios.UsuarioServicio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "usuarioConverter", forClass = Usuario.class)
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        Long id = Long.parseLong(string);
        return usuarioServicio.buscarPorId(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Usuario) {
            Usuario resultado = (Usuario) o;
            return String.valueOf(resultado.getId());
        }
        return null;
    }

}
