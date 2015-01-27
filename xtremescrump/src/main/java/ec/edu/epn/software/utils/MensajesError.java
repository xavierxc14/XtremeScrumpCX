package com.epn.utils;

public interface MensajesError {

	final String ERROR_INGRESO_CAMPO = " es requerido/a";

	// PAGINA
	String ERROR_PAGINA_NOMBRE_REPETIDO = "Ya existe una página con ese nombre.";
	String ERROR_PAGINA_URL_REPETIDA = "Ya existe una página con esa URL.";
	String ERROR_PAGINA_CREADA = "No se pudo crear una nueva página, error desconocido.";
	String ERROR_PAGINA_EDITADA = "No se pudo editar la página, error desconocido.";
	String ERROR_PAGINA_ELIMINADA = "No se pudo eliminar la página, error desconocido.";
	String CAMPO_NOMBRE_VACIO = "Favor ingrese un nombre";

	// ROL
	String ERROR_ROL_NOMBRE_REPETIDO = "Ya existe un rol con ese nombre.";
	String ERROR_ROL_SELECCION_REDIRECCION = "Debe seleccionar una página para la redirección.";
	String ERROR_ROL_ELIMINADO = "No se pudo eliminar la página, error desconocido.";

	// SEGURIDAD
	String USUARIO_REPETIDO = "ERROR: Usuario ya existe";
	String ERROR_USUARIO_ELIMINADO = "ERROR: No se eliminó el usuario.";

	// CONDÓMINO
	String CONDOMINO_CREADO = "No se pudo registrar el condómino.";
}
