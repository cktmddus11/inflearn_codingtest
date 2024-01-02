package section4.problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * packageName    : section4.problem1
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
        int n = scan.nextInt();
       String str = scan.next();
        char answer = solution(n, str);
        System.out.println(answer);
    }

    private static char solution(int n, String str) {
        Map<Character, Integer> map = new HashMap<>();
        char answer = 0;
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
     /*   for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() +":"+entry.getValue());
        }*/
        int max = Integer.MIN_VALUE;
      /*  for(char key : map.keySet()){
            int value = map.get(key);
            if(value > max){
                max = value;
                answer = key;
            }
        }*/
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                answer = entry.getKey();
            }
        }
        return answer;
    }

}
