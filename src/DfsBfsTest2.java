import java.util.*;

class Person{
    int sol, time;
    Person(int sol, int time){
        this.sol = sol;
        this.time = time;
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class DfsBfsTest2 {
    public static int[] ch;
    public static int[] arr1;
    public static int[] arr2;
    public static int[] arr3;
    public static int total = 0;
    public static int max = 0;
    public static int L = 0;
    public static int idx;
    public static int n;
    public static int m;
    public static String answer = "NO";
    public static int f = 0;
    public static int answer2 = Integer.MAX_VALUE;
    public static int answer3 = 0;
    public static boolean flag = false;
    static ArrayList<ArrayList<Integer>> memo;
    public static int[][] ch10 = new int[7][7];
    public static int[][] dis;
    public static ArrayList<Point> house;
    public static ArrayList<Point> pizza;
    // 1. 합이 같은 부분 집합
    public void solution1(int n, int[] arr){
        ch = new int[n+1];
        idx = n;
        arr1 = arr;
        for (int i =0 ; i < n; i++){
            total += arr1[i];
        }
        DFS(0);
        System.out.println(answer);
    }
    public void DFS(int n){
        if (n == idx){
            int sum = 0;
            for (int i = 0; i< idx; i++){
                if (ch[i] != 0)
                    sum += arr1[i];
            }
            if (total - sum == sum)
                answer = "YES";
        }else{
            ch[n] = 1;
            DFS(n+1);
            ch[n] = 0;
            DFS(n+1);
        }
    }
    // 2. 바둑이 승차
    public void solution2(int max, int num, int[] arr){
        idx = num;
        ch = new int[num+1];
        arr1 = arr;
        DFS2(0,max);
        System.out.println(answer2);
    }
    public void DFS2(int n, int max){
        if (idx == n){
            int sum = 0;
            for (int i = 0; i< idx; i++){
                if (ch[i] != 0)
                    sum += arr1[i];
            }
            if (max > sum){
                if(answer2 < sum)
                    answer2 = sum;
            }
        }
        else{
            ch[n] = 1;
            DFS2(n+1, max);
            ch[n] = 0;
            DFS2(n+1, max);
        }
    }
    // 3. 최대 점수 구하기
    public void solution3(int n, int m, Person[] arr){
        idx = n;
        ch = new int[n+1];
        total = m;
        DFS3(0,0,0, arr);
    }
    public void DFS3(int n, Person[] arr){
        if (n == idx){
            int sum = 0;
            int time = 0;
            for (int  i= 0; i < arr.length; i++){
                if (ch[i] != 0){
                    sum += arr[i].sol;
                    time += arr[i].time;
                }
            }
            if (total >= time){
                if (sum > answer2) answer2 = sum;
            }
        }else{
            ch[n] = 1;
            DFS3(n+1, arr);
            ch[n] = 0;
            DFS3(n+1, arr);
        }
    }
    public void DFS3(int L, int sum, int time, Person[] arr){
        if (time  > total) return;
        if (L == idx){
            answer2 = Math.max(answer2, sum);
        }else{
            DFS3(L+1, sum+arr[L].sol,time+arr[L].time, arr);
            DFS3(L+1, sum,time, arr);
        }
    }
    //
    public void solution4(){}
    // 5. 동전 교환
    public void solution5(int n, Integer[] arr, int m){
        idx = n;
        max = m;
        // 역순으로 정렬해서 굳이 작은 값부터 찾을 필요가 없음/
        Arrays.sort(arr, Collections.reverseOrder());
        DFS5(0,0,arr);
    }
    public void DFS5(int count, int total, Integer[] arr){
        if (total > max) return;
        if (count >= answer2) return;
        if (total == max){
            answer2 = Math.min(answer2, count);
        }
        else{
            for (int i = 0 ; i < idx; i++){
                DFS5(count+1, total+arr[i], arr);
            }
        }
    }
    // 6. 중복 순열 구하기
    public void solution6(int n, int m, int[] arr){
//        Main.n = n;
//        Main.m = m;
        ch = new int[n];
        arr1 = new int[m];
        DFS6(0, arr);
    }
    public void DFS6(int n,  int[] arr){
        if (m == n){
            for (int i = 0 ; i < 2; i++){
                System.out.print(arr1[i] + " ");
            }
            System.out.println();
        }else{
            for (int i =0; i < n; i++){
                if (ch[i] != 1){
                    ch[i] = 1;
                    arr1[n] = arr[i];
                    DFS6(n+1, arr);
                    ch[i] = 0;
                }
            }
        }
    }
    // 7. 조합수(메모제이션)
    public void solution7(int n, int r){
        int answer = DFS7(n,r);
        System.out.println(answer);
    }
    public int DFS7(int n, int r){
        if (r == 0 || n == r){
            return 1;
        }else{
            return DFS7(n-1, r-1) + DFS7(n-1, r);
        }
    }
    // 8. 수열 추측하기
    public void solution8(int n, int m){
        idx = n;
        f = m;
        arr1 = new int[n];
        arr2 = new int[n];
        ch = new int[n+1];
        int[] arr = new int[n];
        for (int i =0; i < n; i++)
            arr1[i] = DFS7(n-1,i);
        DFS8(0,0);
    }
    public void DFS8(int n, int m){
        if (flag)
            return;
        if (n == idx){
            if (m == f){
                for (int x : arr2) System.out.print(x + " ");
                flag = true;
            }
        }else{
            for (int i =1; i<= idx; i++){
                if (ch[i] == 0){
                    ch[i] = 1;
                    arr2[n] = i;
                    DFS8(n+1,m+(arr1[n]*arr2[n]));
                    ch[i] = 0;
                }
            }
        }
    }
    // 10. 미로탐색(DFS)
    public void solution10(int[][] arr){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0,1,0,-1};
        DFS10(1,1,arr, dx, dy);
    }
    public void DFS10(int n, int m, int[][] arr, int[] dx, int[] dy){
        if(n==7 && m==7) answer2++;
        else{
            for(int i=0; i<4; i++){
                int nx=n+dx[i];
                int ny=m+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    DFS10(nx, ny, arr, dx, dy);
                    arr[nx][ny]=0;
                }
            }
        }
    }
    // 11. 미로탐색(BFS)
    public int solution11(int[][] arr){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0,1,0,-1};
        int[][] dis = new int[arr.length][arr.length];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        int L = 1;
        while (!q.isEmpty()){
            int len = q.size();
            Point cur = q.poll();
            for (int j =0; j < 4; j++){
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if(nx>=0 && nx<7 && ny>=0 && ny<7 && arr[nx][ny]==0){
                    arr[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
        if (dis[arr.length-1][arr.length-1] == 0)
            return -1;
        return dis[arr.length-1][arr.length-1];
    }
    // 12. 토마토
    public int solution12(int n, int m, int[][] arr){
        Queue<Point> q = new LinkedList<>();
        int L = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0,1,0,-1};
        int[][] dis = new int[m][n];
        int count = 0;
        for (int i =0; i < m; i++){
            for (int j =0; j < n; j++){
                if (arr[i][j] == 1){
                    q.offer(new Point(i,j));
                    count++;
                }else if (arr[i][j] == -1)
                    count++;
            }
        }
        while (!q.isEmpty()){
            Point cur = q.poll();
            for (int j =0; j < 4; j++){
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if(nx>=0 && nx<m && ny>=0 && ny<n && arr[nx][ny]==0){
                    arr[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
        int zeroCount = 0;
        for (int i =0; i < m; i++){
            for (int j =0; j < n; j++){
                if (dis[i][j] == 0)
                    zeroCount++;
            }
        }
        if (zeroCount != count)
            return -1;
        int answer = Integer.MIN_VALUE;
        for (int i =0; i < m; i++){
            for (int j =0; j < n; j++){
                answer = Math.max(dis[i][j],answer);
            }
        }
        return answer;
    }
    public int solution13(int n, int[][] arr){
        idx = n;
        int count = 0;
        dis = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j =0; j < n; j ++){
                if (dis[i][j] == 0 && arr[i][j] == 1){
                    DFS13(new Point(i,j), arr);
                    count++;
                }
            }
        }

        return count;
    }
    public void DFS13(Point point, int[][] arr){
        int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
        for (int i = 0; i < 8; i++){
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if (nx >= 0 && nx < idx && ny >= 0 && ny < idx && dis[nx][ny] == 0 && arr[nx][ny] == 1){
                dis[nx][ny] = 1;
                DFS13(new Point(nx,ny),arr);
            }
        }
    }
    public int solution13BFS(int n, int[][] arr){
        dis = new int[n][n];
        int count = 0 ;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j =0; j < n; j ++){
                if (arr[i][j] == 1 && dis[i][j] == 0){
                    queue.offer(new Point(i,j));
                    while (queue.size() != 0){
                        Point point = queue.poll();
                        int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
                        int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
                        for (int k = 0; k < 8; k++){
                            int nx = point.x + dx[k];
                            int ny = point.y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && dis[nx][ny] == 0 && arr[nx][ny] == 1){
                                dis[nx][ny] = 1;
                                queue.offer(new Point(nx,ny));
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
    // 14. 피자 배달 거리
    private int solution14(int n, int m, int[][] arr){
        dis = new int[n][n];
        idx = m;
        answer2 = Integer.MAX_VALUE;
        this.n = n;
        house = new ArrayList<>();

        for (int i =0; i < n; i++){
            for (int j =0; j < n; j++){
                if (arr[i][j] == 1){
                    house.add(new Point(i,j));
                }
            }
        }
        DFS14(0, 0,arr);
        return answer2;
    }
    private void DFS14(int answer, int count, int[][] arr){
        if (count == idx){
            int data = 0;
            pizza = new ArrayList<>();
            for (int i =0; i < n; i++){
                for (int j =0; j < n; j++){
                    if (dis[i][j] == 1){
                        pizza.add(new Point(i,j));
                    }
                }
            }
            for (Point housePoint : house){
                int housePizza = Integer.MAX_VALUE;
                for (Point pizzaPoint : pizza){
                    housePizza = Math.min(housePizza,Math.abs(housePoint.x - pizzaPoint.x) + Math.abs(housePoint.y-pizzaPoint.y));
                }
                data += housePizza;
            }
            if (answer2 > data)
                answer2 = data;
        }else{
            for (int i =0; i < n; i++){
                for (int j =0; j < n; j++){
                    if (arr[i][j] == 2 && dis[i][j] == 0){
                        dis[i][j] = 1;
                        int idx = count+1;
                        DFS14(0, idx ,arr);
                        dis[i][j] = 0;
                    }
                }
            }
        }
    }
}
