package section1.problem2.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem2.sycha
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-14        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.next();
        String answer = solution(input1);
        System.out.println(answer);
    }

    /*
    아스키코드(ASCII 코드)
    * 영어 대문자(A-Z): 65(A) ~ 90(Z)
      영어 소문자(a-z): 97(a) ~ 122(z)
    *   대문자 + 32 => 소문자
    * */
    public static String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) { // 대문자이면
                answer += (char) (c + 32);
            } else {
                answer += (char) (c - 32);
            }
        }

        return answer;
    }
}
