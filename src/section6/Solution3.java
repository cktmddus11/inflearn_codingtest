package section6;

import java.util.Arrays;

/**
 * packageName    : section6
 * fileName       : Solution3
 * author         : Cha
 * date           : 2024-01-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-26        Cha       최초 생성
 * <p>
 * 3. 삽입정렬
 * 바깥루프 i, 내부 루프 j
 * 바깥루프는 1부터 시작한다. j 는 i -1 부터 감소하며 진행한다.
 * 작은 값이 앞으로 오도록 값을 밀어주는 방식으로 j 값이 i 값보다 크면
 * i 위치에 j값을 넣고 i 의 값을 tmp 에 임시보관한다. 뒤로갈수록 큰값을 넣게 하기 위함.이다.
 * 내부루프가 종료되면  tmp 의 값을 i+1 위치에 넣어준다.
 */
public class Solution3 {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = {11, 7, 5, 6, 10, 9};

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
            System.out.println(Arrays.toString(arr));
        }

    }
}
