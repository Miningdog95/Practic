package Test2;
// regex

import java.io.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Inner {

    private static String reader(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while (reader.ready()) {
                text.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private static String[] convert(String input) {
        String[] array = input.toLowerCase().split("[,.!?: ]");
        return array;
    }

    private static Map<String, Integer> countWord(String[] input) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[i].equals(input[j])) {
                    count++;
                }
            }
            map.put(input[i], count);
        }
        return map;
    }

    private static void writer(Map<String, Integer> input, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> pair : input.entrySet()) {
                writer.write(pair.getKey() + " " + pair.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(String sourse, String result) throws IOException {
        writer(countWord(convert(reader(sourse))), result);
    }


//    private static List<String> SplitAndInList(String[] input) {
//        List<String> res = new ArrayList<>();
//        List<String> res1 = new ArrayList<>();
//        String s = new String();
//        String r = new String();
//        for (int i = 0; i < input.length; i++) {
//            s = input[i].toLowerCase();
//            //System.out.println(s);
//            res.add(s);
//        }
//        //System.out.print(res);
//        for (int i = 0; i < res.size(); i++) {
//            String[] split = res.get(i).split(" ");
//            for (int j = 0; j < split.length; j++) {
//                System.out.println(split[j]);
//                r = String.join("", split[j]);
//                res1.add(r);
//            }
//        }
//        //for (String s1 : res1)
//        //System.out.println(s1+" ");
//        return res;
//    }
//
//    private static List<String[]> magic(List<String> input) {
//        int c = 0;
//        for (int i = 0; i < input.size(); i++) {
//            //System.out.println(input.get(i));
//            c = Collections.frequency(input, input.get(i));
//            //System.out.print(c);
//        }
//        //System.out.println(c);
//        //System.out.print(input1.get(i));
//        //System.out.println(" " + c);
//        return null;
//    }

}