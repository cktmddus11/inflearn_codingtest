package section6.problem9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section6
 * fileName       : Solution9
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
      /*  int N = 9;// DVD 곡 개수
        int M = 3; // DVD 개수

        // 라이브로 부른 곡의 길이가 분단위로 있는 배열.
        // 순서대로 DVD의 최소 용량만큼 3개의 DVD에 모든 곡을 담아야함.
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};*/

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int [] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = scan.nextInt();
        }
        int answer = solution(N, M, arr);
        System.out.println(answer);

    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int left = arr[n-1];
        int right = Arrays.stream(arr).sum();


        answer = binarySearch(answer, left, right, arr, m);


        return answer;
    }

    private static int binarySearch(int answer,
                                    int left,
                                    int right,
                                    int[] arr,
                                    int m) {
        if (left >  right) {
            return answer;
        }

        int middle = (left + right) / 2;// (left + right) % 2 > 0 ? ((left = right) / 2) +1 : (left + right) /2;
        int cnt = count(arr, middle);

        if (cnt <= m) { // 3 장안에 담을 수 있으면
            answer = answer != 0 ? Math.min(answer, middle) : middle;  // (a <= b) ? a : b
            right = middle - 1;
       //     System.out.println("answer = " +answer);
        } else {
            left = middle +1;
        }
      //  System.out.println("left = "+left+", right = "+right);
        return binarySearch(answer, left, right, arr, m);
    }

    private static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > capacity) {
                sum = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
