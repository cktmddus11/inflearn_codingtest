package section2.problem5;

import java.util.Scanner;

/**
 * packageName    : section2.problem5
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-27        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
        int cnt = 0;
        int arr[] = new int[n+1];

        for(int i = 2;i<=n;i++){
            if(arr[i] == 0){
               cnt++;

                for(int j = i;j<=n;j+=i){
                    arr[i] = 1;
                    // System.out.println("arr["+j+"]="+arr[i]);
                }
            }
        }

        return cnt;
    }
}
