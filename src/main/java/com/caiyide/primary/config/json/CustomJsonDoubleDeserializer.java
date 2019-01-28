package com.caiyide.primary.config.json;

import com.caiyide.primary.config.converter.StringToDoubleUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import java.io.IOException;

/**
 * @author liujixiang
 * @date 2018/08/05
 */
public class CustomJsonDoubleDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String string = jsonParser.getText();
        return StringToDoubleUtil.convert(string);
    }
}
