import java.util.Scanner;
class Shell_Sort{
    int [] arr;
    public Shell_Sort(int [] arr){
        this.arr=arr;
    }
 
    void sort(){
        int n=arr.length;
        for(int gap=n/2;gap>=1;gap=gap/2){
            for(int j=gap;j<n;j++){
                for(int i=j-gap;i>=0;i=i-gap){
                    if(arr[i+gap]>arr[i]){
                        break;
                    }else{
                        int swap=arr[i+gap];
                        arr[i+gap]=arr[i];
                        arr[i]=swap;
                    }
                }
            }
        }
    }
}
public class ShellSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter the size of an array to be sorted:");
        int n = sc.nextInt();

        System.out.println("Enter the array values:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("arr[" + i + "]=");
            arr[i] = sc.nextInt();
        }

        Shell_Sort ss = new Shell_Sort(arr);
        ss.sort();

        // Print the Sorted Array
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }
        System.out.println();
    }
}