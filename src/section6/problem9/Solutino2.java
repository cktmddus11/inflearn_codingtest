package section6.problem9;

import java.util.Arrays;

/**
 * packageName    : section6.problem9
 * fileName       : Solutino2
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 */
public class Solutino2 {
    public static void main(String[] args) {
        int N = 9;
        int M = 3;

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int answer = solution(N,M, arr);
        System.out.println(answer);
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m){
                answer = mid;
                rt = mid - 1;
            }else lt = mid + 1;
        }
        return answer;
    }

    private static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x;
            }else sum += x;
        }
        return cnt;
    }
}
