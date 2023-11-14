package section1.problem1.sycha;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        char input2 = in.next().charAt(0);

        int answer = solution(input1, input2);
        System.out.println(answer);

    }

    public static int solution(String str, char t) {
        int answer = 0;
        String lowerCaseStr = str.toLowerCase();
        char lowerCaseChar = Character.toLowerCase(t);

        for (char c : lowerCaseStr.toCharArray()) {
            if (c == lowerCaseChar) {
                answer++;
            }
        }

        return answer;
    }
}
