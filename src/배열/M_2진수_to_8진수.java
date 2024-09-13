package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 문제 Link
 - https://www.acmicpc.net/problem/1373

 개념
 - 진수변환

 시간 복잡도 계산
 - O(N)

 아이디어
 - 2진수를 3자리단위로 그룹핑을 하여 변환 (2^2, 2^1, 2^0) 하면 8진수로 표현 가능하다
 
 참고자료
 - https://m.blog.naver.com/javrin4/220956809081

 */
public class M_2진수_to_8진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 결과 저장값
        List<Integer> list = new ArrayList<>();

        // 자리수별 연산 (2^2=4, 2^1=2, 2^0=1)
        // % 3 으로 나누어지는지 확인 (자리수 확인 및 그룹핑)
        int q = str.length() / 3;
        int mod = str.length() % 3;

        // 그룹핑 대상
        int cnt = 1;
        int val = 0;

        if (mod == 1) {
            cnt = 3;
        }
        if (mod == 2) {
            cnt = 2;
        }
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 48;
            if (cnt == 1) {
                val += c * 4;
            } else if (cnt == 2) {
                val += c * 2;
            } else if (cnt == 3) {
                val += c;
                list.add(val);

                // 초기화
                val = 0;
                cnt = 0;
            }
            cnt++;
        }

        // 각 연산결과를 붙여 결과를 출력
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        System.out.println(sb);


    }

}
