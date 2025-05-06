package chapter3.labs.lab5;

import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.
    enum Grade {
        A("탁월함", 90, 100),
        B("우수함", 80, 89),
        C("양호함", 70, 79),
        D("보통", 60, 69),
        F("노력 필요", 0, 59);

        private final String description;
        private final int min;
        private final int max;

        Grade(String description, int min, int max) {
            this.description = description;
            this.min = min;
            this.max = max;
        }

        public static Grade fromScore(int score) {
            for (Grade g : values()) {
                if (score >= g.min && score <= g.max) return g;
            }
            return F;
        }

        public String getDescription() {
            return description;
        }
    }
    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;
    
    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("===== 학생 성적 관리 프로그램 =====");
        
        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);
            
            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다.
                    System.out.print("학생 이름 입력: ");
                    String name = scanner.nextLine();
                    System.out.print("성적 입력 (0~100): ");
                    int score = scanner.nextInt();
                    scanner.nextLine();
                    if (studentCount < MAX_STUDENTS){
                        names[studentCount] = name;
                        scores[studentCount] = score;
                        studentCount++;
                        System.out.println("입력완료");
                    } else{
                        System.out.println("학생 수 초과입니다.");
                    }

                    break;
                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    System.out.print("수정할 학생 이름 입력: ");
                    String targetName = scanner.nextLine();
                    int index = findStudentIndex(targetName);
                    if (index != -1){
                        System.out.print("새 성적 입력: ");
                        scores[index] = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("성적이 수정되었습니다.");
                    } else {
                        System.out.println("학생을 찾을 수 없습니다.");
                    }
                    break;
                case 3:
                    // TODO: 성적 조회 기능을 구현하세요.
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    if (studentCount == 0){
                        System.out.println("등록된 학생이 없습니다.");
                        break;
                    }
                    System.out.print("\n===== 전체 학생 성적 ======");
                    for (int i = 0; i < studentCount; i++) {
                        Grade g = calculateGrade(scores[i]);
                        System.out.println(names[i] + "- 성적: " + scores[i] + g + "(" + g.getDescription() + ")");
                    }
                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    System.out.print("검색할 학생 이름 입력: ");
                    String searchName = scanner.nextLine();
                    int searchIndex = findStudentIndex(searchName);
                    if(searchIndex != -1){
                        Grade g = calculateGrade(scores[searchIndex]);
                        System.out.println(searchName + "- 성적: " + scores[searchIndex] + ", 등급: " + g + "(" + g.getDescription() + ")");
                    } else {
                        System.out.println("학생을 찾을 수 없습니다.");
                    }
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    int[] gradeCounts = new int[Grade.values().length];
                    for (int i = 0;i < studentCount;i++){
                        Grade g = calculateGrade(scores[i]);
                        gradeCounts[g.ordinal()]++;
                    }
                    System.out.println("\n===== 등급 통계 =====");
                    for (Grade g: Grade.values()){
                        int count = gradeCounts[g.ordinal()];
                        double ratio = studentCount == 0 ? 0 : (double) count / studentCount * 100;
                        System.out.printf("%s: %d명 (%.1f%%) - %s\n", g, count, ratio, g.getDescription());
                    }
                    
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
    
    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.
    private static Grade calculateGrade(int score) {return Grade.fromScore(score);}
    
    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    private static int calculateTotal(){
        int total = 0;
        for (int i = 0; i < studentCount; i++) { total += scores[i];}
        return total;
    }
    
    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    private static double calculateAverage(){
        return studentCount == 0 ? 0 : (double)calculateTotal() / studentCount;
    }
    
    // TODO: 최고 성적을 찾는 메소드를 구현하세요.
    private static int findMaxScore() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < studentCount; i++) {
            if (scores[i] > max) {max = scores[i];}
        }
        return max;
    }
    
    // TODO: 최저 성적을 찾는 메소드를 구현하세요.
    private static int findMinScore() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < studentCount; i++) {
            if (scores[i] < min) {min = scores[i];}
        }
        return min;
    }
    
    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.
    private static int findStudentIndex(String name){
        for (int i = 0; i < studentCount; i++) {
            if (names[i].equals(name)) return i;
        }
        return -1;
    }
} 