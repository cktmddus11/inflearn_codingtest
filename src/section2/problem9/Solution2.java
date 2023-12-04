package section2.problem9;

import java.util.Scanner;

/**
 * packageName    : section2.program10
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-12-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        int answer = solution(arr);
        System.out.println(answer);

    }

    private static int solution(int[][] arr) {
        int sum = 0;

        // 행, 열 합
        for (int i = 0; i < arr.length; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < arr.length; j++) {
                rowSum += arr[i][j]; // 행 sum
                colSum += arr[j][i]; // 열 sum
            }
            sum = Math.max(rowSum, sum); // (a >= b) ? a : b;
            sum = Math.max(colSum, sum); // (a >= b) ? a : b;

        }
        
        // 대각선 합
        int leftDiagonalSum  = 0;
        int rightDiagonalSum  = 0;

        for (int i = 0; i < arr.length; i++) {
            leftDiagonalSum +=  arr[i][i];
            rightDiagonalSum += arr[i][arr.length - i -1];
        }
        sum = Math.max(sum, leftDiagonalSum);
        sum = Math.max(sum, rightDiagonalSum);


        return sum;
    }

}
