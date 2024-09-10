package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 문제
 - https://www.acmicpc.net/problem/1157

 핵심 개념
 - 자료구조 HashMap 를 다룰줄 아는가?

 시간 복잡도
 - 준비 O(N), 로직 O(N), 최대값 찾기 O(N) => O(N)

 사고 과정
 - 문자열을 넣는 자료공간을 HashMap 으로 선언. 
 key: 알파뱃, value: 사용된 횟수. max 값을 찾을경우 결과 알파뱃을 저장하였으며,
 이후 동일한 value 가 나오면 중복되었다고 생각되어 result 값 갱신

 복기
 - 배열을 이용하여 문제를 푸는 문제였음

 참고
 https://www.acmicpc.net/source/30036402
 */
public class M_단어공부_1157 {
    public static void main(String[] args) throws IOException {
        //데이터 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();

        //로직
        //1. str 길이만큼 for 문
        for (int i = 0; i < str.length(); i++) {
            //2. 문자열을 가져온다
            char c = str.charAt(i);
            //3. map 에 저장
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //4. map 에 저장된 값 중 최대값을 찾는다
        int max = 0;
        char result = '?';
        for (Character c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                result = c;
                continue;
            }

            if (map.get(c) == max) {
                result = '?';
            }
        }

        // 결과
        System.out.println(result);
    }
}
