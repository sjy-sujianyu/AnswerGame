package org.stream.answerduel.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * 功能描述：重写JSON序列化
 *
 * @Auther: 梁展鹏
 * @Date: 2018/8/2 10:21
 */
public class FastJsonEnumSerializer extends JsonSerializer {

    @Override
    public void serialize(Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (object instanceof HttpStatus) {
            HttpStatus httpStatus = (HttpStatus) object;
            jsonGenerator.writeNumber(httpStatus.value());
        }
    }

}
