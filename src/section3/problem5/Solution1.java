package section3.problem5;

import java.util.Scanner;

/**
 * packageName    : section3.problem5
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
       int answer = 0;
        int len = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        int lt = 0;
       int sum = 0;

       int arr[] = new int[len];
       for(int i = 0;i< arr.length;i++){
           arr[i] = i+1;
       }


        for(int rt = 0;rt < len;rt++){
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= arr[lt];
                lt++;
                if(sum == n){
                    answer++;
                }
            }
        }


        return answer;
    }
}
