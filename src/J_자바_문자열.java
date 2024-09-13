import java.util.ArrayList;
import java.util.List;

public class J_자바_문자열 {
    public static void main(String[] args) {
        문자열_인덱싱();
        문자열_슬라이싱();
        특정문자_확인();
        문자열이_같은지_비교();
        문자열_길이반환();
        문자열_구분자기준으로_나누고_합치기();
        문자열_대소문자_변환();
        양쪽끝_특정문자_제거();
        아스키코드_변환();
        문자열_대소비교();
        List을_String으로_변환();

    }

    private static void List을_String으로_변환() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        String str = String.join("", list);
        System.out.println(str); // HelloWorldJava
    }

    private static void 문자열_대소비교() {
        String str1 = "Hello";
        String str2 = "hello";
        System.out.println(str1.compareTo(str2)); // -32
        System.out.println(str1.compareToIgnoreCase(str2)); // 0
        // 음수: str1이  앞
        // 양수: str1이  뒤
        // 0: str1과 str2가 동일
    }

    private static void 아스키코드_변환() {
        char c = 'A';
        System.out.println((int) c); // 65

        int i = 65;
        System.out.println((char) i); // A
    }

    private static void 양쪽끝_특정문자_제거() {
        String str = "     hello    ";
        System.out.println(str.trim()); // hello

        String str1 = "123hello1";
        System.out.println(str1.replaceAll("[0-9]", "")); // hello
    }

    private static void 문자열_대소문자_변환() {
        String str = "Hello";
        System.out.println(str.toUpperCase()); // HELLO
        System.out.println(str.toLowerCase()); // hello
    }

    private static void 문자열_구분자기준으로_나누고_합치기() {
        String str = "h,e,l,l,o";
        str = str.replace(",", "");
        System.out.println(str); // hello

        String str1 = "h,e,l,l,o";
        String[] split = str1.split(",");
        System.out.println(split[0] + split[1] + split[2] + split[3] + split[4]); // h e l l o
    }

    private static void 문자열_길이반환() {
        String str = "Hello";
        System.out.println(str.length()); // 5
    }

    private static void 문자열이_같은지_비교() {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1 == str2); // true

        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println(str3.equals(str4)); // true
        System.out.println(str3 == str4); // false
    }

    private static void 특정문자_확인() {
        String str = "Hello";
        System.out.println(str.contains("H")); // true
        System.out.println(str.contains("z")); // false
        System.out.println(str.indexOf("H")); // 0
        System.out.println(str.indexOf("z")); // -1
    }

    private static void 문자열_슬라이싱() {
        String str = "Hello";
        System.out.println(str.substring(0, 2)); // He
        System.out.println(str.substring(1, 3)); // el
        System.out.println(str.substring(2, 4)); // ll
        System.out.println(str.substring(3, 5)); // lo
        System.out.println(str.substring(2)); // llo
    }

    private static void 문자열_인덱싱() {
        String str = "Hello";
        System.out.println(str.charAt(0)); // H
        System.out.println(str.charAt(1)); // e
        System.out.println(str.charAt(2)); // l
        System.out.println(str.charAt(3)); // l
        System.out.println(str.charAt(4)); // o
    }
}
