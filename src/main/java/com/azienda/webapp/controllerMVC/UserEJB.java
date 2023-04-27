package com.azienda.webapp.controllerMVC;

import com.azienda.webapp.dao.interfaces.UtenteDao;

import jakarta.ejb.Stateful;
import jakarta.inject.Inject;

@Stateful
public class UserEJB {

	@Inject
	private UtenteDao utenteDao;
	
}
