package com.adjl.algorithms.sorting;

public class Quicksort {

    public static void quicksort(int[] items) {
        quicksort(items, 0, items.length - 1);
    }

    public static void quicksort(int[] items, int low, int high) {
        if (low < high) {
            int pivot = partition(items, low, high);
            quicksort(items, low, pivot - 1);
            quicksort(items, pivot + 1, high);
        }
    }

    public static int partition(int[] items, int low, int high) {
        int pivot = low;
        for (int i = low; i < high; i++) {
            if (items[i] <= items[high]) {
                swap(items, i, pivot++);
            }
        }
        swap(items, high, pivot);
        return pivot;
    }

    public static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        int[] items = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        quicksort(items);
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
