package com.adjl.algorithms.sorting;

public class MergeSort {

    public static int[] mergeSort(int[] items) {
        if (items.length == 1) return items;
        int[] low = mergeSort(makeArray(items, 0, items.length / 2));
        int[] high = mergeSort(makeArray(items, items.length / 2, items.length));
        return merge(low, high);
    }

    public static int[] makeArray(int[] items, int start, int end) {
        int[] newItems = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            newItems[i] = items[i + start];
        }
        return newItems;
    }

    public static int[] merge(int[] low, int[] high) {
        int r = 0, l = 0, h = 0;
        int[] result = new int[low.length + high.length];
        while (l < low.length && h < high.length) {
            result[r++] = (low[l] <= high[h]) ? low[l++] : high[h++];
        }
        while (l < low.length) {
            result[r++] = low[l++];
        }
        while (h < high.length) {
            result[r++] = high[h++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] items = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        for (int item : mergeSort(items)) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
