package section6.problem10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section6
 * fileName       : Solution10
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
        /*int N = 5;
        int C = 3;

        int arr[] = {3,4,7,8,9};*/
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int C = scan.nextInt();
        int arr[] = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = scan.nextInt();
        }

        int answer = solution(N, C, arr);
        System.out.println(answer);
    }

    private static int solution(int n, int c, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int left = 1;
        int right = arr[n-1];

        answer = binarySearch(answer, left, right, c, arr);
        return answer;
    }

    private static int binarySearch(int answer, int left, int right, int c, int[] arr) {
        if (left >  right) {
            return answer;
        }
        int middle = (left + right) / 2;
       // System.out.println(middle);
        int cnt = count(arr, middle);

        if(cnt < c){ // 거리만큼 마구간을 둘수 없으면
            right = middle -1;
        }else{ // 거리만큼 마구간을 둘 수 있으면
            left = middle +1;
            answer = answer != 0 ? Math.max(answer, middle) : middle;
        }
        return binarySearch(answer, left, right, c, arr);
    }

    private static int count(int[] arr, int middle) {
        int cnt = 1;
        int idx = 0;
        for(int i = 1; i< arr.length; i++){
            if(arr[i]- arr[idx] >= middle){
                cnt++;
                idx = i;
            }
        }
        return cnt;
    }
}
