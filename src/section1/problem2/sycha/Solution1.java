package section1.problem2.sycha;

import java.util.Scanner;

/*
* 대소문자 변환
* */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input1 = scan.next();
        String answer = solution(input1);
        System.out.println(answer);
    }
    public static String solution(String str){
        String answer = "";
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            }else{
                answer += Character.toUpperCase(c);
            }
        }
        return answer;
    }
}
