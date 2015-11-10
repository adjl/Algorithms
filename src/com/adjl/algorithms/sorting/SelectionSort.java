package com.adjl.algorithms.sorting;

public class SelectionSort {

    public static void selectionSort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i; j < items.length; j++) {
                if (items[j] < min) {
                    min = items[j];
                    minIndex = j;
                }
            }
            swap(items, i, minIndex);
        }
    }

    public static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        int[] items = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        selectionSort(items);
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
