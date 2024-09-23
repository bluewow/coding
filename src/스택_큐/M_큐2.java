package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 문제 Link
 - https://www.acmicpc.net/problem/18258

 개념 & 제약사항
 - Queue (LinkedList)

 시간 복잡도 계산
 - O(N)

 분석과정 & 선택한 자료구조/알고리즘
 - queue 에 대한 이해
 - 시간 초과로 인해 new StringBuilder 를 사용함

 참고자료
 -

 */
public class M_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList();

        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            switch (s[0]) {
                case "push":
                    int val = Integer.parseInt(s[1]);
                    queue.add(val);
                    break;
                case "front":
                    if (queue.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(queue.peek()).append('\n');
                    break;
                case "back":
                    if (queue.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(queue.peekLast()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "pop":
                    if (queue.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(queue.poll()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
