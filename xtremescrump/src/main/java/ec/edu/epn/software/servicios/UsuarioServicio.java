package ec.edu.epn.software.servicios;

import ec.edu.epn.software.entidades.Usuario;

public class UsuarioServicio extends ServicioBase<Usuario> {

    public UsuarioServicio() {
        super(Usuario.class, UsuarioServicio.class);
    }

}
