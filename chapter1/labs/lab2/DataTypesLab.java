package chapter1.labs.lab2;

/**
 * Lab 2: 자바 데이터 타입 실습
 * 
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당
        byte a = 127;
        short b = 127;
        int c = 127;
        long d = 127L;


        
        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float e = 127.0f;
        double f = 127.0d;
        
        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char g = 'A';
        
        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean h = true;
        
        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        
        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고 
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        double height = 1.8;
        double kg = 95.5;
        double bmi = kg / (height*height);
        System.out.println(bmi);
    }
} 