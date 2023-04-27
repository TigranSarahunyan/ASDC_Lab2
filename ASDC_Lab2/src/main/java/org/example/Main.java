package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        File fileToRead = new File("src/MOCK_DATA.csv");
        ArrayList<Student> list = Student.readingFromFile(fileToRead);

        Collections.shuffle(list);
        long before = System.nanoTime();
        Info infoBubble = AlgorithmsOfSorting.bubble(list);
        long after = System.nanoTime();
        System.out.println("\nbubble sort");
        System.out.println("Number of compares - " + infoBubble.compares);
        System.out.println("Number of swaps - " + infoBubble.swaps);
        System.out.println("Time for sorting in nanos - " + (after - before));

        Collections.shuffle(list);
        before = System.nanoTime();
        Info infoInsertion = AlgorithmsOfSorting.insertion(list);
        after = System.nanoTime();
        System.out.println("\nInsertion sort");
        System.out.println("Number of compares - " + infoInsertion.compares);
        System.out.println("Number of swaps - " + infoInsertion.swaps);
        System.out.println("Time for sorting in nanos - " + (after - before));

        Collections.shuffle(list);
        before = System.nanoTime();
        Info infoQuick = new Info();
        AlgorithmsOfSorting.quick(list,0,list.size()-1,infoQuick);
        after = System.nanoTime();
        System.out.println("\nQuick sort");
        System.out.println("Number of compares - " + infoQuick.compares);
        System.out.println("Number of swaps - " + infoQuick.swaps);
        System.out.println("Time for sorting in nanos - " + (after - before));
    }
}