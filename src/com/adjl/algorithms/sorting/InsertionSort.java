package com.adjl.algorithms.sorting;

public class InsertionSort {

    public static void insertionSort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int key = items[i];
            int j;
            for (j = i - 1; j >= 0 && items[j] > key; j--) {
                items[j + 1] = items[j];
            }
            items[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] items = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        insertionSort(items);
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
