package 해시;

import java.util.HashMap;
import java.util.Scanner;

/*
 문제 Link
 - https://www.acmicpc.net/problem/1620

 개념 & 제약사항
 -

 시간 복잡도 계산
 - O(N)

 분석과정 & 선택한 자료구조/알고리즘
 - key-value 관련 문제였으며 hashmap 자료구조를 사용
 - 입력값이 String 또는 Int 이기때문에 2개의 HashMap 을 사용

 참고자료
 -

 */
public class M_포켓몬_마스터 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); // 포켓몬 갯수
        int M = sc.nextInt(); // 문제의 갯수

        //포켓몬 도감 2case 생성
        HashMap<String, Integer> typeA = new HashMap<>();
        HashMap<Integer, String> typeB = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            typeA.put(name, i + 1);
            typeB.put(i + 1, name);
        }

        for (int i = 0; i < M; i++) {
            String q = sc.next();
            if (q.chars().allMatch(Character::isDigit)) {
                sb.append(typeB.get(Integer.parseInt(q))).append('\n');
            } else {
                sb.append(typeA.get(q)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
