package com.epn.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensajesPagina {

	public static void mostrarMensajeError(String mensajeError) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, mensajeError, ""));
	}

	public static void mostrarMensajeInformacion(String mensajeInfo) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensajeInfo, ""));
	}

	public static void mostrarMensajeError(String idComponente,
			String mensajeError) {
		FacesContext.getCurrentInstance()
				.addMessage(
						idComponente,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								mensajeError, ""));
	}

	public static void mostrarMensajeInformacion(String idComponente,
			String mensajeInfo) {
		FacesContext.getCurrentInstance().addMessage(idComponente,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensajeInfo, ""));
	}

}
