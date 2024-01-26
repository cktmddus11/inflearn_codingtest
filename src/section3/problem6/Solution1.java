package section3.problem6;

import java.util.Scanner;

/**
 * packageName    : section3.problem6
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31        Cha       최초 생성
 *
 * 6. 최대 길이 연속부분수열
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = scan.nextInt();
        }
        int answer = solution(n, k, arr);
        System.out.println(answer);
    }
    public static int solution(int n, int k, int[] arr ) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        int len = 0;
        int cng = 0;
        for(int rt = 0;rt<n;rt++){
          /*  if {
                if(len <= rt){

                }
            }*/
            while(cng <= k){
                if(arr[rt] == 0){
                    arr[rt] = 1;
                }
            }
            lt = rt;
        }

        return 0;
    }
}
