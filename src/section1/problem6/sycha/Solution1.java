package section1.problem6.sycha;

import java.util.*;

/**
 * packageName    : section1.problem6.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-16        Cha       최초 생성
 *
 * 6. 중복문자제거
 * 설명
 *
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는
 * 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();


       String  answer = solution(word.toCharArray());
        System.out.println(answer);
    }

    private static String solution(char[] wordArr) {
        Set<Character> set = new LinkedHashSet<>();
        for(Character s : wordArr){
            set.add(s);
        }

        // set.addAll(wordArr);
        //Set<Character> set = new LinkedHashSet<>(Arrays.asList(wordArr));
        StringBuilder sb = new StringBuilder();
        for(Character s  : set){
            sb.append(s);
        }


        return sb.toString();
    }
}
