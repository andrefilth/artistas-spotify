package com.br.artistas.exceptions.serializer;


import com.br.artistas.exceptions.ArtistaException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ExceptionSerializer extends StdSerializer<ArtistaException> {

    public ExceptionSerializer() {
        this(null);
    }

    private ExceptionSerializer(Class<ArtistaException> t) {
        super(t);
    }

    @Override
    public void serialize(ArtistaException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("error", value.getErrorCode());

        if (value.getMessage() != null) {
            gen.writeStringField("error_description", value.getMessage());
        }

        if (value.getFields() != null && !value.getFields().isEmpty()) {
            gen.writeObjectField("fields", value.getFields());
        }
    }

}
