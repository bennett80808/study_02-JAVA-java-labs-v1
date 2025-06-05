package chapter1.labs.lab4;

/**
 * Lab 4: 자바 연산자 실습
 * 
 * 이 실습은 자바의 다양한 연산자를 이해하고 활용하는 것을 목표로 합니다.
 */
public class OperatorsLab {
    public static void main(String[] args) {
        // TODO: 1. 산술 연산자 사용하기
        // 두 개의 정수형 변수를 선언하고 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산을 수행하세요.
        int a = 10;
        int b = 2;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        
        // TODO: 2. 증감 연산자 사용하기
        // 변수를 선언하고 전위 증가, 후위 증가, 전위 감소, 후위 감소 연산을 수행하세요.
        // 각 단계별로 변수의 값을 출력하여 변화를 확인하세요.
        int c = 0;


        int num = 0; // 변수 선언 및 초기화
        System.out.println("\n초기 num = " + num);

        // 전위 증가
        System.out.println("전위 증가 (++num) = " + (++num));
        System.out.println("전위 증가 후 num = " + num);

        // 후위 증가
        System.out.println("후위 증가 (num++) = " + (num++));
        System.out.println("후위 증가 후 num = " + num);

        // 전위 감소
        System.out.println("전위 감소 (--num) = " + (--num));
        System.out.println("전위 감소 후 num = " + num);

        // 후위 감소
        System.out.println("후위 감소 (num--) = " + (num--));
        System.out.println("후위 감소 후 num = " + num);




        // TODO: 3. 비교 연산자 사용하기
        // 두 변수를 비교하여 결과를 출력하세요 (==, !=, >, <, >=, <=).
        int d = 1;
        int e = 2;
        System.out.println("\nd == e: " + (d==e));
        System.out.println("d != e: " + (d!=e));
        System.out.println("d > e: " + (d>e));
        System.out.println("d < e: " + (d<e));
        System.out.println("d >= e: " + (d>=e));
        System.out.println("d <= e: " + (d<=e));
        
        // TODO: 4. 논리 연산자 사용하기
        // boolean 변수를 사용하여 AND(&&), OR(||), NOT(!) 연산을 수행하세요.
        boolean A = true;
        boolean B = false;

        System.out.println("\nA&&B: " + (A&&B));
        System.out.println("A||B: " + (A||B));
        System.out.println("!A: " + (!A));

        // TODO: 5. 대입 연산자 사용하기
        // 변수를 선언하고 복합 대입 연산자(+=, -=, *=, /=, %=)를 사용하여 값을 변경하세요.
        int a11 = 10;

        a11+=2;
        System.out.println("\na11+=2 =" + a11);

        a11-=2;
        System.out.println("a11-=2 =" + a11);

        a11*=2;
        System.out.println("a11*=2 =" + a11);

        a11/=2;
        System.out.println("a11/=2 =" + a11);

        a11%=2;
        System.out.println("a11%=2 =" + a11);
        
        // TODO: 6. 삼항 연산자 사용하기
        // 조건에 따라 다른 값을 할당하는 예제를 작성하세요.
        int a2 = 10;
        int b2 = 20;

        int max = (a2 > b2) ? a2 : b2;
        System.out.println("\n큰 수: " + max);

    }
} 