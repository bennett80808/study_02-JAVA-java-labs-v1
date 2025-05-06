package chapter3.labs.lab4;

import java.time.DayOfWeek;
import java.util.Scanner;

public class EnumLab {

    // TODO: 계절을 나타내는 Enum 정의 (평균 기온, 특징 포함)
    enum Season {
        SPRING(13.0, "꽃이 피고 날씨가 따뜻해집니다."),
        SUMMER(26.0, "무덥고 장마가 옵니다."),
        FALL(17.0, "하늘이 높고 선선합니다."),
        WINTER(2.0, "춥고 눈이 내립니다.");

        private final double averageTemp;
        private final String description;

        Season(double averageTemp, String description) {
            this.averageTemp = averageTemp;
            this.description = description;
        }

        public double getAverageTemp() {
            return averageTemp;
        }

        public String getDescription() {
            return description;
        }
    }

    // TODO: 작업 상태를 나타내는 Enum 정의 (nextStatus()로 상태 전이 구현)
    enum TaskStatus {
        PENDING, IN_PROGRESS, COMPLETED, ARCHIVED;

        public TaskStatus nextStatus() {
            return switch (this) {
                case PENDING -> IN_PROGRESS;
                case IN_PROGRESS -> COMPLETED;
                case COMPLETED -> ARCHIVED;
                case ARCHIVED -> ARCHIVED;
            };
        }
    }

    // TODO: 사칙연산을 위한 Enum 정의 (기호, calculate(), fromSymbol() 포함)
    enum Operator {
        ADD("+") {
            public double calculate(double a, double b) {
                return a + b;
            }
        },
        SUBTRACT("-") {
            public double calculate(double a, double b) {
                return a - b;
            }
        },
        MULTIPLY("*") {
            public double calculate(double a, double b) {
                return a * b;
            }
        },
        DIVIDE("/") {
            public double calculate(double a, double b) {
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                return a / b;
            }
        };

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        public abstract double calculate(double a, double b);

        public static Operator fromSymbol(String symbol) {
            for (Operator op : values()) {
                if (op.getSymbol().equals(symbol)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: 요일을 입력받아 평일/주말 구분하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.print("요일을 입력하세요 (MONDAY~SUNDAY): ");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            DayOfWeek day = DayOfWeek.valueOf(input);
            switch (day) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("평일입니다.");
                case SATURDAY, SUNDAY -> System.out.println("주말입니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 요일입니다.");
        }

        // TODO: 월을 입력받아 계절 출력하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.print("월을 입력하세요 (1~12): ");
        int month = scanner.nextInt();

        Season season = switch (month) {
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            case 9, 10, 11 -> Season.FALL;
            case 12, 1, 2 -> Season.WINTER;
            default -> null;
        };

        if (season != null) {
            System.out.println("계절: " + season);
            System.out.println("평균 기온: " + season.getAverageTemp() + "도");
            System.out.println("특징: " + season.getDescription());
        } else {
            System.out.println("잘못된 월입니다.");
        }

        scanner.nextLine(); // 개행 제거

        // TODO: 상태 전이 기능 구현 - next 명령 시 다음 단계로
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");
        TaskStatus status = TaskStatus.PENDING;

        while (true) {
            System.out.println("현재 상태: " + status);
            System.out.print("명령어 입력 (next/exit): ");
            String cmd = scanner.nextLine().trim().toLowerCase();

            if (cmd.equals("next")) {
                TaskStatus next = status.nextStatus();
                if (status == next) {
                    System.out.println("더 이상 다음 상태가 없습니다. (ARCHIVED)");
                } else {
                    status = next;
                }
            } else if (cmd.equals("exit")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        // TODO: 두 수와 연산자 입력 받아 계산 결과 출력하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        System.out.print("첫 번째 숫자: ");
        double a = scanner.nextDouble();
        System.out.print("두 번째 숫자: ");
        double b = scanner.nextDouble();
        scanner.nextLine(); // 개행 제거
        System.out.print("연산자 입력 (+, -, *, /): ");
        String sym = scanner.nextLine().trim();

        try {
            Operator op = Operator.fromSymbol(sym);
            double result = op.calculate(a, b);
            System.out.println("결과: " + result);
        } catch (Exception e) {
            System.out.println("오류: " + e.getMessage());
        }

        scanner.close();
    }
}
