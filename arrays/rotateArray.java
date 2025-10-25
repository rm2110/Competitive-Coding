import java.util.*;
public class rotateArray{
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
        
        System.out.print("Enter block value: ");
        int k = sc.nextInt();
        int blockArr[] = new int[k];

        for(int i = 0;i < k;i++){
            blockArr[i] = arr[i];
        }

        int p = k;
        for(int i = 0;i < size;i++){
            if(p < size){
                arr[i] = arr[p];
                p++;
            }
        }

        int j = 0;
        for(int i = size - k;i < size;i++){
            arr[i] = blockArr[j];
            j++;
        }

        System.out.println("Rotated array is");
        for(int i = 0;i < size;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
