package section2.problem1;

import java.util.Scanner;

/**
 * packageName    : section2.problem1
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }

        String answer = solution(n, arr);
        System.out.println(answer);

    }

    private static String solution(int n, int[]arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]+" ");

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] >= arr[i-1]){
                sb.append(arr[i]+" ");
            }
        }

        return sb.toString();
    }
}
