package section1.problem9.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem9.sycha
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        int answer = solution(str);
        System.out.println(answer);
    }

    private static int solution(String str) {
        String s = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(s);
    }
}
