package 스택_큐;

import java.util.LinkedList;
import java.util.Scanner;

/*
 문제 Link
 - https://www.acmicpc.net/problem/2164

 개념 & 제약사항
 - 1. 제일 위의 카드를 버린다
 - 2. 제일 위의 카드를 아래로 옮긴다
 - 3. 하나가 남을때까지 반복

 시간 복잡도 계산
 -

 분석과정 & 선택한 자료구조/알고리즘
 - deque

 참고자료
 -

 */
public class M_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정수 N
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        // 3. 하나가 남을때까지 반복
        while(list.size() != 1) {
            // 1. 제일 위의 카드를 버린다
            list.removeFirst();
            // 2. 제일 위의 카드를 아래로 옮긴다
            Integer val = list.pollFirst();
            list.addLast(val);
        }
        System.out.println(list.poll());
    }
}
