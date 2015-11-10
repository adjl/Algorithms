package com.adjl.algorithms.searching;

public class BinarySearch {

    public static int binarySearch(int key, int[] items) {
        return binarySearch(key, items, 0, items.length - 1);
    }

    public static int binarySearch(int key, int[] items, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (key < items[mid]) {
            return binarySearch(key, items, low, mid - 1);
        } else if (key > items[mid]) {
            return binarySearch(key, items, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] items = new int[] { 9, 18, 27, 36, 45, 54, 63, 72, 81, 90 };
        System.out.println(binarySearch(0, items));
        System.out.println(binarySearch(9, items));
        System.out.println(binarySearch(54, items));
        System.out.println(binarySearch(90, items));
    }
}
