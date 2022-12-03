package day4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/williamfrisk/Documents/GitHub/AoC-2022/src/day4/puzzle_input.txt");
        Scanner sc = new Scanner(file);

        List<String> inputList = new ArrayList<>();

        while (sc.hasNextLine()) {
            inputList.add(sc.nextLine());
        }
        sc.close();

        System.out.println(task1(inputList));
    }

    private static int task1(List<String> arr) {
        return -1;
    }
}