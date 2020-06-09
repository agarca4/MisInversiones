package es.mdef.rest;

import java.time.Instant;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import es.mdef.InstantDeserializer;
import es.mdef.InstantSerializer;
import es.mdef.productosfinancieros.fondosinversion.FondoInversion;
import es.mdef.usuarios.Usuario;

public class MixIns {

	@JsonIgnoreProperties(value = { "usuarios" })
	@JsonPropertyOrder({ "fechaCreacionCartera", "nombre", "capitalInvertido", "rentabilidad", "fondos" })
	public static interface Carteras {

		@JsonProperty("id")
		abstract String getId();

		@JsonProperty("fechaCreacionCartera")
		@JsonDeserialize(using = InstantDeserializer.class)
		@JsonSerialize(using = InstantSerializer.class)
		abstract Instant getFechaCreacionCartera();

		@JsonProperty("nombre")
		abstract String getNombre();

		@JsonProperty("capitalInvertido")
		abstract double getCapitalInvertido();

		@JsonProperty("rentabilidad")
		abstract Double getRentabilidad();

		@JsonProperty("fondos")
		abstract Collection<FondoInversion> getFondos();

		@JsonProperty("usuarios")
		abstract Collection<Usuario> getUsuarios();

	}

}
