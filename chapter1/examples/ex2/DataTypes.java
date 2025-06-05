package chapter1.examples.ex2;

/**
 * 자바의 기본 데이터 타입과 변수 사용 예제
 */
public class DataTypes {
    public static void main(String[] args) {
        // 정수형 데이터 타입
        byte byteValue = 10;            // 1바이트, -128 ~ 127
        short shortValue = 1000;        // 2바이트, -32,768 ~ 32,767
        int intValue = 100000;          // 4바이트, -2^31 ~ 2^31-1
        long longValue = 1000000000L;   // 8바이트, -2^63 ~ 2^63-1

        // 실수형 데이터 타입
        float floatValue = 3.14f;       // 4바이트, 부동소수점
        double doubleValue = 3.14159;   // 8바이트, 부동소수점 (기본 실수 타입)

        // 문자형 데이터 타입
        char charValue = 'A';           // 2바이트, 유니코드 문자

        // 논리형 데이터 타입
        boolean booleanValue = true;    // 1비트, true 또는 false

        // 데이터 출력
        System.out.println("===== 기본 데이터 타입 =====");
        System.out.println("byte 값: " + byteValue);
        System.out.println("short 값: " + shortValue);
        System.out.println("int 값: " + intValue);
        System.out.println("long 값: " + longValue);
        System.out.println("float 값: " + floatValue);
        System.out.println("double 값: " + doubleValue);
        System.out.println("char 값: " + charValue);
        System.out.println("boolean 값: " + booleanValue);
        
        // 타입별 최대값과 최소값
        System.out.println("\n===== 데이터 타입 범위 =====");
        System.out.println("byte 범위: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("short 범위: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        System.out.println("int 범위: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("long 범위: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
        System.out.println("float 범위: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
        System.out.println("double 범위: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
    }
} 