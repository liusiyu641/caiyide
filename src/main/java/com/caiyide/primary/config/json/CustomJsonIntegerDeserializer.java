package com.caiyide.primary.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.caiyide.primary.config.converter.StringToIntegerUtil;

import java.io.IOException;

/**
 * @author liujixiang
 * @date 2018/08/05
 */
public class CustomJsonIntegerDeserializer  extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String string = jsonParser.getText();
        return StringToIntegerUtil.convert(string);
    }
}
