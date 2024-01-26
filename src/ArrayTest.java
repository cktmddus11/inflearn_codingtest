import java.util.ArrayList;

public class ArrayTest {

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
    // 9번 격자판 최대합
    private int solution9(int n, int[][]arr){
        int answer = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        boolean isDiagonalLine = true;
        for (int i = 0 ; i < n; i ++){
            a= 0; b=0;
            for (int j = 0; j < n; j++){
                if (isDiagonalLine){
                    c += arr[j][j];
                    d += arr[j][n-1-j];
                }
                a += arr[i][j];
                b += arr[j][i];
            }
            if (answer > a) answer = Math.max(answer,b);
            else answer = Math.max(a,b);
            isDiagonalLine = false;
        }
        if (answer > c) answer = Math.max(answer,d);
        else answer = Math.max(c,d);
        return answer;
    }
    // 10번 봉우리
    private int solution10(int n, int[][]arr){
        int answer = Integer.MIN_VALUE;
        int[][] temp = new int[n+2][n+2];
        for (int i = 0 ; i < n; i ++){
            for (int j = 0; j < n; j++){
                temp[i+1][j+1] = arr[i][j];
            }
        }
        for (int i = 1 ; i < n+1; i ++){
            for (int j = 1; j < n+1; j++){
                int tmp = temp[i][j];
                if (temp[i-1][j] < tmp  && temp[i+1][j] < tmp && temp[i][j-1] < tmp && temp[i][j+1] < tmp) answer++;
            }
        }

        return answer;
    }
    // 11번 임시반장
    private int solution11(int n, int[][] arr){
        int answer = 0;

        int MAX = 0;
        for (int i =0; i < 5; i ++){
            int cnt = 0;
            for (int j=0; j < n;j++){
                int temp = arr[j][i];
                for (int k =0; k <n; k++){
                    if (k == j) continue;
                    else if (temp == arr[k][i]){
                        cnt++;
                    }
                }
                if (cnt > MAX){
                    MAX = cnt;
                    answer = j;
                }
            }
        }
        return answer;
    }
    private int solution12(int n, int m, int[][] arr){
        int answer = 0;
        for(int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k =0; k < m; k++){
                    int pi = 0,pj = 0;
                    for (int s = 0; s < n; s++){
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == m)
                    answer++;
            }
        }
        return answer-1;
    }
}
