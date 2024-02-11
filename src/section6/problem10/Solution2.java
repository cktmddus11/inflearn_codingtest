package section6.problem10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section6.problem10
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int C = scan.nextInt();

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] += scan.nextInt();
        }

        int answer = solution(N, C, arr);
        System.out.println(answer);

    }

    private static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;

        }
        return answer;
    }

    private static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i =1;i<arr.length;i++){
            if(arr[i] -ep >= dist) {
                cnt ++;
                ep = arr[i];
            }
        }
        return cnt;
    }
}
