package section1.problem11.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem11.sycha
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        String answer = solution(str);
        System.out.println(answer);
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();


        int cnt = 1;
        String s = str + " "; // 마지막을 처리하기 위해 빈문자 추가?

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                sb.append(s.charAt(i));
                if (cnt > 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }

        }

        return sb.toString();
    }
}
