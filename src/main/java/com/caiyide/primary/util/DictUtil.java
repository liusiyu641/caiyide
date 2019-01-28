package com.caiyide.primary.util;


import com.caiyide.primary.enums.BaseTypeStateEnum;
import io.swagger.annotations.ApiModel;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liujixiang
 * @date 2018/8/13
 */
public class DictUtil {
    private static final Logger logger = LoggerFactory.getLogger(DictUtil.class);

    public static Map<String,Map<Integer,String>> map = new LinkedHashMap<>();
    public static Map<String,Map<String,String>> docMap = new LinkedHashMap<>();

    static {
        try {
            Reflections reflections = new Reflections("com.caiyide.primary.enums");
            Set<Class<? extends BaseTypeStateEnum>> subTypes = reflections.getSubTypesOf(BaseTypeStateEnum.class);
            for (Class clazz : subTypes) {
                Method keyMethod = clazz.getDeclaredMethod("getKey");
                Method valueMethod = clazz.getDeclaredMethod("getValue");
                String simpleName = clazz.getSimpleName();
                simpleName = simpleName.replaceAll("Enum","");
                simpleName = simpleName.substring(0,1).toLowerCase() + simpleName.substring(1);


                Map<String, String> docDescMap = new LinkedHashMap<>();
                docMap.put(simpleName, docDescMap);

                Annotation annotation = clazz.getAnnotation(ApiModel.class);
                if (annotation != null) {
                    ApiModel apiModel = (ApiModel) annotation;
                    docDescMap.put("value", apiModel.value());
                }


                Object[] objects = clazz.getEnumConstants();
                Map<Integer, String> enumMap = new LinkedHashMap<>();
                for (Object object : objects) {
                    Integer key = (Integer) keyMethod.invoke(object);
                    String value = (String) valueMethod.invoke(object);
                    enumMap.put(key, value);
                }

                map.put(simpleName, enumMap);
            }
            logger.info("map = " + map);
            logger.info("docMap = " + docMap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
