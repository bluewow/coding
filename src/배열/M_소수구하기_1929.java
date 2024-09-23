package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*
 문제 Link
 - https://www.acmicpc.net/problem/1929

 개념
 - 소수, 에라토스테네스의 체

 시간 복잡도 계산
 - O(N)

 참고자료
 - https://sfida.tistory.com/28

 */
public class M_소수구하기_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        List<Integer> list = new ArrayList<>();
        // end 의 소수를 구한다
        for (int i = 2; i <= end; i++) {
            if (isPrime(i))
                list.add(i);
        }

        // start 이하는 버린다
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= start)
                System.out.println(list.get(i));
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
