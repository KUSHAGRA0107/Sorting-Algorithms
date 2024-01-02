import java.util.Scanner;
class RadixSort
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

        public void Countsort(int [] array,int exp)
        {
            int min = minimum(array);

            for(int i=0;i<array.length;i++)
            {
                array[i]=array[i]+Math.abs(min);
            }

            int max=maximum(array);

            int [] frequency=new int[10];

            int [] temp=new int [array.length];

            for (int i = 0; i < array.length; i++) {
                frequency[(array[i]/exp)%10]++;
            }

            for (int i=1;i<frequency.length;i++)
            {
                frequency[i]=frequency[i]+frequency[i-1];
            }

            for(int i=array.length-1;i>=0;i--)
            {
                temp[--frequency[(array[i]/exp)%10]]=array[i];
            }

            for(int i=0;i<array.length;i++)
            {
                array[i]=temp[i]-Math.abs(min);
            }
        }
        public void sort(int [] array)
        {
            int max=maximum(array);
            for(int exp=1;max/exp>0;exp=exp*10)
            {
                Countsort(array,exp);
            }
        }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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

        RadixSort rs=new RadixSort();

        rs.sort(array);

        System.out.println("\nAfter Sorting ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}