package chapter3.labs.lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 활용하기 실습
 */
public class ArrayLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 정수형 배열 활용
        System.out.println("===== 정수형 배열 활용 =====");
        
        // TODO: 5개의 정수를 입력받아 배열에 저장하고, 합계와 평균을 계산하여 출력하세요.
        // 힌트: Scanner를 이용하여 사용자로부터 입력을 받으세요.
        int[] numbers = new int[5];  // 5개의 정수를 저장할 배열
        int sum = 0;                 // 합계를 저장할 변수

        // 5개의 정수 입력받기
        for (int i = 0; i < numbers.length; i++) {
            System.out.print((i + 1) + "번째 정수를 입력하세요: ");
            numbers[i] = scanner.nextInt();  // 입력 받아 배열에 저장
            sum += numbers[i];               // 입력하면서 합계 누적
        }

        double average = (double) sum / numbers.length;  // 평균 계산 (실수형으로)

        // 결과 출력
        System.out.println("합계: " + sum);
        System.out.println("평균: " + average);
        
        // 2. 문자열 배열 활용
        System.out.println("\n===== 문자열 배열 활용 =====");
        
        // TODO: 5개의 이름을 입력받아 배열에 저장하고, 특정 문자(예: 'A')로 시작하는 이름을 검색하여 출력하세요.
        // 힌트: String 클래스의 startsWith() 또는 charAt() 메소드를 활용하세요.
        String[] names = new String[5];  // 이름 5개를 저장할 배열

        // 이름 입력 받기
        for (int i = 0; i < names.length; i++) {
            System.out.print((i + 1) + "번째 이름을 입력하세요: ");
            names[i] = scanner.nextLine();  // 문자열 입력 받기
        }

        System.out.print("검색할 시작 문자 입력 (예: A): ");
        String target = scanner.nextLine();

        System.out.println("[" + target + "]로 시작하는 이름:");

        for (String name : names) {
            if (name.startsWith(target)) {
                System.out.println(name);
            }
        }
        
        // 3. 배열 정렬
        System.out.println("\n===== 배열 정렬 =====");

        // TODO: 사용자로부터 5개의 정수를 입력받아 배열에 저장한 후, 오름차순으로 정렬하여 출력하세요.
        // 힌트: 이중 반복문을 사용하여 버블 정렬 알고리즘을 구현하거나, Arrays.sort()를 활용하세요.
        int[] numbers2 = new int[5];

        // 정수 입력받기
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print((i + 1) + "번째 정수를 입력하세요: ");
            numbers2[i] = scanner.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(numbers2);

        // 결과 출력
        System.out.println("오름차순 정렬 결과:");
        for (int num : numbers2) {
            System.out.print(num + " ");
        }
        
        // 4. 2차원 배열을 이용한 행렬 덧셈
        System.out.println("\n===== 2차원 배열을 이용한 행렬 덧셈 =====");
        
        // TODO: 두 개의 2x3 행렬을 입력받아 행렬 덧셈을 수행하고 결과를 출력하세요.
        // 힌트: 중첩 반복문을 사용하세요.
        int[][] matrix1 = new int[2][3];
        int[][] matrix2 = new int[2][3];
        int[][] result = new int[2][3];

        System.out.println("첫 번째 2x3 행렬을 입력하세요:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("matrix1[" + i + "][" + j + "] = ");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("두 번째 2x3 행렬을 입력하세요:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("matrix2[" + i + "][" + j + "] = ");
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // 행렬 덧셈 수행
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // 결과 출력
        System.out.println("행렬 덧셈 결과:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();  // 줄 바꿈
        }
        
        // 5. 배열을 이용한 간단한 데이터 분석
        System.out.println("\n===== 배열을 이용한 데이터 분석 =====");
        
        // TODO: 10개의 정수를 입력받아 배열에 저장한 후, 최댓값, 최솟값, 중앙값(또는 평균)을 계산하여 출력하세요.
        // 힌트: 정렬을 활용하면 중앙값을 쉽게 찾을 수 있습니다.
        int[] numbers3 = new int[10];
        int sum3 = 0;

        // 10개 정수 입력받기
        for (int i = 0; i < numbers3.length; i++) {
            System.out.print((i + 1) + "번째 정수 입력: ");
            numbers3[i] = scanner.nextInt();
            sum3 += numbers3[i];
        }

        // 평균 계산
        double average2 = (double) sum3 / numbers3.length;

        // 정렬 후 최댓값, 최솟값, 중앙값 계산
        Arrays.sort(numbers);  // 오름차순 정렬
        int min = numbers3[0];
        int max = numbers3[numbers3.length - 1];

        // 중앙값 (짝수이므로 가운데 두 수의 평균)
        double median = (numbers3[4] + numbers3[5]) / 2.0;

        // 결과 출력
        System.out.println("\n--- 결과 ---");
        System.out.println("최솟값: " + min);
        System.out.println("최댓값: " + max);
        System.out.println("평균: " + average2);
        System.out.println("중앙값: " + median);
        
        scanner.close();
    }
} 