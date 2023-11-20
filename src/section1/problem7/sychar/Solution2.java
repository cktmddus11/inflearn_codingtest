package section1.problem7.sychar;

import java.util.Scanner;

/**
 * packageName    : section1.problem7.sychar
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
        String word = scan.next();


        String  answer = solution(word);
        System.out.println(answer);
    }

    private static String solution(String word) {
        String reverseStr = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reverseStr) ? "YES" : "NO"; // equalsIgnoreCase 대소문자 무시
    }
}
