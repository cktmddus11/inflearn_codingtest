import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}
public class DfsBfsTest {
    static int[] fibo;
    static int[][] graph;
    static ArrayList<ArrayList<Integer>> graph2;
    static int[] ch;
    static int[] dis;
    static int n, m, answer = 0;
    Node root;
    int idx;
    // 1. 재귀 함수(DFS)
//    public void DFS(int n){
//        if (n == 0) return;
//        else{
//            DFS(n-1);
//            System.out.println(n);
//        }
//    }
    // 2. 이진수 재귀 함수
    public void solution2(int n){
        if (n == 0) return;
        else{
            int tmp = n%2;
            solution2(n/2);
            System.out.print(tmp);
        }
    }
    // 3. 팩토리얼
    public int solution3(int n){
        if (n == 1)
            return 1;
        else
            return n * solution3(n-1);
    }
    // 4. 피보나치

    public int solution4(int n){
        if (n == 1 || n == 2)
            return fibo[n] = 1;
        else if(fibo[n] != 0)
            return fibo[n];
        else
            return fibo[n] = solution4(n-2) + solution4(n-1);
    }
    // 5. 이진 트리 순회(DFS)
    public void solution5(){
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
    public void DFS(Node root){
        if (root == null) return;
        else{
            //            System.out.print(root.data+" "); 전위 순회
            DFS(root.lt);
            //            System.out.print(root.data+" "); 중위 순회
            DFS(root.rt);
            //            System.out.print(root.data+" "); 후위 순회
        }
    }
    // 6. 부분 집합 구하기(DFS)
    public void solution6(int n){
        idx = n;
        ch = new int[n+1];
        DFS(1);
    }
    public void DFS(int L){
        if (idx +1 == L){
            for (int i =1; i<= idx; i++){
                if (ch[i] != 0)
                    System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        else{
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
    // 7. 이진트림 레벨 탐색(bfs)
    public void solution7(Main t){
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }
    public void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()){
            int len = q.size();
            System.out.print(L + " : ");
            for (int i =0; i < len; i++){
                Node current = q.poll();
                System.out.print(current.data);
                if (current.lt != null){
                    q.offer(current.lt);
                }
                if (current.rt != null){
                    q.offer(current.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
    // 8. 송아지 찾기(bfs)
    public int solution8(int n, int m){
        int[] tmp = new int[10001];
        int[] dis = {1,-1,5};
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int L = 1;
        while (!q.isEmpty()){
            int len = q.size();
            for (int i =0; i < len; i++){
                int cur = q.poll();
                for (int j =0; j < dis.length; j++){
                    int x = cur + dis[j];
                    if (x == m) return L;
                    if (x >=1 && x <= 10000 && tmp[x] == 0){
                        tmp[x] = 1;
                        q.offer(x);
                    }
                }
            }
            L++;
        }
        return L;
    }
    //9. 경로 찾기(인접행렬)
    public void solution9(int n, int m, Scanner scanner, Main t){
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for (int i =0; i <m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b]=1;
        }
        ch[1] = 1;
        DFS2(1);
    }
    public void DFS2(int v){
        if (v == m){
            answer++;
        } else{
            for (int i = 1; i <=n; i++){
                if (graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    DFS2(i+1);
                    ch[i] = 0;
                }
            }
        }
    }
    // 10. 경로 찾기(인접리스트)
    public void solution10(int n, int m, Scanner scanner, Main T){
        graph2 = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            graph2.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for (int i =0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph2.get(a).add(b);
        }
        ch[1] = 1;
        DFS3(1);
    }
    public void DFS3(int v){
        if (v == m){
            answer++;
        } else{
            for (int data : graph2.get(v)){
                if (ch[data] == 0){
                    ch[data] =1 ;
                    DFS(data);
                    ch[data] = 0;
                }
            }
        }
    }
    // 11. 그래프 최단 거리
    public void solution11(int n, int m, Scanner scanner, Main T){
        graph2 = new ArrayList<ArrayList<Integer>>();
        for (int i =0 ; i<=n;i++){
            graph2.add(new ArrayList<>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i <m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph2.get(a).add(b);
        }
        BFS(1);
    }
    public void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        ch[1] = 1;
        dis[v] = 0;
        q.offer(1);
        while (!q.isEmpty()){
            int nv = q.poll();
            for (int data : graph2.get(v)){
                if (ch[data] == 0){
                    ch[data] = 1;
                    q.offer(data);
                    dis[data] = dis[nv]+1;
                }
            }
        }
    }
}
