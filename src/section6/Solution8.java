package section6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section6
 * fileName       : Solution8
 * author         : Cha
 * date           : 2024-01-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        Cha       최초 생성
 */
public class Solution8 {
    public static void main(String[] args) {
       /* int N = 7;
        int M = 3;

        int arr[] = {
               3, 5, 14,  53, 43, 17,  56
        };*/
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int [] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = scanner.nextInt();
        }
        int answer = solution(arr, N, M);

        System.out.println(answer);

    }

    private static int solution(int[] arr, int n, int m) {
        int answer = -1;
        Arrays.sort(arr);
       // System.out.println(Arrays.toString(arr));
        answer = find(arr, m, 0, n - 1);

        return answer;
    }

    private static int find(int[] arr, int m, int firstIdx, int endIdx) {
        int middle = (firstIdx + endIdx) / 2;

        if (arr[middle] == m) {
            return middle + 1; // 위치를 리턴하므로 +1
        } else {
            if (arr[middle] > m) { // 왼쪽 탐색
                return find(arr, m, firstIdx, middle - 1);
            } else { // 오른쪽 탐색
                return find(arr, m, middle + 1, arr.length - 1);
            }
        }
    }
}
