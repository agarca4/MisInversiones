package es.mdef;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class InstantSerializer extends StdSerializer<Instant> {

	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")
			.withZone(ZoneId.of("UTC"));

	public InstantSerializer() {
		super(Instant.class);
	}

	@Override
	public void serialize(Instant value, JsonGenerator gen, SerializerProvider provider) throws IOException {

		final String serializedInstant = dateTimeFormatter.format(value);
		gen.writeString(serializedInstant);

	}

}
