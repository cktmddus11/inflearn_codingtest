package section1.problem8.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem8.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        Cha       최초 생성
 *
 *
 *
 * 8. 유효한 팰린드롬
 * 설명
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String replaceAllStr = str.toLowerCase().replaceAll("[^a-z]", "");
        // 알파벳만가지고 회문인지체크하므로 정규식으로 나머지를 제외처리한다.
        String reverseStr = new StringBuilder(replaceAllStr).reverse().toString();
        return replaceAllStr.equals(reverseStr) ? "YES" : "NO";
    }
}
