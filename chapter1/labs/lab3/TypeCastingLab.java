package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 * 
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로 
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기
        byte a = 127;
        int b = a;
        long c = b;
        float d = c;
        double e = d;

        System.out.println("byte -> int :" + b);
        System.out.println("int -> long :" + c);
        System.out.println("long -> float :" + d);
        System.out.println("float -> double :" + e);
        
        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기

        double f = 35.0;
        float g = (float)f;
        long h = (long)g;
        int i = (int)h;
        char j = (char)i;
        short k = (short)j;
        byte l = (byte)k;


        System.out.println("\ndouble -> float: " + g);
        System.out.println("float -> long: " + h);
        System.out.println("long -> int: " + i);
        System.out.println("int -> char: " + j);
        System.out.println("char -> short: " + k);
        System.out.println("short -> byte: " + l);
        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기

        int a1 = 2147483647;
        byte b1 = 126;
        byte c1 = (byte)a1;
        System.out.println("\nint -> byte: " + c1);


        
        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기
        String a2 = "123";
        int b2 = Integer.parseInt(a2);
        System.out.println("\nint -> int: " + b2);

        String a3 = "3.14";
        double b3 = Double.parseDouble(a3);
        System.out.println("\ndouble -> double: " + b3);

        
        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기
        int num = 456;
        String a4 = String.valueOf(num);
        System.out.println("\nint -> String: " + a4);

        double num2= 7.89;
        String a5 = String.valueOf(num2);
        System.out.println("\ndouble -> String: " + a5);


    }
} 