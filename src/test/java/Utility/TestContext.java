package Utility;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static Map<String, Object> context = new HashMap<>();

    // Store value
    public static void set(String key, Object value) {
        context.put(key, value);
    }

    // Get value
    public static Object get(String key) {
        return context.get(key);
    }

    // Type-safe getters
    public static String getString(String key) {
        Object value = context.get(key);
        return value != null ? value.toString() : null;
    }

    public static Integer getInt(String key) {
        Object value = context.get(key);
        return value instanceof Integer ? (Integer) value : null;
    }

    public static Boolean getBoolean(String key) {
        Object value = context.get(key);
        return value instanceof Boolean ? (Boolean) value : null;
    }

    // Clear context
    public static void clear() {
        context.clear();
    }


}
