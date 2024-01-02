package section1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    // 1. 올바른 괄호
    private String solution1(String str){
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch == ')'){
                if (stack.empty())
                    return "NO";
                stack.pop();
            }else stack.add(ch);
        }
        return "YES";
    }
    // 2. 괄호문자제거
    private String solution2(String str){
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch == ')'){
                while(stack.pop() != '(');
            }else stack.add(ch);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0 ; i < stack.size(); i++)
            answer.append(stack.get(i));
        return answer.toString();
    }
    // 3 크레인 인형뽑기
    private int solution3(int m, int[][] a, int n, int[] b){
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i =0; i < n; i++){
            int movesIdx = b[i] - 1;
            for (int j =0; j < m; j++){
                if (a[j][movesIdx] != 0) {
                    if (stack.size() != 0 && stack.peek() == a[j][movesIdx]){
                        stack.pop();
                        count += 2;
                    }else{
                        stack.add(a[j][movesIdx]);
                    }
                    a[j][movesIdx] = 0;
                    break;
                }
            }
        }
        return count;
    }
    // 4 후위 연산자
    private int solution4(String str){
        Stack<Integer> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch >= 48 && ch <= 57) stack.add(ch - 48);
            else{
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;
                if (ch == '+'){
                    result = a + b;
                }else if (ch == '-'){
                    if (a > b) result = a- b;
                    else result = b -a ;
                }else if (ch == '*'){
                    result = a * b;
                } else if (ch == '/') result = a / b;
                else result = a % b;
                stack.push(result);
            }
        }
        return stack.peek();
    }
    // 5번 쇠 막대기
    private int solution5(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch == '('){
                if (stack.size() !=0 && stack.peek() == ')') stack.pop();
                stack.push(ch);
            } else{
                char peek = stack.pop();
                if (peek == '('){
                    answer += stack.size();
                }else{
                    stack.pop();
                    answer += 1;
                }
                stack.push(ch);
            }
        }
        return answer;
    }
    // 6 공주구하기(큐)
    private int solution6(int n, int m){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i =1; i <=n; i++) queue.offer(i);
        while(!queue.isEmpty()){
            for (int i =1; i <m; i++){
                queue.offer(queue.poll());
            }
            answer = queue.poll();
        }
        return answer;
    }
    // 7. 교육과정 설계
    private String solution7(String a, String b){
        Queue<Character> queue = new LinkedList<>();
        for (char ch : a.toCharArray())
            queue.offer(ch);
        for (int i =0; i < b.length(); i++){
            if (queue.size() == 0)
                return "YES";
            if (b.charAt(i) == queue.peek()) queue.poll();
        }
        return "NO";
    }
    // 8. 응급실
    private int solution8(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.offer(new Person(i, arr[i]));
        while (queue.size() > 0){
            boolean isTarget = false;
            Person other = queue.poll();
            for (Person person : queue){
                if (person.person > other.person){
                    queue.offer(other);
                    isTarget = true;
                    break;
                }
            }
            if (!isTarget){
                answer++;
                if (other.idx == m)
                    return answer;
            }
        }

        return answer;
    }
    class Person{
        int idx;
        int person;
        Person(int i, int person){
            idx = i;
            this.person = person;
        }
    }
}
