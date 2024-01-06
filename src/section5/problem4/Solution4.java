package section5.problem4;

import java.util.Scanner;
import java.util.Stack;

/**
 * packageName    : section5.problem4
 * fileName       : Solution4
 * author         : Cha
 * date           : 2024-01-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-04        Cha       최초 생성
 *
 * 숫자0~9까지 아스키코드값은
 * 48~57
 *
 * 영문a~z까지의 아스키코드값은
 * 대문자 65~90
 * 소문자 97~122
 * 출처: https://copyrightyoon.tistory.com/1417 [유용한정보:티스토리]
 *
 * 후위식 연산  : 부호 나올때까지 스택에 넣고 부호 만나면 숫자 두개 pop 스택 부족하면 기존 값으로 연산.
 * https://todaycode.tistory.com/73
 */
public class Solution4 {
    public static void main(String[] args){
       // String str = "352+*9-";
        Scanner scan= new Scanner(System.in);
        String str = scan.next();

        int answer = solution(str);

        System.out.println(answer);
    }

    private static int solution(String str) {
        Stack<Integer>  numStack = new Stack<>();

        int sum = 0;
        for(Character c : str.toCharArray()) {
            Integer cc = c - 48;
            if (cc >= 1 && cc <= 9) {
                numStack.push(cc);
                System.out.println(cc);
            } else {
               int secondNum = numStack.isEmpty() ? sum : numStack.pop();
               int firstNum = numStack.isEmpty() ? sum : numStack.pop();
               System.out.println(firstNum+" "+c+" "+secondNum);

               if(c == '+'){
                    sum = firstNum + secondNum;
               }else if(c == '-'){
                   sum = firstNum - secondNum;
               }else if(c =='*'){
                   sum = firstNum * secondNum;
               }else if(c == '/'){
                   sum = firstNum / secondNum;
               }
            }
        }
        return sum;
    }
}
