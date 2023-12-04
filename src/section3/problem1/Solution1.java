package section3.problem1;

import java.util.Arrays;
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
 */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr1 = new int[n];
        for(int i =0;i<n;i++){
            arr1[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] arr2 = new int[m];
        for(int i =0;i<m;i++){
            arr2[i] = scan.nextInt();
        }
        int answer[] = solution(n, arr1, m, arr2);
        for(int i = 0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }

    private static int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int answerLength = n+m;
        int[] answer = new int[answerLength];

        for(int i = 0;i<answerLength;i++){
            if(i < n){
                answer[i] = arr1[i];
            }else{
                answer[i] = arr2[i-n];
            }
        }
       // System.out.println("arr1 + arr2 : "+ Arrays.toString(answer));

        Arrays.sort(answer);


        return answer;
    }
}
