package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();
    public Solution(int node, List<Solution> edges) throws IOException {
        this.node = node;
        this.edges = edges;
    }

    FileOutputStream fos;

    {
        try {
            fos = new FileOutputStream("graf.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(node);
            oos.writeObject(edges);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}
