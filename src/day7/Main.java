package day7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    private Tree directoryTree;

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/williamfrisk/Documents/GitHub/AoC-2022/src/day7/puzzle_input.txt");
        Scanner sc = new Scanner(file);

        List<String> inputList = new ArrayList<>();

        while (sc.hasNextLine()) {
            inputList.add(sc.nextLine());
        }
        sc.close();

        Main instance = new Main();
        //System.out.println(instance.task_1(inputList));

        instance = new Main();
        System.out.println(instance.task_2(inputList));
    }

    private Main() {
        directoryTree = new Tree();
    }

    private int task_1(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            if (line.startsWith("$")) {
                if (line.substring(2, 4).equals("cd")) {
                    String[] subLines = line.split(" ");
                    directoryTree.moveTo(subLines[2]);

                } else if (line.substring(2, 4).equals("ls") ) {
                    i++;
                    line = input.get(i);
                    while (!line.startsWith("$")) {
                        String[] subLines = line.split(" ");
                        if (subLines[0].equals("dir")) {
                            directoryTree.putDirectory(subLines[1]);
                        } else {
                            directoryTree.putFile(subLines[1], Integer.parseInt(subLines[0]));
                        }
                        i++;

                        try {
                            line = input.get(i);
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    i--;
                } 
            }
        }

        return directoryTree.calculateTask1();
    }

     private int task_2(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            if (line.startsWith("$")) {
                if (line.substring(2, 4).equals("cd")) {
                    String[] subLines = line.split(" ");
                    directoryTree.moveTo(subLines[2]);

                } else if (line.substring(2, 4).equals("ls") ) {
                    i++;
                    line = input.get(i);
                    while (!line.startsWith("$")) {
                        String[] subLines = line.split(" ");
                        if (subLines[0].equals("dir")) {
                            directoryTree.putDirectory(subLines[1]);
                        } else {
                            directoryTree.putFile(subLines[1], Integer.parseInt(subLines[0]));
                        }
                        i++;

                        try {
                            line = input.get(i);
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    i--;
                } 
            }
        }

        return directoryTree.calculateTask2();
    }
}