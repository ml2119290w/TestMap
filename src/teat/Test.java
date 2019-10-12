package teat;

import java.sql.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int[] a = {9,3,5,6,1,0,3,8,4};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;

                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}