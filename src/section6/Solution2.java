package section6;

import java.util.Arrays;

/**
 * packageName    : section6
 * fileName       : Solution2
 * author         : Cha
 * date           : 2024-01-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-26        Cha       최초 생성
 *
 * 2. 버블정렬
 * 바깥루프 i, 내부 루프 j 이중루프
 * 바깥루프는 i부터 n번
 * j는 0 시작하며 i 보다 j가 더 크면 교환 하지 않습니다.
 * j 는 -1 번 반복하게 됩니다. 왜냐하면 내부루프를 반복할 수록 최대값이 뒤쪽으로 정렬되기 때문입니다.
 *
 *
 */
public class Solution2 {
    public static void main(String[] args){
        int n = 6;
        int arr[] = {13, 17, 11, 7, 23, 15};

        for(int i = 0;i<n-1;i++){
            for(int j = 0;j< n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }



    }
}
