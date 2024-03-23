import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Bricks implements Comparable<Bricks>{
    public int width;
    public int height;
    public int weight;
    public Bricks(int width, int height, int weight){
        this.width = width;
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Bricks bricks){
        return bricks.width - this.width;
    }
}
class MaxPoint implements Comparable<MaxPoint>{
    public int time;
    public int point;
    public MaxPoint(int point,int time){
        this.time = time;
        this.point = point;
    }
    @Override
    public int compareTo(MaxPoint other){
        return this.time-other.time;
    }
}

public class DpTest {
    static int[] dy;

    // 1. 계단 오르기
    public void solution1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];

        dy[1] = 1;
        dy[2] = 2;
        for (int i =3; i <= n; i++){
            dy[i] = dy[i-2] +dy[i-1];
        }
        System.out.println(dy[n]);
    }
    // 2. 돌다리 건너기
    public void solution2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+2];

        dy[1] = 1;
        dy[2] = 2;
        for (int i =3; i <= n+1; i++){
            dy[i] = dy[i-2] +dy[i-1];
        }
        System.out.println(dy[n+1]);
    }
    // 3. 최대 부분 증가 수열
    public void solution3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        dy = new int[n];
        dy[0] = 1;
        int answer = 0;
        for (int i=0; i < n; i++) arr[i] = sc.nextInt();
        for (int i=1; i < n; i++){
            int tmp = arr[i];
            int max = 0;
            for (int j = i-1; j >= 0; j--){
                if (arr[j] < tmp){
                    if (dy[j] > max)
                        max = dy[j];
                }
            }
            dy[i] = max+1;
            answer = Math.max(answer,dy[i]);
        }
        System.out.println(answer);
    }
    //4. 가장 높은 탑 쌓기
    public void solution4(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Bricks> arrayList = new ArrayList<>();
        int n = sc.nextInt();
        for (int i =0;i <n;i++){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int we = sc.nextInt();
            arrayList.add(new Bricks(w,h,we));
        }
        dy = new int[n];
        Collections.sort(arrayList);
        dy[0] = arrayList.get(0).height;
        int answer = 0;
        for (int i =1;i <n;i++){
            int tmpWeight = arrayList.get(i).weight;
            int tmpHeight = arrayList.get(i).height;
            int max = 0;
            for (int j = i-1; j >= 0; j--){
                if (tmpWeight < arrayList.get(j).weight && max < dy[j]){
                    max = dy[j];
                }
            }
            dy[i] = max + arrayList.get(i).height;
            if (answer < dy[i]) answer = dy[i];
        }
        System.out.println(answer);
    }
    // 5. 동전 교환(납색 알고리즘)
    public void solution5(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        dy = new int[m+1];
        for (int i =1; i <= m; i++){
            dy[i] = Integer.MAX_VALUE;
        }
        dy[1] = 0;
        for (int i =0; i < n; i++){
            int a = arr[i];
            for (int j =a; j <= m; j++){
                if (dy[j-a] < a){
                    dy[j] = dy[j-a] + 1;
                }
            }
        }
        System.out.println(dy[m]);
    }
    // 6. 최대 점수 구하기
    public void solution6(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<MaxPoint> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            int x= sc.nextInt();
            int y =sc.nextInt();
            list.add(new MaxPoint(x,y));
        }
        dy = new int[m+1];
        dy[list.get(0).time] = list.get(0).point;
        for (int i =1; i<=m;i++) dy[i] = 0;
        for (int i =0; i < n;i++){
            int tmp = list.get(i).time;
            int tmpPoint = list.get(i).point;
            for (int j =m; j>=tmp;j--){
                if (dy[j-tmp] + tmpPoint >= dy[j])
                    dy[j] = tmpPoint +dy[j-tmp];
            }
        }

        System.out.println(dy[m]);
    }
}
