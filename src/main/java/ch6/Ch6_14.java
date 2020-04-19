package ch6;

import ch5.Ch5_9;

import java.util.ArrayList;

public class Ch6_14 {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Exception ex = null;
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                ex = new Exception(e.getMessage(), ex);
                /*
                if (ex == null) {
                    ex.initCause(ex);
                }
                ex = e;
                 */
            }
        }
        if (ex != null) {
            throw ex;
        }
    }
}
