package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/*
 문제 Link
 - https://www.acmicpc.net/problem/10816

 개념 & 제약사항
 -

 시간 복잡도 계산
 -

 분석과정 & 선택한 자료구조/알고리즘
 - 카드값을 key, value 는 갯수로 hash 를 생성하여 저장한다

 참고자료
 -

 */
public class M_숫자카드2 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> hash = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 상근이가 가지고 있는 숫자카드의 갯수
        int N = sc.nextInt();
        // 상근이의 가드를 hashMap 으로 저장
        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            Integer data = hash.get(val);
            if (data == null) {
                hash.put(val, 1);
            } else {
                hash.put(val, ++data);
            }
        }

        // 문제의 갯수
        int M = sc.nextInt();
        // 문제의 값추출 및 저장
        for (int i = 0; i < M; i++) {
            int val = sc.nextInt();
            Integer data = hash.get(val);
            if (data ==null) {
                sb.append(0).append(" ");
            } else {
                sb.append(hash.get(val)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
