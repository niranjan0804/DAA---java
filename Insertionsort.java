import java.io.*;
import java.util.*;

public class Insertionsort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("Enter how many numbers to randomly generate : ");
        int c = s.nextInt();
        for (int i = 0; i < c; i++) {
            int n = (int) (100000 * Math.random());
            arr.add(n);
        }
        System.out.println("ArrayList before writing to file :\n" + arr+"\n");


        ArrayList<Integer> b = new ArrayList<Integer>();
        try {
            File f = new File("abc.txt");
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(arr);
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            b = (ArrayList<Integer>) oi.readObject();
            oo.close();
            oi.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Arraylist after retrieving from file :\n"+b+"\n");

        ArrayList<Integer> sarr = insertionSort(b);
        System.out.println("Arraylist sorted using insertion sort : \n"+sarr+"\n");
    }
    
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arr)
    {
        for(int i = 1 ; i<arr.size() ; i++)
        {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
        return arr;
    }
    
}
