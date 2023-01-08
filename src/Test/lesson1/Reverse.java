package Test.lesson1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reverse {
    private static List<String> inputDataFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new LinkedList<>();
        System.out.println("input string");
        String input = "";
        while (!(input = scanner.nextLine()).equals("exit")) {
            result.add(input);
        }
        return result;
    }

    private static List<int[]> converterData(List<String> input) {
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < input.size(); i++) {
            String[] temp = input.get(i).split(" ");
            int[] array = new int[temp.length];
            for (int j = 0; j < temp.length; j++) {
                array[j] = Integer.parseInt(temp[j]);
            }
            result.add(array);
        }
        return result;
    }

    private static List<int[]> reverseData(List<int[]> inputData) {
        Collections.reverse(inputData);
        for (int i = 0; i < inputData.size(); i++) {
            reverse(inputData.get(i));
        }
        return inputData;
    }

    private static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    private static void printToConsole(List<int[]> outputData) {
        for (int i = 0; i < outputData.size(); i++) {
            for (int j = 0; j < outputData.get(i).length; j++) {
                System.out.print(outputData.get(i)[j] + " ");
            }
            System.out.println();
        }
    }

    public static void start() {
        printToConsole(reverseData(converterData(inputDataFromKeyboard())));
    }

    public static void print() {
        List<String> list = inputDataFromKeyboard();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}