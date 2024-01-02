package section3.problem4;

import java.util.Scanner;

/**
 * packageName    : section3.problem4
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31        Cha       최초 생성
 *
 *
 * 4. 연속 부분수열
 * => time limit exception
 *
 *
 */
public class Solution2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = scan.nextInt();
        }
       int answer = solution(n, m, arr);
        System.out.println(answer);
    }

    public static int solution(int n, int m, int[] arr ){
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for(int rt = 0;rt < n;rt++){
            sum += arr[rt];
            if(sum == m) answer++;
            while(sum >= m){
                sum -= arr[lt];
                lt++;
                if(sum == m){
                    answer++;
                }
            }
        }

        return answer;
    }
}
