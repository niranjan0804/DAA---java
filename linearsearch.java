import java.io.*;
import java.util.*;

public class linearsearch {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter how many numbers to randomly generate : ");
        int c = s.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < c; i++) {
            a.add((int) (100 * Math.random()));
        }
        System.out.println("ArrayList before writing to file : " + a);
        ArrayList<Integer> b = new ArrayList<>();
        try {
            FileOutputStream fo = new FileOutputStream("abc.txt");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(a);
            FileInputStream f = new FileInputStream("abc.txt");
            ObjectInputStream oi = new ObjectInputStream(f);
            b = (ArrayList<Integer>) oi.readObject();
            oo.close();
            oi.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("ArrayList after retrieving from file : " + b);
        System.out.println("Enter number to linearly search : ");
        int x = s.nextInt();
        boolean result = lsearch(b, x);
        if (result) {
            System.err.println("Number " + x + " found");
        } else {
            System.err.println("Number " + x + " not found!");
        }

        System.out.println("Enter number to search using binary search");
        x = s.nextInt();
        Collections.sort(b);
        result = binarySearch(b, 0, c - 1, x);
        if (result) {
            System.err.println("Number " + x + " found");
        } else {
            System.err.println("Number " + x + " not found!");
        }
    }

    public static boolean lsearch(ArrayList<Integer> arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(ArrayList<Integer> arr, int low, int high, int num) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (num < arr.get(mid)) {
                return binarySearch(arr, low, mid, num);
            }

            else if (num > arr.get(mid)) {
                return binarySearch(arr, mid, high, num);
            }

            else if (num == arr.get(mid)) {
                return true;
            }
        }
        return false;
    }
}