import java.util.*;
public class hourGlassSum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter row value: ");
        int row = sc.nextInt();
    
        System.out.print("Enter column value: ");
        int col = sc.nextInt();

        int[][] matrix = new int[row][col];

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                System.out.println("Enter value for " + i + "" + j + " data: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i <= row - 3;i++){
            for(int j = 0;j <= col - 3;j++){
                int sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i+1][j+1]
                + matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];

                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }
}