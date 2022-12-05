package day5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    private List<Stack<String>> stacks;

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/williamfrisk/Documents/GitHub/AoC-2022/src/day5/puzzle_input.txt");
        Scanner sc = new Scanner(file);

        List<int[]> inputList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");

            int i = 0;
            int[] temp = new int[3]; 
            for (String elem : line) {
                try {
                    temp[i] = Integer.parseInt(elem);
                    i++;
                } catch (Exception e) {
                    continue;
                }
            }
            inputList.add(temp);
        }
        sc.close();

        Main instance = new Main();

        System.out.println(instance.task2(inputList));
    }

    private Main() {
        setUpStacks();
    }

    private void setUpTestStacks() {
        stacks = new ArrayList<>();

        String[] arr = {"Z", "N"};
        stacks.add(new Stack<>(arr));
        
        arr = new String[] {"M", "C", "D"};
        stacks.add(new Stack<>(arr));
        
        arr = new String[] {"P"};
        stacks.add(new Stack<>(arr));
    }

    private void setUpStacks() {
        stacks = new ArrayList<>();

        String[] arr = {"H", "C", "R"};
        stacks.add(new Stack<>(arr));
        
        arr = new String[] {"B", "J", "H", "L", "S", "F"};
        stacks.add(new Stack<>(arr));
        
        arr = new String[] {"R", "M", "D", "H", "J", "T", "Q"};
        stacks.add(new Stack<>(arr));
        
        arr = new String[] {"S", "G", "R", "H", "Z", "B", "J"};
        stacks.add(new Stack<>(arr));

        arr = new String[] {"R", "P", "F", "Z", "T", "D", "C", "B"};
        stacks.add(new Stack<>(arr));

        arr = new String[] {"T", "H", "C", "G"};
        stacks.add(new Stack<>(arr));

        arr = new String[] {"S", "N", "V", "Z", "B", "P", "W", "L"};
        stacks.add(new Stack<>(arr));

        arr = new String[] {"R", "J", "Q", "G", "C"};
        stacks.add(new Stack<>(arr));

        arr = new String[] {"L", "D", "T", "R", "H", "P", "F", "S"};
        stacks.add(new Stack<>(arr));

    }

    private String task1(List<int[]> arr) {
        for (int[] commands : arr) {
            for (int i = 0; i < commands[0]; i++) {
                stacks.get(commands[2] - 1).add(stacks.get(commands[1] - 1).pop());
            }
        }

        String result = "";
        for (Stack<String> stack : stacks) {
            result += stack.peek();
        }

        return result;
    }

    private String task2(List<int[]> arr) {
        for (int[] commands : arr) {
            stacks.get(commands[2] - 1).add(stacks.get(commands[1] - 1). pop(commands[0]));
        }

        String result = "";
        for (Stack<String> stack : stacks) {
            result += stack.peek();
        }

        return result;
    }
}