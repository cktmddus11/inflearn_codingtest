import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
//        int[] arr2 = new int[n];
        for (int i = 0 ; i < n; i++){
            for (int j =0; j < n; j++)
                arr[i][j] = in.nextInt();
        }
//        for (int i = 0 ; i < n; i++){
//            arr2[i] = in.nextInt();
//        }
        int test = t.solution9(n,arr);
        System.out.print(test);
    }

    // 1번 큰수 출력하기
    public ArrayList<Integer> solution1(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i =1; i < n; i++){
          if (arr[i] > arr[i-1])
              answer.add(arr[i]);
        }
        return answer;
    }
    // 2번 보이는 학생
    private int solution2(int n, int[] arr){
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i =0; i < n; i++){
            if (arr[i] > max){
                count++;
                max = arr[i];
            }
        }
        return count;
    }
    // 3번 가위 바위 보
    private ArrayList<String> solution3(int n, int[] play1, int[] play2){
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (Math.abs(play1[i]-play2[i]) == 2){
                if (play1[i]-play2[i] > 0) answer.add("B");
                else  answer.add("A");
            }
            else if (play1[i] > play2[i]) answer.add("A");
            else if (play1[i] == play2[i]) answer.add("D");
            else answer.add("B");
        }
        return answer;
    }
    // 4번 피보나치
    private ArrayList<Integer> solution4(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int ind1 = 1;
        int ind2 = 1;
        answer.add(ind1);
        answer.add(ind2);
        for (int i = 1; i < n - 1; i++) {
            ind2 = answer.get(i-1) + ind2;
            answer.add(ind2);
        }
        return answer;
    }
    // 5번 소수 구하기
    private Integer solution5(int n){
        int answer = 0;
        int[] data =  new int[n+1];
        for (int i = 2; i <= n; i++){
            if (data[i] == 0){
                answer++;
                for (int j = i; j <=n; j = j+i)
                    data[j] = 1;
            }
        }
        return answer;
    }
    // 6번 뒤집은 소수
    private ArrayList<Integer> solution6(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int data = reverseInt(arr[i]);
            boolean isDecimal = true;
            for (int j = 2; j < data; j++){
                if (data % j == 0){
                    isDecimal = false;
                    break;
                }
            }
            if (isDecimal && data != 1)
                answer.add(data);
        }
        return answer;
    }
    private int reverseInt(int n){
        int answer = 0;
        while (n != 0){
            answer = answer *10 + n % 10;
            n /= 10;
        }
        return answer;
    }
    // 7번 점수 계산
    private int solution7(int n, int[] arr){
        int answer = 0;
        int count = 0;
        for (int i = 0 ; i < n; i++){
            if (arr[i] == 1) count++;
            else count = 0;
            answer += count;
        }
        return answer;
    }
    // 8번 등수 구하기
    private int[] solution8(int n, int[] arr){
        int[] answer = new int[n];
        for (int i = 0; i < n; i ++){
            int tmp = arr[i];
            answer[i]++;
            for (int j = 0; j < n; j++){
                if (i == j) continue;
                else if(tmp > arr[j]) answer[j]++;
            }
        }
        return answer;
    }
    private int solution9(int n, int[][]arr){
        int answer = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0 ; i < n; i ++){
            boolean isB = true;
            for (int j = 0; j < n; j++){
                a += arr[i][j];
                if (isB){
                    b+= arr[i][j];
                    isB = false;
                }
                if (i+j == n-1 ) c+= arr[i][j];
                if (i==j) d+= arr[i][j];
            }
            if (a > b){
                if (a > c){
                    answer = Math.max(a, d);
                }
                else {
                    answer = Math.max(c,d);
                }
            } else{
                if (b > c){
                    answer = Math.max(b,d);
                }
                else{
                    answer = Math.max(c,d);
                }
            }

            if (answer == a) a = 0;
            else if (answer == b) b=0;
            else if (answer == c) c = 0;
            else d = 0;
        }
        return answer;
    }
}