package day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;


/**
 * A Tree implementation that represents the file hierarchy
 */
public class Tree {

    private Directory root;
    private Directory current;
    private int task1Count = 0;

    private class Node {
        int size = 0;
        String name;
        boolean isExplored = false;

        private int getSize() {
            return size;
        }
    }

    private class Directory extends Node{
        private Directory parent;
        private Map<String, Node> children;

        private Directory(String name, Directory parent) {
            this.size = 0;
            this.name = name;
            this.children = new HashMap<>();
            this.parent = parent;
        }

        private void add(Node file) {
            children.put(file.name, file);
            updateSizes(file.size);
        }

        private void updateSizes(int size) {
            Directory temp = this;

            while (temp != null) {
                temp.size += size;
                temp = temp.parent;
            }
        }

        private Directory getDirectory(String name) {
            return (Directory) children.get(name);
        }
    }

    private class File extends Node{

        private File(String name, int size) {
            this.name = name;
            this.size = size;
        }
    }

    public Tree() {
        this.root = new Directory("/", null);
        this.current = root;
    }

    public void putDirectory(String name) {
        current.add(new Directory(name, current));
    }

    public void putFile(String name, int size) {
        current.add(new File(name, size));
    }

    public void moveTo(String directoryName) {
        if (directoryName.equals("..")) {
            current = current.parent;
        } else if (directoryName.equals("/")) {
            current = root;
        } else {
            current = current.getDirectory(directoryName);
        }
    }

    public int calculateTask2() {
        return BFS2(root, 30000000 - (70000000 - root.size));
    }

    public int calculateTask1() {
        BFS(root);
        return task1Count;
    }


    private int BFS2(Node root, int required) {
        int result = 700000000;
        Queue<Node> q = new LinkedList<>();
        root.isExplored = true;
        q.add(root);

        while (!q.isEmpty()) {
            Node v = q.remove();

            if (v instanceof Directory) {
                if (v.size >= required && v.size < result) {
                    result = v.size;
                } 
            }
            
            if (v instanceof Directory) {
                Directory dir = (Directory) v;

                for (Node w : dir.children.values()) {
                    if (!w.isExplored) {
                        w.isExplored = true;
                        q.add(w);
                    }
                }
            }
        }

        return result;
    }

    private void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        root.isExplored = true;
        q.add(root);

        while (!q.isEmpty()) {
            Node v = q.remove();
            if (v.size <= 100000) {
                if (v instanceof File) {
                    if (!v.isExplored) {
                        v.isExplored = true;
                        task1Count += v.size;
                    }
                } else {
                    task1Count += v.size;
                }
            }


            if (v instanceof Directory) {
                Directory dir = (Directory) v;

                for (Node w : dir.children.values()) {
                    if (!w.isExplored) {
                        w.isExplored = true;
                        q.add(w);
                    }
                }
            }
        }
    }
}
