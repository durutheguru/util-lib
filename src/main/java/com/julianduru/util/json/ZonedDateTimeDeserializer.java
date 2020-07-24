package com.julianduru.util.json;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.julianduru.util.TimeUtil;

import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * created by julian
 */
public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {


    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return ZonedDateTime.parse(jsonParser.getValueAsString(), TimeUtil.DEFAULT_DATE_TIME_FORMATTER);
    }


}
