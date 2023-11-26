package section1.problem12.sycha;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section1.problem12.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 *
 * 12. 암호
 * - 알파벳하나당 7개문자
 * - # => 이진수 1
 * - 0 => 이진수 0
 *
 *
 * 진수 변환
 * 10진수 => 2진수
 * Integer.toBinaryString(int i)
 *
 *
 * 2진수 => 10진수 
 * Integer.parseInt(2진수문자열, 2);
 * https://dpdpwl.tistory.com/92
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int strCnt = scan.nextInt(); // 보낸 문자 개수
        String str = scan.next(); // 문자의 개수의 일곱배만큼의 #, * 신호


        String answer = solution(strCnt, str);
        System.out.println(answer);

    }

    private static String solution(int strCnt, String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<strCnt;i++){
            String tempStr = str.substring(i*7, (i*7)+7);

            // 1번 - 7자리문자를 이진수로 바꾸기. # 1, * 0
            tempStr = tempStr.replace("#", "1").replace("*", "0");
         //   System.out.println(tempStr);
            // 2. 바뀐 2진수를 10진수화 합니다.
            int decimal = Integer.parseInt(tempStr, 2);
        //    System.out.println(decimal);
            // 3. 아스키 번호가 65문자로 변환합니다.
            char asciiCode = (char) decimal;
       //     System.out.println(asciiCode);

            String signal = String.valueOf(asciiCode);
            sb.append(signal);
        }
        return sb.toString();
    }
}
