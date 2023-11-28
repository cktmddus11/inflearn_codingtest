import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
//        int[] arr2 = new int[n];
        for (int i = 0 ; i < m; i++){
            for (int j =0; j < n; j++)
                arr[i][j] = in.nextInt();
        }

    }

}