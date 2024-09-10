package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 문제
 - https://www.acmicpc.net/problem/11720
 핵심 개념
 - 문자열 다루기
 시간 복잡도
 - O(N)
 */
public class M_숫자의합_11720 {
    public static void main(String[] args) throws IOException {
        // 데이터 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] array = str.toCharArray();

        // 계산
        int value = 0;
        for (int i = 0; i < num; i++) {
            char c = array[i];
            value += Integer.parseInt(String.valueOf(c));
        }
        System.out.println(value);
    }

}
