package section5.problem2;

import java.util.Stack;

/**
 * packageName    : section5.problem2
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-01-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-02        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        String str = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        Stack<Character> stack = new Stack<>();


        for(Character c : str.toCharArray()){
             if(c == ')'){
                while(stack.pop()!= '(');
            }else stack.push(c);
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0;i<stack.size();i++){
            answer.append(stack.get(i));
        }
        System.out.println(answer.toString());
    }
}
