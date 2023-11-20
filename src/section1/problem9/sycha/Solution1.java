package section1.problem9.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem9.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        Cha       최초 생성
 *
 * 9. 숫자만 추출
 * 설명
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 *
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        int answer = solution(str);
        System.out.println(answer);
    }

    private static int solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){

            char c = str.charAt(i);
            if(c >= 48 && c <= 57){
               // System.out.println(c);
                sb.append(c);
            }

        }
        return Integer.parseInt(sb.toString());
    }
}
