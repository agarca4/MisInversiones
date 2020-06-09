package es.mdef.repositorios;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import es.mdef.CarteraInversion;

@Component
public class CarteraListener {
	
	private Logger log = LoggerFactory.getLogger(CarteraListener.class);

	@Autowired
	public void init() {
	}
	@PrePersist 
	void prePersist(CarteraInversion cartera) {

		cartera.getRentabilidad();
		cartera.getCapitalInvertido();
		log.error("Hola soy pre");

	}
	@PreUpdate
	void preUpdate(CarteraInversion cartera) {
		cartera.getRentabilidad();
		cartera.getCapitalInvertido();
		log.error("Hola soy up");
	}

}
