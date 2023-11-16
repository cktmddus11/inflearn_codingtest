package section1.problem5.sycha;

import java.util.Scanner;

/**
 * packageName    : section1.problem5.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-16        Cha       최초 생성
 *
 * 5. 특정 문자 뒤집기
 *
 *설명
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        String answer = solution(str);
        System.out.println(answer);
    }

    private static String solution(String str) {
        char[] charArr = str.toCharArray();
        int leftIdx = 0;
        int rightIdx = str.length()-1;

        while(leftIdx < rightIdx){
            char leftChar = charArr[leftIdx];
            char rightChar = charArr[rightIdx];

            if(!Character.isAlphabetic(leftChar)){
                leftIdx++;
            }else if(!Character.isAlphabetic(rightChar)){
                rightIdx--;
            }else{
                char temp =  charArr[rightIdx];
                charArr[rightIdx] = charArr[leftIdx];
                charArr[leftIdx] = temp;
                leftIdx++;
                rightIdx--;
            }
        }

        return String.valueOf(charArr);
    }
}
