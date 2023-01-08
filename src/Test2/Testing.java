package Test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Testing {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Шалтай-Болтай");
        list1.add("на");
        list1.add("стене");
        list1.add("стене");
        list1.add("Шалтай-Болтай");
        list1.add("Свалился");
        list1.add("во");
        list1.add("во");
        list1.add("сне");
        int c = 0;
        //System.out.print(list1);
        for (int i = 0; i < list1.size(); i++) {
            c = Collections.frequency(list1, list1.get(i));
            //System.out.print(list1.get(i));
            //System.out.print(" " + c);
            //System.out.println();




        }
    }
}