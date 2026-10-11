import java.util.Arrays;

public class ArrayHandler {
    private int[] array;
    private int size;
    private int capacity;

    public ArrayHandler(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Error: Array is full!");
            return;
        }
        array[size++] = value;
        System.out.println("Inserted " + value + " into array.");
    }

    public void delete(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            System.out.println("Deleted " + value + " from array.");
        } else {
            System.out.println("Value " + value + " not found in array.");
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int linearSearch(int target) {
        System.out.println("Running Linear Search...");
        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                System.out.println("Found " + target + " at index " + i + ".");
                return i;
            }
        }
        System.out.println("Value " + target + " not found.");
        return -1;
    }

    public int binarySearch(int target) {
        System.out.println("Running Binary Search... (Sorting array first)");
        int[] sortedArray = Arrays.copyOf(array, size);
        Arrays.sort(sortedArray);
        int left = 0, right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == target) {
                System.out.println("Found " + target + " in sorted array.");
                return mid;
            }
            if (sortedArray[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println("Value " + target + " not found.");
        return -1;
    }
}
