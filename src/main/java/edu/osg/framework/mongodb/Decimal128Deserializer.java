package edu.osg.framework.mongodb;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bson.types.Decimal128;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * User: laizhenwei
 */
public class Decimal128Deserializer extends JsonDeserializer<Decimal128> {
    @Override
    public Decimal128 deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return new Decimal128(new BigDecimal(jsonParser.getText()));
    }
}