
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main t = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i =0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
//        System.out.println(t.solution14(n,m,arr));
//        t.solution4(n);
    }

}