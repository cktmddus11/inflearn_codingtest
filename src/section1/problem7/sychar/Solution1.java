package section1.problem7.sychar;

import java.util.Scanner;

/**
 * packageName    : section1.problem7.sychar
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-16        Cha       최초 생성
 *
 * 7. 회문 문자열
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();


        String  answer = solution(word);
        System.out.println(answer);
    }

    private static String solution(String word) {
        String lowerCaseWord = word.toLowerCase();
        String reverseWord = new StringBuilder(lowerCaseWord).reverse().toString();

        return lowerCaseWord.equals(reverseWord) ? "YES" : "NO";
    }
}
