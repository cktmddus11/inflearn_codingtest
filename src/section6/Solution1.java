package section6;

import java.util.Arrays;

/**
 * packageName    : section6
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-01-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-26        Cha       최초 생성
 *
 * 선택정렬
 *    이중루프, 바깥쪽, i, 내부 j
 *   바깥쪽 i를 기준값으로 하고 내부 j = i+1 와 비교함
 *   왜냐하면 j를 돌면서 기준값보다 작은 값이 있으면 기준값의 위치를 그 위치로 옮기기 때문에
 *   기준값에는 가장 작은곳이 값에 위치를 저장하고 있게 됨.
 *   그러고 나서 i와 기준값 값을 교환해주면 i 앞쪽부터 작은 숫자가 위치하게 됨.
 *
 *
 *
 */
public class Solution1 {
    public static void main(String[] args){
        int n = 6;
        int arr[] = {13, 5, 11, 7, 23, 15};

        for(int i = 0; i<arr.length;i++){
            int idx = i;
            for(int j = i+1;j<arr.length-1;j++){ // j 의 비교를 -1 해두는 이유 : 앞에서 이미 교환했으면 맨뒤값은 큰값이 와있기 때문에.
                if(arr[idx] > arr[j]){ // 기준 위치보다 비교하는 값이 더 작으면 위치를 저장한다.
                    idx = j;
                }
            }
            // 반복이 종료되면 idx에는 가장 작은 값의 위차가 저장되어있기 때문에 현재 시작점인 i와 교환한다.
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
            System.out.println(Arrays.toString(arr));
        }




    }
}
