package section1.problem11.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem11.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        Cha       최초 생성
 * <p>
 * 11. 문자열 압축
 * 설명
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 */
// TODO 다시 풀문제
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        String answer = solution(str);
        System.out.println(answer);

    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();


        int p = 0;
        char temp = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == temp) {
                p++;
            } else {
                sb.append(temp);
                if (p > 1) {
                    sb.append(p);
                }
                p = 1;
            }
            temp = str.charAt(i);
        }
        sb.append(temp);
        if(p > 1){
            sb.append(p);
        }

        return sb.toString();
    }
}
