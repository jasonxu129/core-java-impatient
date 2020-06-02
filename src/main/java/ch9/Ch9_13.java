package ch9;

import java.io.*;
import java.util.Arrays;

public class Ch9_13 {
    public static Object clone(Serializable s) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(s);

        byte[] bytes = out.toByteArray();
        System.out.println(Arrays.toString(bytes));
        return restoreObject(bytes);
    }

    public static Object restoreObject(byte[] bytes) throws IOException, ClassNotFoundException {
        InputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(in);
        return ois.readObject();
    }

    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4};
        try {
            Object obj = clone(list);
            int[] cloned = (int[]) obj;
            System.out.println(list);
            System.out.println(cloned);
            System.out.println(Arrays.toString(cloned));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
