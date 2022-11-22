package Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) {
        System.out.println("Vvod");
        Scanner scanner = new Scanner(System.in);
        int i;
        int j;
        String Vvod = scanner.nextLine();
        String array[] = Vvod.split(" ");

        for (i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Reverse");

        for (j = array.length - 1; j >= 0; j--) {
            int result = Integer.parseInt(array[j]);
            System.out.println(result);
        }
    }
}

