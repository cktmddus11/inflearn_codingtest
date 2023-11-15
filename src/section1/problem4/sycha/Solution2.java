package section1.problem4.sycha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section1.problem4.sycha
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-15        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wordCnt = scan.nextInt();

        String[] wordArr = new String[wordCnt];
        for(int i = 0;i<wordCnt;i++){
            wordArr[i] = scan.next();
        }

        List<String> answerList = solution(wordArr);
        answerList.forEach(System.out::println);
    }

    private static List<String> solution(String[] wordArr) {
        List<String> answerList = new ArrayList<>();
        for(String word : wordArr) {
            StringBuilder sb = new StringBuilder(word);
            String reverseWord = sb.reverse().toString();
            answerList.add(reverseWord);
        }


        return answerList;
    }
}
