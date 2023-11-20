package section1.problem10.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem10.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        Cha       최초 생성
 *
 * 10. 가장 짧은 문자거리
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면
 * 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str[] = scan.nextLine().split(" ");

        String input1 = str[0];
        String input2 = str[1];

        String answer = solution(input1, input2);
        System.out.println(answer);
    }

    private static String solution(String input1, String input2) {
        StringBuilder sb = new StringBuilder();

        int arr[] = new int[input1.length()];
        for(int i  = 0;i<arr.length;i++){
            String temp = input1.substring(0, i + 1);
            arr
        }



        return sb.toString();
    }
}
