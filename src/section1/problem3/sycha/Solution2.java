package section1.problem3.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem3.sycha
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-14        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine(); // 공백 들어간 문자열 nextLine, 그냥 문자열 next
        String answer = solution(input1);
        System.out.println(answer);
    }
    private static String solution(String str) {
        String answer = "";

        int MIN_VALUE = Integer.MIN_VALUE;
        int idx = 0;

        while((idx = str.indexOf(" ")) != -1){
            String s =  str.substring(0, idx);
            if(s.length() > MIN_VALUE){
                answer = s;
                MIN_VALUE = s.length();

            }
            str = str.substring(idx+1);
        }
        if(str.length() > MIN_VALUE){
            answer = str;
        }


        return answer;
    }
}
