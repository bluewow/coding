package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 문제 Link
 - https://www.acmicpc.net/problem/10773

 개념 & 제약사항
 - 잘못된 수를 부를때 0 을 호출. 최근에 쓴 수를 지움

 시간 복잡도 계산
 - O(n)

 분석과정 & 선택한 자료구조/알고리즘
 - 자료구조 : Stack (최근에 쓴 수를 지운다)

 참고자료
 -

 */
public class M_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        // 0 인경우 pop, 그밖에 값은 stack 에 쌓는다
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        // stack 에 쌓인값을 출력
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        System.out.println(total);
    }
}
