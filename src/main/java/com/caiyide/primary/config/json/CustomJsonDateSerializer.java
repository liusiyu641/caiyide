package com.caiyide.primary.config.json;

import com.caiyide.primary.common.util.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;

/**
 * @author liujixiang
 * @date 2018/08/05
 */
public class CustomJsonDateSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if (date != null){
            String dateString = DateUtil.getYYYYMMDDHHMMSS(date);
            jsonGenerator.writeString(dateString);
        }
    }
}
