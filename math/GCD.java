import java.util.*;
public class GCD{
    static int getGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for(int i = 0;i < size;i++){
            System.out.print("Enter value: ");
            arr[i] = sc.nextInt();
        }

        int result = arr[0];
        
        for(int i = 0;i < size;i++){
            result = getGCD(result, arr[i]);

            if(result == 1) break;
        }

        System.out.println(result);
    }
}
