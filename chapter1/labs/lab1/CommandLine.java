package chapter1.labs.lab1;

/**
 * 명령줄 컴파일 및 실행 연습을 위한 클래스
 * 이 파일을 명령 프롬프트나 터미널에서 컴파일하고 실행해보세요.
 * 
 * 컴파일: javac CommandLine.java
 * 실행: java CommandLine
 */
public class CommandLine {
    public static void main(String[] args) {
        System.out.println("=== 명령줄 컴파일 및 실행 연습 ===");
        
        // 현재 시간 출력
        System.out.println("현재 시간: " + new java.util.Date());
        
        // 자바 버전 정보 출력
        System.out.println("자바 버전: " + System.getProperty("java.version"));
        
        // 명령줄 인자 출력 (있는 경우)
        if (args.length > 0) {
            System.out.println("\n전달받은 명령줄 인자:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "]: " + args[i]);
            }
        } else {
            System.out.println("\n명령줄 인자가 없습니다.");
            System.out.println("다음과 같이 인자를 전달할 수 있습니다:");
            System.out.println("java CommandLine 인자1 인자2 인자3");
        }
    }
} 