package chapter4.labs.lab3;



/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    // final 상수 - 선언과 동시에 초기화
    public static final double PI = 3.14159265359;

    
    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    // final 필드 - 선언만 하고 생성자에서 초기화 가능
    private final String name;

    // final 필드 - 객체 참조 타입(참조 변수는 변경 불가, 객체 내용은 변경 가능)
    private final StringBuilder builder;
    
    // TODO: 생성자를 정의하세요.
    public FinalExample(String name) {
        // 생성자에서 final 필드 초기화
        this.name = name;
        this.builder = new StringBuilder("Hello");
    }
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("StringBuilder 내용: " + builder);
    }

    public void appendToBuilder(String text) {
        // builder = new StringBuilder(); // 에러: final 변수에 새 객체 할당 불가
        builder.append(" ").append(text); // 객체 내용 변경은 가능
    }

    // TODO: final 메소드를 정의하세요.
    // final 메소드 - 오버라이딩 불가
    public final void finalMethod() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }


    // TODO: final 매개변수를 받는 메소드를 정의하세요.
    // final 매개변수 예제
    public void methodWithFinalParam(final int param) {
        // param = 200; // 에러: final 매개변수는 값 변경 불가
        System.out.println("final 매개변수 값: " + param);
    }
    // final 클래스 - 상속 불가
    static final class FinalClass {
        public void display() {
            System.out.println("이 클래스는 상속할 수 없습니다.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        chapter4.examples.ex4.FinalExample example = new chapter4.examples.ex4.FinalExample("John");

        
        // TODO: 객체의 메소드를 호출하세요.
        example.printInfo();
        
        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.
        FinalClass finalClass = new FinalClass();
        finalClass.display();
        // TODO: final 지역 변수를 선언하고 사용하세요.
        final int i = 1;
        System.out.println(i);
        
    }
}

// TODO: final 클래스를 정의하세요.


// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.

class Parent {
    // final 메소드
    public final void cannotOverride() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }

    // 일반 메소드
    public void canOverride() {
        System.out.println("Parent: 이 메소드는 오버라이딩 가능합니다.");
    }
}

// 상속 예제
class Child extends Parent {
//     final 메소드 오버라이딩 시도
//     @Override
//     public void cannotOverride() { } // 에러: final 메소드는 오버라이딩 불가

    // 일반 메소드 오버라이딩
    @Override
    public void canOverride() {
        System.out.println("Child: 메소드를 오버라이딩했습니다.");
    }
}