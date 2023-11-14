package section1.problem3.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem3.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-14        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine(); // 공백 들어간 문자열 nextLine, 그냥 문자열 next
        String answer = solution(input1);
        System.out.println(answer);
    }

    private static String solution(String str) {
        String answer = "";
        String []strArray = str.split(" ");

        int MIN_VALUE = Integer.MIN_VALUE;

        for(String s : strArray){
            if(s.length() > MIN_VALUE){
                // 주의 : 긴단어가 여러개일 경우 문장속 가장 앞쪽 위치한 단어를 답으로 하므로 같은값은 제외
                answer = s;
                MIN_VALUE = s.length();
            }
        }
        return answer;
    }
}
