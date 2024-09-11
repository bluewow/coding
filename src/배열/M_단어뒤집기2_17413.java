package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 문제
 - https://www.acmicpc.net/problem/17413

 복습
 - 태그와 단어를 나누고 저장하는 방법
 - 단어를 구분할 수 있는 조건을 명확히 하고 풀었으면 금방 풀지 않았을까?

 시간 복잡도
 - O(n)

 사고 과정
 1. 
 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
 [v] 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열
 [v] 연속하는 두 단어는 공백 하나로 구분한다
 [v] 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.  '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
 태그는 어떻게 판별할까? 입력된 값을 char 로 나누어 판별해보자. < 가 나왔다면 > 나올때까지는 Tag 이다
 단어는 어떻게 뒤집을까? StringBuilder 의 reverse 를 이용한다
 언제 단어를 뒤집을까? 태그 상태가 아니며, 공백이 발생하였을떄 단어를 뒤집는다
 
 
 2. 풀다보니깐 예외 케이스가 많아서 다른방법 시도
    데이터는 언제 넣으면 좋을까?
    - < 만났을때 이전 데이터
    - ' ' 일때 이전 데이터 && tag 상태가 아니여야 한다
    - 마지막에 태그없이 단어가 있는 경우


 */
public class M_단어뒤집기2_17413 {
    public static void main(String[] args) throws IOException {
        //준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data  = br.readLine();

//        데이터는 언제 넣으면 좋을까?
//        - < 만났을때 이전 데이터
//        - > 만났을때 이전 데이터
//        - ' ' 일때 이전 데이터 && tag 상태가 아니여야 한다
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            sb.append(c);
            if (c== ' ' && !isTag) {
                list.add(sb.reverse().toString().trim() + ' ');
                sb = new StringBuilder();
                continue;
            }

            if (c == '>') {
                isTag = false;
                list.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }

            if (c == '<') {
                isTag = true;
                // sb 에 데이터를 추가한다
                if (sb.length() > 0) {
                    list.add(sb.reverse().substring(1, sb.length()) + '<');
                    sb = new StringBuilder();
                }
            }
        }

        if (sb.length() > 0) {
            list.add(sb.reverse().toString());
        }


        // 치환
        System.out.println(String.join("", list));
    }
}
