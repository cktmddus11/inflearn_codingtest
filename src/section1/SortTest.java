package section1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        // this가 앞에 숫자 o가 뒤에 숫자 잎으로 return 값이 음수면 오름 차순으로 정렬된다.
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}
public class SortTest {
    // 1. 선택 정렬
    private int[] solution1(int n, int[] arr){
        int idx = 0;
        int min = Integer.MAX_VALUE;

        for (int i =0; i < n; i++){
            min = arr[i];
            idx = i;
            for (int j =i+1; j < n; j++){
                if (min > arr[j]) {
                    min = arr[j];
                    idx= j;
                }
            }
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    // 2. 버블정렬
    private int[] solution2(int n, int[] arr){
        for (int i =n; i > 0; i--){
            int first = arr[0];
            int idx = 0;
            for (int j =1; j < i; j++){
                if (first > arr[j]){
                    int temp = arr[idx];
                    arr[idx] = arr[j];
                    arr[j] = temp;
                }
                first = arr[j];
                idx = j;
            }
        }
        return arr;
    }
    // 3. 삽입 정렬
    private int[] solution3(int n,int[] arr){
        for (int i =0; i < n; i++){
            int last = arr[i];
            int idx =i;
            for (int j =i; j > 0; j--){
                if(last < arr[j-1]){
                    int temp = arr[idx];
                    arr[idx] = arr[j-1];
                    arr[j-1] = temp;
                    idx = j-1;
                }else break;
            }
        }
        return arr;
    }
    // 4. Least Recently Used 캐시 메모리
    private int[] solution4(int m, int n, int[] arr){
        int[] answer = new int[m];
        for (int i=0; i < n; i++){
            int temp = arr[i];
            int idx = -1;
            for (int j=0;j<m;j++){
                if (temp == answer[j]){
                    idx = j;
                    break;
                }
            }
            if (idx == -1){
                for (int j = m -1; j > 0; j--){
                    answer[j] = answer[j-1];
                }
            }else{
                for (int j = idx; j > 0; j--){
                    answer[j] = answer[j-1];
                }
            }

            answer[0] = temp;
        }
        return answer;
    }
    // 5. 중복확인
    private String solution5(int n, int[] arr){
        for (int i =0; i < n; i++){
            int tmp = arr[i];
            int idx = i;
            for (int j =0; j < n; j++) {
                if (idx == j) continue;
                else if (tmp == arr[j]){
                    return "D";
                }
            }
        }
        return "U";
    }
    // 6. 장난꾸러기
    private int[] solution6(int n, int[] arr){
        int[] answer = new int[2];
        int idx= 0;
        boolean isFirst = true;
        for (int i =0; i< n-1; i++){
            if (arr[i] > arr[i+1]){
                if (isFirst){
                    isFirst = false;
                    answer[1] = i+2;
                    idx = i;
                } else{
                    answer[1] = i+2;
                    for (int j = i-1; j >0; j--){
                        if (arr[j-1] > arr[j]){
                            answer[0] = j;
                            break;
                        }
                    }
                }
            }
        }
        if (!isFirst && answer[0] == 0){
            for (int j = idx-1; j >0; j--){
                if (arr[j-1] < arr[j]){
                    answer[0] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
    // 7. 좌표 정렬
    private void solution7(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i =0; i < n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x,y));
        }
        // 위에 point 함수에 compartalbe을 참고하여 colletions 에서 정렬이 된다.
        Collections.sort(arr);
        for (Point o : arr){
            System.out.println(o.x +" "+o.y);
        }
    }
    // 8. 이분검색
    private int solution8(int n, int m, int[] arr){
        int[] sort = solution3(n,arr);
        for (int i =0;i<n;i++){
            if (m == sort[i])
                return i+1;
        }
        return 0;
    }
    // 9. 뮤직비디오(결정 알고리즘)
    private int solution9(int n, int m, int[] arr){
        int lt = Integer.MIN_VALUE;
        int rt = 0;
        for (int i = 0; i < n; i++){
            if (lt < arr[i]) lt = arr[i];
            rt += arr[i];
        }
        int capacity = (rt + lt) / 2;
        while(lt <= rt){
            capacity = (rt + lt) / 2;
            int count = 1;
            int tmp = 0;
            for (int j = 0; j < n; j++){
                if (capacity < tmp + arr[j]){
                    count++;
                    tmp = arr[j];
                }else{
                    tmp += arr[j];
                }
            }
            if (count <= m)
                rt = capacity-1;
            else
                lt = capacity+1;
        }
        return capacity;
    }
    // 10. 마구간 정하기
    private int solution10(int n, int c, int[] arr){
        int lt = 1;
        int rt = arr[n-1];
        int answer = 0;
        Arrays.sort(arr);
        int mid = (lt + rt) / 2;


        while (lt <= rt){
            int count = 1;
            int tmp = arr[0];
            mid = (lt + rt) / 2;
            for (int j = 1; j < n; j++){
                if (arr[j] - tmp >= mid){
                    tmp = arr[j];
                    count++;
                }
            }
            if (count >= c){
                answer = mid;
                lt = mid + 1;
            }
            else
                rt = mid - 1;
        }
        return answer;
    }
}
