package util;

import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * @author zhangbo
 * @date 2018/6/16
 */
public class ReflexUtil {

    /**
     * 通过对象和字段名获取value
     *
     * @param propertiesName 属性名
     * @param object         对象
     * @return value
     */
    public static Object invokeMethod(String propertiesName, Object object) {
        try {
            if (object == null)
                return null;
            if (!propertiesName.contains(".")) {
                String methodName = "get" + getMethodName(propertiesName);
                Method method = object.getClass().getMethod(methodName);
                return method.invoke(object);
            }
            String methodName = "get" + getMethodName(propertiesName.substring(0, propertiesName.indexOf(".")));
            Method method = object.getClass().getMethod(methodName);
            return invokeMethod(propertiesName.substring(propertiesName.indexOf(".") + 1), method.invoke(object));

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取字段名
     *
     * @param fildeName 字段名
     * @return 字段名
     */
    private static String getMethodName(String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
