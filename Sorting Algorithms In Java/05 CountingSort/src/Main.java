//Our Idea Behind CountSort is to make it work for both positive and negative number
//So we'll calculate minimum element and then sort it and finally in sorted array we'll add mod|minimum element|
import java.util.Scanner;
class CountSort
{
    private int maximum(int [] array)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>max)
            {
                max=array[i];
            }
        }
    return max;
    }

    private int minimum(int [] array)
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]<min)
            {
                min=array[i];
            }
        }
        return min;
    }

    public void sort(int [] array)
    {
        int min = minimum(array);

        for(int i=0;i<array.length;i++)
        {
            array[i]=array[i]+Math.abs(min);
        }

        int max=maximum(array);

        int [] frequency=new int[max+1];

        int [] temp=new int [array.length];

        for (int i = 0; i < array.length; i++) {
            frequency[array[i]]++;
        }

        for (int i=1;i<frequency.length;i++)
        {
            frequency[i]=frequency[i]+frequency[i-1];
        }

        for(int i=array.length-1;i>=0;i--)
        {
            temp[--frequency[array[i]]]=array[i];
        }

        for(int i=0;i<array.length;i++)
        {
            array[i]=temp[i]-Math.abs(min);
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

        CountSort cs=new CountSort();

        cs.sort(array);

        System.out.println("\nAfter Sorting ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}