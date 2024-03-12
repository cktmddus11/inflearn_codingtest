import java.util.*;

class Player implements Comparable<Player>{
    int key;
    int weight;
    Player(int key, int weight){
        this.key = key;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        return o.key - this.key;
    }
}
class Room implements Comparable<Room>{
    int start, end;
    public Room(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room o) {
        if (this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}
class PartyPerson implements Comparable<PartyPerson>{
    int time;
    char state;
    PartyPerson(int time, char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(PartyPerson o) {
        if (this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    Lecture(int money, int time){
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture o) {
        return o.time - this.time;
    }
}
class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    public Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return o.cost - this.cost;
    }
}
class UnionEdge implements Comparable<UnionEdge>{
    public int first;
    public int second;
    public int cost;
    public UnionEdge(int first, int second, int cost){
        this.first = first;
        this.second = second;
        this.cost = cost;
    }
    @Override
    public int compareTo(UnionEdge o) {
        return o.cost - this.cost;
    }
}

public class GreedyTest {
    static int[] unf;
    static int max = 0;

    // 1. 씨름 선수
    public int solution(int n, ArrayList<Player> players){
        Collections.sort(players);
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (Player player : players){
            if (player.weight > max){
                cnt++;
                max = player.weight;
            }
        }
        return cnt;
    }
    // 2.  회의실 배정
    public int solution2(ArrayList<Room> rooms){
        Collections.sort(rooms);
        int count = 1;
        int first = rooms.get(0).end;
        for (Room room : rooms){
            if (room.start >= first){
                count++;
                first = room.end;
            }
        }
        return count;
    }
    // 3. 결혼식
    public int solution3(ArrayList<PartyPerson> people){
        Collections.sort(people);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (PartyPerson person : people){
            if (person.state == 'e') {
                count--;
            }else{
                count++;
            }
            if (count > max)
                max = count;

        }
        return max;
    }
    // 4. 최대 수입 스케쥴
    public int solution4(int n, int max, ArrayList<Lecture> list){
        // PriorityQueue 우선 순위 큐 Collections.reverseOrder() 이렇게 하지 않으면 작은값부터 poll 됨
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        Collections.sort(list);
        int index = 0;
        for(int i = max; i >0; i--){
            for (int j =index; j < n; j++){
                if (list.get(j).time < i){
                    index = j;
                    break;
                }
                pQ.offer(list.get(j).money);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }
    // 5. 다익스트라 알고리즘
    public int[] solution5(){
        Main t = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i =0; i < n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        int[] dis = new int[n+1];
        for (int i =0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        return dis;
    }
    public void solution5Algorithm(ArrayList<ArrayList<Edge>> list, int[] dis){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        while(!pq.isEmpty()){
            Edge tmp  = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (dis[now] < nowCost) continue;
            for (Edge edge : list.get(now)){
                if (dis[edge.vex] > edge.cost + nowCost){
                    dis[edge.vex] = edge.cost + nowCost;
                    pq.offer(new Edge(edge.vex,edge.cost + nowCost));
                }
            }
        }
    }
    // 6. 친구인가(union&find 알고리즘)
    public void solution6(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n+1];
        for (int i = 1; i <=n; i++) unf[i] = i;
        for (int i = 1; i <=m; i++){
            int a= in.nextInt();
            int b= in.nextInt();
            Union(a,b);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }
    public static int Find(int v){
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public void solution7(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i =0; i <=n; i++)
            graph.add(new ArrayList<>());
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i =1; i <=m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a, c));
        }
        solution7Algorithm(new Edge(1,0), graph, dis, n);
    }
    public void solution7Algorithm(Edge first, ArrayList<ArrayList<Edge>> list, int[] dis, int n){
        int answer=0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while(!pQ.isEmpty()){
            Edge tmp=pQ.poll();
            int ev=tmp.vex;
            if(dis[ev]==0){
                dis[ev]=1;
                answer+=tmp.cost;
                for(Edge ob : list.get(ev)){
                    if(dis[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
    public void solution7Union(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf=new int[n+1];
        ArrayList<UnionEdge> arr=new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i]=i;
        for (int i = 1; i <=m; i++){
            int a= in.nextInt();
            int b= in.nextInt();
            int c = in.nextInt();
            arr.add(new UnionEdge(a,b,c));
        }
        Collections.sort(arr);
        int answer = 0;
        for (UnionEdge edge : arr){
            boolean isUnion = EdgeUnion(edge.first, edge.second);
            if (isUnion) answer+= edge.cost;
        }
        System.out.println(answer);
    }
    public static boolean EdgeUnion(int a, int b){
        int fa = EdgeFind(a);
        int fb = EdgeFind(b);
        if (fa != fb){
            unf[fa] = fb;
            return true;
        }
        return false;
    }
    public static int EdgeFind(int v){
        if (v == unf[v]) return v;
        else return unf[v] = EdgeFind(unf[v]);
    }
}
