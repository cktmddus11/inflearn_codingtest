package section5.problem1;

import java.util.Scanner;
import java.util.Stack;

/**
 * packageName    : section4
 * fileName       : Solution
 * author         : Cha
 * date           : 2024-01-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-02        Cha       최초 생성
 */
public class Solution {
    public static void main(String[] args) {
        // String str = "(())()";
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String answer = solution(str);
        System.out.println(answer);
    }

    private static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            // 비어있지 않으면
            if (c == '(') {
                stack.push(c);
            } else { // 넣어야하는 문자가 ) 면 스택에 ( 가 있는지 확인
                if (stack.peek() == '('){
                    stack.pop();
                }
            }

        }
        if (!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }
}
