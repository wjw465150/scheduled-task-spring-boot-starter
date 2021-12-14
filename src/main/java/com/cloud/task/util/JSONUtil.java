package com.cloud.task.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * <JSON工具类><br/>
 *
 */
public final class JSONUtil {
  private static ObjectMapper objectMapper;
  static {
    JsonMapper.Builder builder = JsonMapper.builder();

    //允许反斜杠
    builder.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
    //允许控制字符
    builder.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS);

    objectMapper = builder.build();

    objectMapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);
    objectMapper.setVisibility(PropertyAccessor.GETTER, Visibility.NONE);
    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

  }

  private JSONUtil() {
    super();
  }

  /**
   * <JSON字符串转Java对象><br>
   * @param <T>
   * @param jsonText
   * @param classType
   * @return
   */
  public static <T> T parseObject(String jsonText, Class<T> classType) {
    if (jsonText == null || "".equals(jsonText)) {
      return null;
    }
    
    try {
      return objectMapper.readValue(jsonText,classType);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * <Java对象转JSON字符串><br/>
   * @param object
   * @return
   */
  public static String toJSONString(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
