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
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = scan.nextInt();
        }
       int answer = solution(m, arr);
        System.out.println(answer);
    }

    public static int solution(int m, int[] arr ){
        int answer = 0;
        for(int i = 0;i<arr.length;i++){
            int sum = 0;
            for(int j = i;j<arr.length;j++){
                sum += arr[j];
                // System.out.print(arr[j]+" ");
                if(sum > m){
                    //System.out.println();
                    break;
                }else if(sum == m){
                    answer++;
                    //System.out.println();
                    break;
                }else if (sum < m && j+1 == arr.length){
                   // System.out.println();
                    break;
                }
            }
        }


        return answer;
    }
}
