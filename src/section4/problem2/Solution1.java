package section4.problem2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * packageName    : section4.problem2
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.next();
        String input2 = scan.next();

        String answer = solution(input1, input2);
        System.out.println(answer);
    }

    private static String solution(String input1, String input2) {
        Map<Character, Integer> inputMap1 = new HashMap<>();
        Map<Character, Integer> inputMap2 = new HashMap<>();

        for(char c : input1.toCharArray()){
            inputMap1.put(c, inputMap1.getOrDefault(c, 0)+1);
        }
        for(char c : input2.toCharArray()){
           inputMap2.put(c, inputMap2.getOrDefault(c, 0)+1);

        }

      /*  for(char key : inputMap1.keySet()){
            System.out.println(key +":"+ inputMap1.get(key));
        }
        for(char key : inputMap2.keySet()){
            System.out.println(key +":"+ inputMap2.get(key));
        }
*/
      /*
      // 아래처럼 처리하면 키의 값이 없을 경우에  처리가안됨.
       for(char key : inputMap1.keySet()){
            int value1 = inputMap1.get(key);
            int value2 = inputMap2.get(key);
            if(value1 != value2){
                return "NO";
            }
        }*/
        for(char key : inputMap1.keySet()) {
            if(!inputMap2.containsKey(key) || inputMap2.get(key) != inputMap1.get(key)){
                return "NO";
            }
        }

        return "YES";
    }
}
