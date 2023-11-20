import java.util.ArrayList;

public class StringTest {
    private int solution(String str, char t) {
        int answer = 0;
        str = str.toLowerCase();
        t = Character.toLowerCase(t);
//        for (int i =0; i<str.length();i++){
//            if (str.charAt(i) == t)
//                answer++;
//        }
        for (char ch : str.toCharArray()) {
            if (ch == t)
                answer++;
        }
        return answer;
    }

    // 2번 대소문자 변환
    private String solution(String str) {
        String answer = "";
        for (char ch : str.toCharArray()) {
//            if (Character.isLowerCase(ch)) answer += Character.toUpperCase(ch);
//            else answer += Character.toLowerCase(ch);
            // 아스키코드로 비교할 떄, 대문자를 소문자로 32차이
            if (ch >= 65 && ch <= 90) answer += (ch - 32);
            else answer += (ch + 32);
        }

        return answer;
    }

    // 3번 문장속 단어
    private String solution3(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
//        for (String data : list){
//            int length = data.length();
//            if (length > m){
//                m = length;
//                answer = data;
//            }
//        }
        int pos = 0;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str.substring(pos + 1);
        }
        if (str.length() > m) answer = str;
        return answer;
    }
    // 단어 뒤집기
    private ArrayList<String> solution4(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = s.length - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(s));
        }
        return answer;
    }
    // 중복 문자 제거
    private String solution5(String str) {
        String answer = "";
        // indexof는 문자가 발견된 첫 인덱스만을 리턴한다
        // 그래서 중복제거할때 사용하기 용이하다
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i)
                answer += str.charAt(i);
        }
        return answer;
    }
    // 회문 문자열
    private String solution6(String str) {
        str = str.toLowerCase();
        int lt = 0;
        int rt = str.length() -1;
        while(lt <= rt){
            if (str.charAt(lt) != str.charAt(rt))
                return "NO";
            lt++;
            rt--;
        }
        return "YES";
    }
    // 팰린드롬 replaceAll 정규식 사영
    private String solution7(String str){
        //replaceAll을 통해서 정규식 사용가능
        //[^A-Z] A,Z가 아닌 모든 값들을 빈값으로 변경
        // 문자열을 소문자로 변경하여 정규식으로 소문자를 제외한 모든 문자를 빈값으로 만듬
        str = str.toLowerCase().replaceAll("[^a-z]","");
        return solution6(str);
    }
    private String solution8(String str){
        int answer = 0;
        // char 값이 48이면 '0' 57이면 '9' 이다
        for (char ch : str.toCharArray()){
//            if (Character.isDigit(ch))
            // Charter 클래스에서 isDigit를 통해서 숫자인지 알수 있음
            if (ch >= 48 && ch <= 57){
                answer = answer * 10 + (ch - 48);
            }
        }
        return String.valueOf(answer);
    }
    // 문자 거리
    private ArrayList<Integer> solution9(String str){
        ArrayList<Integer> answer = new ArrayList<>();
        str = str.toLowerCase();
        String s = str.split(" ")[0];
        char t = str.split(" ")[1].charAt(0);
        for (int i =0; i < s.length(); i++){
            int count2 = Integer.MAX_VALUE;
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == t){
                    int count1 = Math.abs(j - i);
                    if (count2 > count1){
                        count2 = count1;
                    }
                }
            }
            answer.add(count2);
        }
        return answer;
    }
    // 문자열 압축
    private String solution10(String str){
        StringBuilder answer = new StringBuilder();
        char tmp = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++){
            if (tmp == str.charAt(i)){
                count++;
            }
            else{
                answer.append(tmp);
                if (count > 1) {
                    answer.append(count);
                    count = 1;
                }
                tmp = str.charAt(i);
            }
        }
        answer.append(tmp);
        if (count > 1)
            answer.append(count);
        return answer.toString();
    }
    // 암호
    private String solution11(int n, String str){
        StringBuilder answer = new StringBuilder();
        str = str.replace("#","1").replace("*","0");
        for (int i =str.length()-1 ;i > 0; i-=7){
            char data = 0;
            int index = i;
            for (int j = 0; j < 7; j++){
                data += Character.getNumericValue(str.charAt(index)) * Math.pow(2,j);
                index--;
            }
            answer.append(data);
        }
        return answer.reverse().toString();
    }
}
