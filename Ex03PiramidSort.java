import java.util.Arrays;
import java.util.Scanner;

//3*. Реализовать алгоритм пирамидальной сортировки (HeapSort).
public class Ex03PiramidSort {
    public static void main(String[] args) {
//
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter array size: ");
        int size = in.nextInt();
//
        System.out.printf("Your random array: ");
        System.out.println(Arrays.toString(geberateInArray(size)));
        Integer[] arr = geberateInArray(size);
        in.close();

        piramidalSort(arr);
        System.out.printf("Sorted with heap sort: ");
        System.out.println(Arrays.toString(arr));
    }
//Разбитие на детей и сбор детей.
    private static void piramidalSort(Integer[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }
//Сортировка детей.
    private static void heapify(Integer[] arr, int i, int len) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < len && arr[l] > arr[largest])
            largest = l;
        if (r < len && arr[r] > arr[largest])
            largest = r;

        if (i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, len);
        }
    }
    public static Integer[] geberateInArray(int arrSize) {
        Integer[] array;
        array = new Integer[arrSize];
        for (int i = 0; i < arrSize; i++) {
            array[i] = ((int)(Math.random() * 200) -100);
        }
        return array;
    }
}
