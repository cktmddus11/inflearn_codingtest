import java.util.*;

public class HashMapTest {
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
    // 4. 모든 안나그램 찾기
    private int solution4(String a, String b){
        HashMap<Character, Integer> aHashMap = new HashMap<>();
        HashMap<Character, Integer> bHashMap = new HashMap<>();
        for (int i =0;i<b.length();i++){
            aHashMap.put(b.charAt(i), aHashMap.getOrDefault(b.charAt(i),0)+1);
            bHashMap.put(a.charAt(i),bHashMap.getOrDefault(a.charAt(i),0)+1);
        }
        int m = b.length();
        int answer = 0;
        if (bHashMap.equals(aHashMap)) answer++;
        for (int i =b.length(); i < a.length();i++){
            int tmp = bHashMap.get(a.charAt(i-m));
            if (tmp == 1) bHashMap.remove(a.charAt(i-m));
            else bHashMap.put(a.charAt(i-m), tmp-1);
            bHashMap.put(a.charAt(i),bHashMap.getOrDefault(a.charAt(i),0)+1);
            if (bHashMap.equals(aHashMap)) answer++;
        }
        return answer;
    }
    // k번째 큰 수
    private int solution5(int n, int m, int[] arr){
        int answer = -1;
        TreeSet<Integer> map = new TreeSet<>(Collections.reverseOrder());
        for (int i =0; i <n; i++){
            for (int j=i+1; j < n; j++){
                for (int k =j+1;  k <n; k++){
                    map.add(arr[i] +arr[j] + arr[k]);
                }
            }
        }
        int count = 0;
        for (int key : map){
            count++;
            if (count == m){
                return key;
            }

        }
        return answer;
    }
}
