package section3.problem3;

import java.util.Scanner;

/**
 * packageName    : section3.problem3
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-04        Cha       최초 생성
 *
 * => 아래처럼 풀면 N * K 번의 반복발생으로 시간 초과처리됨.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int answer = solution(arr, n, k);
        System.out.println(answer);
    }

    private static int solution(int[] arr, int n, int k) {
        int answer = 0;

        int maxSum = 0;
        for(int i = 0;i<n;i++){
            int sum = 0;

            if(i+k > n){
                break;
            }
            for(int j = i;j<i+k;j++){
                sum += arr[j];

            }
            maxSum = Math.max(sum, maxSum);
          //  System.out.println(maxSum);
        }

        answer = maxSum;
        return answer;
    }
}
