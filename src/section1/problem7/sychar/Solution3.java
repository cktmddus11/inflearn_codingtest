package section1.problem7.sychar;

import java.util.Scanner;

/**
 * packageName    : section1.problem7.sychar
 * fileName       : Solution3
 * author         : Cha
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        Cha       최초 생성
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();

        String answer = solution(word);
        System.out.println(answer);
    }

    private static String solution(String word) {
        String answer = "YES";
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {   // s  t  u   d  y
           if(word.charAt(i) != word.charAt(length - 1)) answer = "NO";
        }
        return answer;
    }

}
