import java.util.*;
public class maxProdSub{
    static int maxProd(int[] arr, int size){
        int front = 1;
        int back = 1;
        int max = arr[0];

        for(int i = 0;i < size;i++){
            front *= arr[i];
            back *= arr[size - 1 - i];

            max = Math.max(max, Math.max(front, back));

            if(back == 0) back = 1;
            if(front == 0) front = 1;
        }
        return max;
    }
    

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        int val;
        for(int i = 0;i < size;i++){
            System.out.print("Enter value: ");
            val = sc.nextInt();
            arr[i] = val;
        }

        int ans = maxProd(arr,size);
        System.out.println(ans);
    }
}