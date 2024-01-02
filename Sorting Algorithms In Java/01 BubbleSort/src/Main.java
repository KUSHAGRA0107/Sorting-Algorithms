import java.util.Scanner;
class BubbleSort
{
    public void sort(int [] array,int n)
    {
        for(int i=0;i<=n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
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

        BubbleSort bs=new BubbleSort();

        bs.sort(array,array.length);

        System.out.println("\nAfter Sorting ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}