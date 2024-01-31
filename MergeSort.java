import java.io.*;
import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("Enter how many numbers to randomly generate: ");
        int c = s.nextInt();
        for (int i = 0; i < c; i++) {
            int n = (int) (100000 * Math.random());
            arr.add(n);
        }
        System.out.println("ArrayList before writing to file:\n" + arr + "\n");

        ArrayList<Integer> b = new ArrayList<Integer>();
        try {
            File f = new File("abc.txt");
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(arr);
            oo.close();

            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            b = (ArrayList<Integer>) oi.readObject();
            oi.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Arraylist after retrieving from file:\n" + b + "\n");

        mergeSort(b, 0, b.size() - 1);
        System.out.println("Arraylist sorted using merge sort:\n" + b + "\n");
    }

    public static void mergeSort(ArrayList<Integer> arr, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr.get(i) <= arr.get(j)) {
                b.add(arr.get(i));
                i++;
            } else {
                b.add(arr.get(j));
                j++;
            }
        }

        while (i <= mid) {
            b.add(arr.get(i));
            i++;
        }

        while (j <= high) {
            b.add(arr.get(j));
            j++;
        }

        int c = 0;
        for (int e : b) {
            arr.set(low + c, e);
            c++;
        }
    }
}
