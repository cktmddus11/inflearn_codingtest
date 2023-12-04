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
 * => N번의 반복만 발생하도록 풀기
 */
public class Solution2 {
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
        for(int i = 0;i< k;i++){
            maxSum += arr[i];
        }

        int sum = maxSum;
        for(int i = 1;i<n;i++){
            if(i+k > n){
                break;
            }
            sum = sum - arr[i-1] + arr[i+k-1];
           // System.out.println(sum);
            maxSum = Math.max(sum, maxSum);
        }

        answer = maxSum;
        return answer;
    }
}
