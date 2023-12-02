package section2.problem4;

import java.util.Scanner;

/**
 * packageName    : section2.problem4
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 *
 * 4. 피보나치 수열
 * 설명
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int answerArr[] = solution(n);
        for(int answer : answerArr){
            System.out.print(answer+" ");
        }


    }
    private static int[] solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for(int i =2;i<n;i++){
            arr[i] = arr[i-2]+arr[i-1];
           // System.out.println(arr[i]);
        }

        return arr;
    }

}
