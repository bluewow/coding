package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 문제 Link
 - https://www.acmicpc.net/problem/9012

 개념 & 제약사항
 - 괄호문자열이 페어하게(VPS) 구성되었는지 체크
 - (()) 겹겹히 구성된 경우 OK
 - ()() 접합시킨 문자열도 OK

 시간 복잡도 계산
 - O(N^2)

 분석과정 & 선택한 자료구조/알고리즘
 - 페어한 경우 pop 실행
 - pop 할 대상이 없는 경우 잘못됨 출력

 참고자료
 -

 */
public class M_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Character> input = new Stack<>();

        for (int i = 0; i < count; i++) {

            // 입력값 확인
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    input.push('(');
                } else {
                    if (input.empty()) {
                        break;
                    } else {
                        input.pop();
                    }
                }
            }

            if (input.isEmpty())
                System.out.println("YES");
            else {
                System.out.println("NO");
                input.clear();
            }
        }

    }
}
