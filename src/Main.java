import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i =0; i < n; i++)
            arr[i] = in.nextInt();
        ArrayList<Integer> test = t.solution3(n,m,arr);
        for (int data : test)
            System.out.print(data + " ");

    }
    // 1. 학습 회장
    private char solution1(int n, String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char data : str.toCharArray()){
            map.put(data, map.getOrDefault(data,0)+1);
        }
        int max = Integer.MIN_VALUE;
        char answer = 0;
        for (char data : str.toCharArray()){
            if (map.get(data) > max){
                max = map.get(data);
                answer = data;
            }
        }
        return answer;
    }
    // 2. 아나그램
    private String solution2(String str1, String str2){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char data : str1.toCharArray()){
            map.put(data, map.getOrDefault(data,0)+1);
        }
        for (char data : str2.toCharArray()){
            map2.put(data, map2.getOrDefault(data,0)+1);
        }
        for (char data : str2.toCharArray()){
            if (!Objects.equals(map.get(data), map2.get(data))){
                answer = "NO";
                break;
            }
        }
        return answer;
    }

    // 3. 매출액의 종류
    private ArrayList<Integer> solution3(int n, int m, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map =new HashMap<>();
        for (int j = 0; j < m; j ++){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
        }
        answer.add(map.size());
        for (int i =m; i < n; i++){
            int tmp = map.get(arr[i-m]);
            if (tmp == 1)
                map.remove(arr[i-m]);
            else
                map.put(arr[i-m], tmp-1);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            answer.add(map.size());
        }
        return answer;
    }
}