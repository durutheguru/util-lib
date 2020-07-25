package com.julianduru.util.json;




import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.julianduru.util.TimeUtil;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * created by julian
 */
public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {


    @Override
    public void serialize(
        ZonedDateTime value,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(value.format(DateTimeFormatter.ISO_DATE_TIME));
    }

}
