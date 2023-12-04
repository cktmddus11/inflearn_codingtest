package section3.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section3
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-04        Cha       최초 생성
 * <p>
 * 퀵정렬 : O(NlogN)
 * =>
 * O(N) 으로 풀도록 하기..
 * TODO 다시풀기
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scan.nextInt();
        }
        int answer[] = solution(n, arr1, m, arr2);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int index1 = 0;
        int index2 = 0;

        int i = 0;
        int[] answer = new int[n + m];
        while (index1 < n && index2 < m) { // 둘중 한 배열이라도 합치는게 끝나면(인덱스벗어나면) 종료됨.
            if (arr1[index1] < arr2[index2]) {
                answer[i] = arr1[index1++];
            } else {
                answer[i] = arr2[index2++];
            }
            i++;
        }
        while (index1 < n) { // 나머지 배열을 합침
            answer[i] = arr1[index1++];
        }
        while (index2 < m) { // 나머지 배열을 합침
            answer[i++] = arr2[index2++];
        }

        return answer;
    }
}
