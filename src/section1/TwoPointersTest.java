package section1;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointersTest {
    // 1 두 배열 합치기
    private ArrayList<Integer> solution1(int[] a, int b[]){
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < a.length; i++){
            int temp = a[i];
            for (int j = idx ; j < b.length; j++){
                if (temp < b[j]){
                    answer.add(temp);
                    break;
                }else {
                    answer.add(b[j]);
                    idx++;
                }
            }
        }
        if (b.length > a.length){
            for (int i =idx; i < b.length; i++){
                answer.add(b[i]);
            }
        }else{
            for (int i =++idx; i < a.length; i++){
                answer.add(a[i]);
            }
        }
        return answer;
    }
    // 2. 공통원소 구하기
    private ArrayList<Integer> solution2(int n, int[] a, int m, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int lp = 0;
        int rp = 0;
        while (lp < n && rp < m){
            if (a[lp] < b[rp]) lp++;
            else if(a[lp] == b[rp]){
                answer.add(a[lp++]);
                rp++;
            }else rp++;
        }
        return answer;
    }
    // 3. 최대 매출
    private int solution3(int n, int m, int[] arr){
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i =0 ; i< m; i++)
            temp += arr[i];
        max = temp;
        for (int i = m; i < n; i++){
            temp = temp + arr[i] - arr[i-m];
            if(temp > max)
                max = temp;
        }
        return max;
    }

    // 4. 연속된 부분 수열
    private int solution4(int n, int m, int[] arr){
        int cnt = 0;
        int lt = 0;
        int rt = 0;
        int idx = 0;
        int sum = 0;
        try{
            while(idx < n){
                if(sum == m){
                    sum -= arr[lt++];
                    cnt++;
                }else if (sum > m){
                    sum -= arr[lt++];
                }else{
                    sum += arr[idx++];
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (sum == m)
            cnt++;

        return cnt;
    }
    //5. 연속된 자연수의 합
    private int solution5(int n){
        int answer = 0;
        int cnt = 0;
        int lt = 1;
        int rt = 1;
        while(lt < n){
            if (answer == n){
                cnt++;
                answer -= rt++;
            }else if (answer > n){
                answer -= rt++;
            }else{
                answer += lt++;
            }
        }
        return cnt;
    }
    // 6. 최대 길이 연속 부분 수열
    private int solution6(int n, int m, int[] arr){
        int answer = 0;
        int lt = 0;
        int idx = 0;
        int cnt = 0;
        boolean isFirst = true;
        int max = Integer.MIN_VALUE;
        while(lt < n){
            if (cnt == m){
                if (arr[lt++] == 0){
                    if (max < answer){
                        max = answer;
                    }
                    lt = idx;
                    answer = 0;
                    cnt = 0;
                    isFirst = true;
                }else answer++;
            }
            else if (arr[lt] == 0 && cnt < m){
                lt++;
                if (isFirst){
                    isFirst = false;
                    idx = lt;
                }
                answer++;
                cnt++;
            }
            else if (arr[lt++] == 1)
                answer++;

        }
        return max;
    }
}
