package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 문제 Link
 - https://www.acmicpc.net/problem/1935

 개념 & 제약사항
 - 피연산자의 갯수는 (A ~ Z) 26개임

 시간 복잡도 계산
 - O(N)

 분석과정 & 선택한 자료구조/알고리즘
 - 알파벳 치환후 stack 저장
    - 입력값을 저장한 배열을 가지고 알파벳을 치환!!
 - 연산자인 경우 계산

 참고자료
 -

 */
public class M_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine()); // 피연산자의 갯수
        Double[] values = new Double[count]; // 입력값
        String input = br.readLine(); // 후위 표기식

        for (int i = 0; i < count; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 알파벳은 push
            if (ch >= 'A' && ch <= 'Z') {
                stack.push(values[ch - 'A']);
            } else {
                // 연산자는 계산
                Double b = stack.pop();
                Double a = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        // 소수점 2자리까지 출력
        System.out.printf("%.2f", stack.pop());
    }
}
