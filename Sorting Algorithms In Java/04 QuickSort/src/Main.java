import java.util.Scanner;
class QuickSort{
public int Partition(int [] arr,int low,int high)
{
int start=low;
int end=high;
int pivot=arr[low];
while(start<end)
{
    while(arr[start]<=pivot)
    {
        start++;
    }
    while(arr[end]>pivot)
    {
        end--;
    }
    if(start<end){
    int temp=arr[start];
    arr[start]=arr[end];
    arr[end]=temp;}
}
    arr[low]=arr[end];
    arr[end]=pivot;
    return end;
}
public void sort(int []arr,int low,int high)
{
    if(low<high){
    int partition=Partition(arr,low,high);
    sort(arr, low, partition-1);
    sort(arr, partition+1, high);
}}
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
        
        QuickSort qs=new QuickSort();      
        
        qs.sort(array, 0, array.length-1);        
        
        System.out.println("\nAfter Sorting ");
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}