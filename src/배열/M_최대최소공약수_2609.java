package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 문제
 - https://www.acmicpc.net/problem/2609

 핵심 개념
 - 수학적 개념을 이해하고 해당 내용을 코드로 구현

 시간 복잡도
 - O(n) : gcd 에서 while 문으로 계산
 - GPT 결과 : O(log(min(a, b)))

 사고 과정
 - 두수의 소수를 구하고 저장후 공통분모를 찾아 최대공약수를 찾으려했으나
 유클리드 호제법을 발견함. 수학적 개념으로 쉽게 풀 수 있는 문제였음

 참고
 - 최대공약수, 최소공약수 : https://post.naver.com/viewer/postView.naver?volumeNo=6788621&memberNo=15932120
 - 수학-소수와-합성수란: https://foodiehealth.tistory.com/entry/%EC%A4%91-1-%EC%88%98%ED%95%99-%EC%86%8C%EC%88%98%EC%99%80-%ED%95%A9%EC%84%B1%EC%88%98%EB%9E%80
 - 유클리드 호제법 : https://velog.io/@e414/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%A0%95%EC%88%98%EB%A1%A0-%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%ED%98%B8%EC%A0%9C%EB%B2%95
 - 유클리드 호재법 youtube : https://www.youtube.com/watch?v=TxdljAFjTNw

 */
public class M_최대최소공약수_2609 {
    public static void main(String[] args) throws IOException {
        // 데이터준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        // 로직
        // a > b 가 아닌 경우 a와 b를 바꿔준다.
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 유클리드 호재법
        int gcd = gcdLogic(a, b);
        int lcm = a * b / gcd;

        // 출력
        System.out.println(gcd);
        System.out.println(lcm);
    }

    /*
        1. 큰 수를 작은 수로 나누는 MOD 연산을 수행한다.
        2. 앞 단계에서 작은 수와 MOD 연산 결괏값(나머지)으로 MOD 연산을 수행한다.
        3. 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택한다.
     */
    private static int gcdLogic(int a, int b) {
        int mod = a % b;
        while (mod != 0) {
            a = b;
            b = mod;
            mod = a % b;
        }
        return b;
    }
}
