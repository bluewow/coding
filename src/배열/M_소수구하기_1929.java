package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;

/*
 문제
 - https://www.acmicpc.net/problem/1929

 아이디어
 - 에라토스테네스 체를 end 범위까지 적용하여 소수를 제외한 나머지 수를 소거한다

 접근방식
 1. end 범위를 가져온다
 2. 2부터 시작하여 end 범위까지 배수를 소거한다
 2-1. 이후 소거되지 않았다면 3부터 반복. 소거되었다면 pass
 3. 소거를 제외한 나머지 소수를 순차적으로 출력한다

 시간 복잡도
 -

 참고
 - 에라토스테네스의 체 https://www.ebsmath.co.kr/resource/rscView?cate=10094&cate2=10101&cate3=10114&rscTpDscd=RTP10&grdCd=MGRD01&sortType=B&mngtPrdnYn=&menuType=t&itemSize=15&level=%5BDIF01%2C%20DIF02%2C%20DIF03%2C%20DIF06%2C%20DIF07%2C%20DIF08%2C%20DIF09%2C%20DIF10%2C%20DIF11%5D&type=S&sno=19814&historyYn=study&evtSsnCd=&utm_source=blog&utm_medium=link&utm_campaign=card_m1_19814
 - 소수판별 3가지 방법 https://sfida.tistory.com/28

 */
public class M_소수구하기_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        // end 범위를 가져온다 array
        int[] arr = new int[end + 1];

        // 2부터 시작하여 end 범위까지 배수를 소거한다
        // 이후 소거되지 않았다면 3부터 반복. 소거되었다면 pass
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            // 소수가 아닌수는 제외
            if (arr[i] != -1) {
                for (int j = i*i; j <= end; j+=i) {
                    arr[j] = -1;
                }
            }
        }

        // 소거를 제외한 나머지 소수를 순차적으로 출력한다
        for (int i = 1; i <= end; i++) {
            if (arr[i] == -1)
                continue;

            if (i < start)
                continue;

            System.out.println(i);
        }
    }
}
