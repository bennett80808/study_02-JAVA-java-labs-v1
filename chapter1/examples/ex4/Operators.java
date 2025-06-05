package chapter1.examples.ex4;

/**
 * 자바의 연산자 사용 예제
 */
public class Operators {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        
        // 1. 산술 연산자
        System.out.println("===== 산술 연산자 =====");
        System.out.println("a + b = " + (a + b));  // 덧셈
        System.out.println("a - b = " + (a - b));  // 뺄셈
        System.out.println("a * b = " + (a * b));  // 곱셈
        System.out.println("a / b = " + (a / b));  // 나눗셈 (몫)
        System.out.println("a % b = " + (a % b));  // 나머지
        
        // 2. 증감 연산자
        System.out.println("\n===== 증감 연산자 =====");
        int c = 5;
        System.out.println("c = " + c);
        System.out.println("++c = " + (++c));  // 전위 증가 (먼저 증가 후 사용)
        System.out.println("c++ = " + (c++));  // 후위 증가 (사용 후 증가)
        System.out.println("c = " + c);
        System.out.println("--c = " + (--c));  // 전위 감소 (먼저 감소 후 사용)
        System.out.println("c-- = " + (c--));  // 후위 감소 (사용 후 감소)
        System.out.println("c = " + c);
        
        // 3. 비교 연산자
        System.out.println("\n===== 비교 연산자 =====");
        System.out.println("a == b: " + (a == b));  // 같음
        System.out.println("a != b: " + (a != b));  // 다름
        System.out.println("a > b: " + (a > b));    // 크다
        System.out.println("a < b: " + (a < b));    // 작다
        System.out.println("a >= b: " + (a >= b));  // 크거나 같다
        System.out.println("a <= b: " + (a <= b));  // 작거나 같다
        
        // 4. 논리 연산자
        System.out.println("\n===== 논리 연산자 =====");
        boolean x = true;
        boolean y = false;
        System.out.println("x && y: " + (x && y));  // 논리 AND
        System.out.println("x || y: " + (x || y));  // 논리 OR
        System.out.println("!x: " + (!x));          // 논리 NOT
        
        // 5. 대입 연산자
        System.out.println("\n===== 대입 연산자 =====");
        int d = 10;
        System.out.println("d = " + d);
        d += 5;  // d = d + 5와 동일
        System.out.println("d += 5: " + d);
        d -= 3;  // d = d - 3와 동일
        System.out.println("d -= 3: " + d);
        d *= 2;  // d = d * 2와 동일
        System.out.println("d *= 2: " + d);
        d /= 4;  // d = d / 4와 동일
        System.out.println("d /= 4: " + d);
        d %= 3;  // d = d % 3와 동일
        System.out.println("d %= 3: " + d);
        
        // 6. 비트 연산자
        System.out.println("\n===== 비트 연산자 =====");
        int e = 5;  // 이진수로 101
        int f = 3;  // 이진수로 011
        System.out.println("e & f: " + (e & f));   // 비트 AND
        System.out.println("e | f: " + (e | f));   // 비트 OR
        System.out.println("e ^ f: " + (e ^ f));   // 비트 XOR
        System.out.println("~e: " + (~e));         // 비트 NOT
        System.out.println("e << 1: " + (e << 1)); // 왼쪽 시프트
        System.out.println("e >> 1: " + (e >> 1)); // 오른쪽 시프트
    }
} 