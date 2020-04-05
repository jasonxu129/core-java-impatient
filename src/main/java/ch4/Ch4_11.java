package ch4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ch4_11 {
    public static void main(String[] args) {
        try {
            Field f = System.class.getDeclaredField("out");
            Method m = f.getType().getMethod("println", String.class);
            // Pass in null to Field.get for static field.
            m.invoke(f.get(null),"Hello World");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
