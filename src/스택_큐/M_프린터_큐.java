package 스택_큐;

import java.util.LinkedList;
import java.util.Scanner;

/*
 문제 Link
 - https://www.acmicpc.net/problem/1966

 개념 & 제약사항
 - 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인
 - 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.

 시간 복잡도 계산
 - O(N^2)

 분석과정 & 선택한 자료구조/알고리즘
 -

 참고자료
 - https://st-lab.tistory.com/201
 - https://sookr5416.tistory.com/250

 */
public class M_프린터_큐 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        while (T-- > 0) {
            // 데이터 꺼내오기
            LinkedList<int[]> q = new LinkedList<>();
            int N = in.nextInt();
            int M = in.nextInt();
            for (int i = 0; i < N; i++) {
                q.add(new int[] {i, in.nextInt()});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                boolean isHigher = true;

                for (int[] curQ : q) {
                    if (curQ[1] > cur[1]) {
                        isHigher = false;
                        break;
                    }
                }

                if (isHigher) {
                    count++;
                    if (cur[0] == M) break;
                } else {
                    q.add(cur);
                }
            }

            System.out.println(count);
        }
    }
}
