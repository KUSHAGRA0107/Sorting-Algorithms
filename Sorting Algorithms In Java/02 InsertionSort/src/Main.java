import java.util.Scanner;
class InsertionSort{
    public void sort(int [] array)
    {
        for(int i=1;i<=array.length-1;i++)
        {
            int key=array[i];
            int j=i-1;
            while (j>=0 && key<array[j])
            {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Size of Array ");

        int n=sc.nextInt();

        int [] array=new int[n];

        for (int i = 0; i < n; i++) {

            System.out.printf("Enter %d element ",i+1);
            array[i]=sc.nextInt();
        }

        System.out.println("Array Before Sort ");
        for (int i : array) {
            System.out.print(i+" ");
        }

        InsertionSort is=new InsertionSort();

        is.sort(array);

        System.out.println("\nAfter Sorting ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}