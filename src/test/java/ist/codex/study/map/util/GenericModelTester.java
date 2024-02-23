package ist.codex.study.map.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GenericModelTester {
    public static <T> void testEntityOrDto(Class<T> clazz) {
        testFields(clazz);
        testGettersAndSetters(clazz);
    }

    private static <T> void testFields(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }
    }

    private static <T> void testGettersAndSetters(Class<T> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get") || methodName.startsWith("set")) {
                System.out.println("Getter/Setter method: " + methodName);
            }
        }
    }
}
