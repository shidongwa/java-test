package com.stone.javacore.sort;

import java.util.Arrays;

/**
 * sort names by height in DESC way; height values are distinct but name could be same
 * there are two approaches:
 * 1, implement Comparable interface
 * 2, pass Comparator lambda expression to Arrays.sort method
 */
public class SortPair {

    public static void main(String[] args) {
        String[] names = new String[]{"Mary", "John", "Emma"};
        int[] heights = new int[] {180, 165, 170};

        System.out.println("Before sort:" + Arrays.toString(names));
        names = new SortPair().sortPeople(names, heights);
        System.out.println("After sort:" + Arrays.toString(names));
    }


    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        NameHeight[] arr = new NameHeight[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new NameHeight(names[i], heights[i]);
        }
        Arrays.sort(arr, (o1, o2) -> o2.getHeight() - o1.getHeight());
       // System.out.println(Arrays.toString(arr));
        // Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        return Arrays.stream(arr).map(o -> o.getName()).toArray(String[]::new);
    }

    //class NameHeight implements Comparable<NameHeight> {
    class NameHeight  {
        private String name;
        private int height;
        public NameHeight(String name, int height) {
            this.name = name;
            this.height = height;
        }
        public int getHeight() {
            return this.height;
        }
        public String getName() {
            return this.name;
        }

/*        @Override
        public int compareTo(NameHeight o) {
            // NameHeight e = (NameHeight) o;
            return Integer.compare(o.getHeight(), this.height);
        }*/

        public String toString() {
            return this.name;
        }
    }
}
