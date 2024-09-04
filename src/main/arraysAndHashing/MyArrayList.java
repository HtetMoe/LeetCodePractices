package main.arraysAndHashing;

import java.util.Arrays;

public class MyArrayList {
    private final int INITIAL_LENGTH = 2; //default size
    private String[] arr;
    private int size;

    //constructor
    public MyArrayList() {
        arr = new String[INITIAL_LENGTH];
        size = 0;
    }

    //1 => add
    public void add(String s) {
        if (s == null) return;
        if (size == arr.length) resize(); // Array is full
        arr[size++] = s;
    }

    //2 => resize
    private void resize() {
        System.out.println("do resize");
        int newlen = 2 * arr.length;
        arr = Arrays.copyOf(arr, newlen); // also copy the value
    }

    //3 => remove by passing object
    public boolean remove(String s) {
        if (size == 0 || s == null) return false; // the list is empty

        int index = -1;
        for (int i = 0; i < size; i++) { // size ***
            if (arr[i].equals(s)) {
                index = i;
                break; // within if
            }
        }

        if (index == -1) return false; // s is not found in the list

        // 0 1 2 3 4 5 6 7 // want to remove index 3 as index
        // 1st copy -> arr,0, temp, 0, index
        // size = 8 strings
        // 8 - (index + 1) = 4; // you need to copy only 4

        //update the list
        String[] temp = new String[arr.length]; //all values are null
        System.arraycopy(arr, 0, temp, 0, index); //1st copy = copy before removed index
        System.arraycopy(arr, index + 1, temp, index, arr.length - (index + 1)); // 2nd copy =  copy after removed index

        arr = temp;
        --size;

        return true;
    }

    //4 => get
    public String get(int index) {
        if (index < 0 || index > size - 1) return null;
        return arr[index];
    }

    //5 => find
    public boolean find(String s) {
        if (s == null) return false;

        for (String string : arr) {
            if (s.equals(string)) return true;
        }
        return false; // The element is not in the list
    }

    //6 => insert
    public void insert(String s, int pos) {
        if (pos < 0 || pos > size) return;

        if (pos == arr.length)  // If the array gets full
            resize();

        // a b c d e f // insert pos 2
        // a b A c d e f

        String[] temp = new String[arr.length];
        for (int i = 0; i < pos; i++) // copy the items before pos
            temp[i] = arr[i];

        temp[pos] = s; // insert at pos

        for (int i = pos + 1; i < arr.length; i++)
            temp[i] = arr[i - 1]; // index is now at (pos+1), value in original array is from (pos+1) - 1

        arr = temp;
        ++size;
    }

    //7 => print out
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            if( s != null)
                sb.append(s).append(", ");
        }
        if(!sb.isEmpty()) sb.setLength(sb.length() - 2);
        return !sb.isEmpty() ? sb.toString() : "Empty ArrayList!";
    }

    // 8 => size
    public int getSize() {
        return size;
    }

    // 9 => isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        //add
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(STR."size:\{list.getSize()}, \{list}");
        System.out.println();

        list.insert("moe", 4);
        System.out.println(STR."size:\{list.getSize()}, \{list}");
        System.out.println();

        //insert between
        list.insert("amour", 1);
        System.out.println(STR."list : \{list}");
        System.out.println();

        //size
        System.out.println(STR."size => \{list.getSize()} is \{list}");
        System.out.println();

        //remove;
        System.out.println(STR."size => \{list.getSize()} is \{list}");
    }
}
