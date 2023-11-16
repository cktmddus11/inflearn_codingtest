package section1.problem6.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem6.sycha
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-16        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();


        String  answer = solution(word);
        System.out.println(answer);
    }
    private static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(i  == word.indexOf(c) ){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
