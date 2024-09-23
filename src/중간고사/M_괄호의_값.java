package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 문제 Link
 - https://www.acmicpc.net/problem/2504

 개념 & 제약사항
 - 올바른 괄호열을 체크 (잘못된 괄호열은 0으로 출력)
 - 올바른 괄호열은 계산
    - () 는 2
    - [] 는 3
    - (x) 는 2 x 값(x)
    - [X] 는 3 x 값(x)
    - xy 는 x + y

 시간 복잡도 계산
 - O(N)

 분석과정 & 선택한 자료구조/알고리즘
 - 입력값 저장하는 stack
 - 상태 저장 (+x 여부, 결과값)

 참고자료
 - https://velog.io/@rhdmstj17/%EB%B0%B1%EC%A4%80-2504%EB%B2%88-%EA%B4%84%ED%98%B8%EC%9D%98-%EA%B0%92-python-stack-%EC%9E%90%EC%84%B8%ED%95%9C-%ED%92%80%EC%9D%B4
 - https://mjmjmj98.tistory.com/70

 */
public class M_괄호의_값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 입력값을 저장하는 stack
        Stack<Character> input = new Stack<>();

        int answer = 0;
        int temp = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // () = 2
                temp *= 2;
                input.push(str.charAt(i));
            } else if (str.charAt(i) == '[') { // [] = 3
                temp *= 3;
                input.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (input.isEmpty() || input.peek() == '[') { // 비어있는 경우
                    answer = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') { // ( 가 있는 경우
                    answer += temp;
                    temp /= 2; // 초기화
                    input.pop();
                } else { // ( 가 아닌 경우
                    temp /= 2; // 초기화
                    input.pop();
                }

            } else if (str.charAt(i) == ']') {
                if (input.isEmpty() || input.peek() == '(') { // 비어있는 경우
                    answer = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') { // [ 가 있는 경우
                    answer += temp;
                    temp /= 3; // 초기화
                    input.pop();
                } else { // [ 가 아닌 경우
                    temp /= 3; // 초기화
                    input.pop();
                }
            }
        }

        if (!input.isEmpty())
            answer = 0;

        System.out.println(answer);

    }
}
