package 스택_큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 문제 Link
 - https://www.acmicpc.net/problem/1406

 개념 & 제약사항
 - 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치
 - L : 커서를 왼쪽으로 한 칸 옮김
 - D : 커서를 오른쪽으로 한 칸 옮김
 - B : 커서 왼쪽에 있는 문자를 삭제함. 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
 - P $ : $라는 문자를 커서 왼쪽에 추가함

 시간 복잡도 계산
 - O(N)

 분석과정 & 선택한 자료구조/알고리즘
 - 자유로운 삽입, 삭제를 위하여 LinkedList 사용
 - 상태값 (커서위치)

 참고자료
 -

 */
public class M_에디터 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = in.next();
        int count = in.nextInt();

        int curPos = str.length();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        for (int i = 0; i < count; i++) {
            String next = in.next();
            switch (next) {
                case "P":
                    list.add(curPos, in.next().charAt(0));
                    curPos += 1;
                    break;
                case "L":
                    if (curPos != 0) curPos -= 1;
                    break;
                case "D":
                    if (curPos != list.size()) curPos += 1;
                    break;
                case "B":
                    if (curPos != 0) {
                        curPos -= 1;
                        list.remove(curPos);
                    }
                    break;
            }
        }

        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);


    }
}
