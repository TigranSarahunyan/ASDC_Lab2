package org.example;

import java.util.ArrayList;

public class AlgorithmsOfSorting {
    public static Info bubble(ArrayList<Student> list) {
        Info info = new Info();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                info.compares++;
                if (list.get(j + 1).getIdnp() < list.get(j).getIdnp()) {
                    info.swaps++;
                    Student swap = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, swap);
                }
            }
        }
        return info;
    }

    public static Info insertion(ArrayList<Student> list){
        Info info = new Info();
        int j;
        for (int i = 1; i < list.size(); i++) {
            Student swap = list.get(i);
            info.compares++;
            for (j = i; j > 0 && swap.getIdnp() < list.get(j-1).getIdnp(); j--) {
                info.swaps++;
                list.set(j,list.get(j-1));
            }
            info.swaps++;
            list.set(j,swap);
        }
        return info;
    }

    public static void quick(ArrayList<Student> list, int low, int high, Info info) {
        info.compares++;
        if (list.size() == 0 || low >= high) return;
        int middle = low + (high - low) / 2;
        int border = list.get(middle).getIdnp();
        int i = low, j = high;
        while (i <= j) {
            info.compares++;
            while (list.get(i).getIdnp() < border) i++;
            while (list.get(j).getIdnp() > border) j--;
            info.compares++;
            if (i <= j) {
                info.swaps++;
                Student swap = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swap);
                i++;
                j--;
            }
        }
        info.compares++;
        if (low < j) quick(list, low, j, info);
        info.compares++;
        if (high > i) quick(list, i, high, info);
    }
}
