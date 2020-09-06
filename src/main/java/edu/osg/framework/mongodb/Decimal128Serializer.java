package edu.osg.framework.mongodb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.Decimal128;

import java.io.IOException;

/**
 * User: laizhenwei
 */
public class Decimal128Serializer extends JsonSerializer<Decimal128> {
    @Override
    public void serialize(Decimal128 decimal128, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(decimal128.toString());
    }
}