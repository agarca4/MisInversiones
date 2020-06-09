package es.mdef;

import java.io.IOException;
import java.time.Instant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


@SuppressWarnings("serial")
public class InstantDeserializer extends StdDeserializer<Instant>{

	public InstantDeserializer() {
		super(Instant.class);
	}

	@Override
	public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		try {
			return Instant.parse(p.readValueAs(String.class));
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
