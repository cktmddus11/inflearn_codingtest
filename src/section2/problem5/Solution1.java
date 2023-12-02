package section2.problem5;

import java.util.Scanner;

/**
 * packageName    : section2.problem5
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }
    private static int solution(int n) {
        int answer = 0;
        for(int i = 2;i<=n;i++){
          //  boolean isPrimeNumber = false;
            int cnt = 0;
            for(int z = 2;i<=Math.sqrt(n);z++){
                if(i % z ==  0){
                    cnt++;
                }
            }
            if(cnt == 1){
               // isPrimeNumber = false;
                answer++;
            }
        }
        return answer;
    }
}
