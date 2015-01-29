package com.epn.utils;

public interface MensajesError {

    final String ERROR_INGRESO_CAMPO = " es requerido/a";

    // PAGINA
    String ERROR_PAGINA_NOMBRE_REPETIDO = "Ya existe una p�gina con ese nombre.";
    String ERROR_PAGINA_URL_REPETIDA = "Ya existe una p�gina con esa URL.";
    String ERROR_PAGINA_CREADA = "No se pudo crear una nueva p�gina, error desconocido.";
    String ERROR_PAGINA_EDITADA = "No se pudo editar la p�gina, error desconocido.";
    String ERROR_PAGINA_ELIMINADA = "No se pudo eliminar la p�gina, error desconocido.";
    String CAMPO_NOMBRE_VACIO = "Favor ingrese un nombre";

    // ROL
    String ERROR_ROL_NOMBRE_REPETIDO = "Ya existe un rol con ese nombre.";
    String ERROR_ROL_SELECCION_REDIRECCION = "Debe seleccionar una p�gina para la redirecci�n.";
    String ERROR_ROL_ELIMINADO = "No se pudo eliminar la p�gina, error desconocido.";

    // SEGURIDAD
    String USUARIO_REPETIDO = "ERROR: Usuario ya existe";
    String ERROR_USUARIO_ELIMINADO = "ERROR: No se elimin� el usuario.";

    // HSITORIA DE USUARIO
    String ERROR_HU_CREADO = "ERROR:  No se pudo registrar la historia de usuario";
    String ERROR_HU_ELIMINADO = "ERROR: No se puede eliminar una hostoria de usuario que pertenece a un sprint backlog .";
}
