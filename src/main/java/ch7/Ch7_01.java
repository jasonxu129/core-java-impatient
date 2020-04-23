package ch7;

import java.util.*;

public class Ch7_01 {
    public static Set<Integer> findAllPrimes(int n) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }
        for (int s = 2; s * s <= n; s++) {
            int x = s;
            while (s * x <= n) {
                nums.remove(s * x);
                x += 1;
            }
        }
        return nums;
    }

    public static Set<Integer> findAllPrimesBitSet(int n) {
        BitSet bits = new BitSet(n+1);
        bits.set(0, n+1);
        for (int s = 2; s * s <= n; s++) {
            if (!bits.get(s)) {
                continue;
            }
            int x = s;
            while (s * x <= n) {
                bits.clear(s * x);
                x += 1;
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (bits.get(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Set<Integer> res = findAllPrimes(50);
        System.out.println(res);

        Set<Integer> res1 = findAllPrimesBitSet(50);
        System.out.println(res1);

        System.out.println(res.containsAll(res1));

        // Test Properties collections.
        Properties p = System.getProperties();
        System.out.println(p.getProperty("java.home"));


    }
}
