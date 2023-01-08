package Test3;

import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Writer {

    public static String read(String filePath) throws IOException {
        StringBuilder str = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while (reader.ready()) {
                str.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public static String[] split(String input) {
        String[] array1 = input.split("(?=[А-Я, ])");
        String[] array = new String[array1.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = array1[i].trim();
        }
        for (String s : array
        ) {
            //System.out.println(s);
        }
        return array;
    }

    public static Map<String, Double> calculate(String[] input) {
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < input.length - 1; i = i + 2) {
            for (int j = i + 1; j < input.length; j = j + 2) {
                //System.out.println(input[i]);
                //System.out.println(Double.parseDouble(input[j]));
                if (map.containsKey(input[i])) {
                    map.put(input[i], map.get(input[i]) + Double.parseDouble(input[j]));
                    break;
                } else {
                    map.put(input[i], Double.parseDouble(input[j]));
                    break;
                }
            }
        }
        //System.out.println(map);
        return map;
    }

    public static void writer(Map<String, Double> input, String filePath) throws IOException {
        TreeMap<String, Double> sorted = new TreeMap<>(input);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Double> pair : sorted.entrySet()) {
                writer.write(pair.getKey() + " " + pair.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(String source, String result) throws IOException {
        writer(calculate(split(read(source))), result);
    }
}
