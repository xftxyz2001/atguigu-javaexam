
import java.lang.reflect.Field;

/**
 * TestCache
 */
public class TestCache {

    public static void main(String[] args) {
        change(1 + 1, 3);

        // java --add-opens java.base/java.lang=ALL-UNNAMED TestCache.java
        int a = 1;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);

    }

    private static void change(int i, int j) {
        try {
            Class<?> clazz = Integer.class.getDeclaredClasses()[0];
            Field cache = clazz.getDeclaredField("cache");
            cache.setAccessible(true);
            Integer[] newCache = (Integer[]) cache.get(clazz);
            newCache[128 + i] = newCache[128 + j];
        } catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
