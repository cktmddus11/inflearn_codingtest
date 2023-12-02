package section2.program9;

import java.util.Scanner;

/**
 * packageName    : section2.program10
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        Cha       최초 생성
 */
public class Solution1 {
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
        // 행 합
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < arr.length; j++) {
                tempSum += arr[i][j];
            }
            if (tempSum > sum) {
                sum = tempSum;
            }
        }
       // System.out.println(sum);
        // 열합
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < arr.length; j++) {
                tempSum += arr[j][i];
            }
            if (tempSum > sum) {
                sum = tempSum;
            }
        }
     //   System.out.println(sum);

        // 대각선합
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i][i];
            if (tempSum > sum) {
                sum = tempSum;
            }
        }
      //  System.out.println(sum);


        tempSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            tempSum += arr[i][i];
            if (tempSum > sum) {
                sum = tempSum;
            }
        }
      //  System.out.println(sum);


        return sum;
    }


}
