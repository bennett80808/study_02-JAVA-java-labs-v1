package chapter2.labs.lab4;

import java.util.Scanner;

/**
 * while 반복문을 사용한 반복 실습
 */
public class WhileLoopLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 사용자로부터 숫자를 입력받아 0이 입력될 때까지 합을 계산하여 출력하는 프로그램
        System.out.println("숫자를 입력하세요 (0을 입력하면 종료):");

        int sum = 0;
        while(true){
            int a = scanner.nextInt();
            sum += a;
            if(a==0){break;}
        }
        System.out.println("sum: " + sum);
        // TODO: 사용자로부터 숫자를 입력받고, 0이 입력될 때까지의 합계를 계산하여 출력하세요.
        // 1. 합계를 저장할 변수를 선언하세요.
        // 2. while 반복문을 사용하여 사용자로부터 숫자를 입력받으세요.
        // 3. 입력받은 숫자가 0이 아니면 합계에 더하고, 0이면 반복문을 종료하세요.
        // 4. 최종 합계를 출력하세요.
        
        
        // 2. 1부터 100까지의 짝수만 출력하는 프로그램
        System.out.println("\n1부터 100까지의 짝수 출력:");
        int b = 1;
        while(b < 101){
            if(b%2 == 0){System.out.println(b);}
            b++;
        }
        // TODO: while 반복문을 사용하여 1부터 100까지의 짝수만 출력하세요.
        // 1. 변수를 1로 초기화하세요.
        // 2. while 반복문을 사용하여 변수가 100 이하인 동안 반복하세요.
        // 3. 변수가 짝수인 경우에만 출력하세요.
        // 4. 변수를 1씩 증가시키세요.
        
        
        // 3. 구구단 출력 (do-while 사용)
        System.out.println("\n출력할 구구단의 단을 입력하세요 (2-9): ");
        
        // TODO: do-while 반복문을 사용하여 사용자가 2-9 사이의 숫자를 입력할 때까지 반복하고,
        // 입력받은 단의 구구단을 출력하세요.
        int c = scanner.nextInt();
        do{
            System.out.print("2~9 사이 숫자를 입력하세요: ");
            c = scanner.nextInt();

        } while((c < 2 || c > 9));
        for(int i=1; i<10; i++){ System.out.println(c + "*" + i + "=" + i*c);}
        // 4. 숫자 맞추기 게임
        System.out.println("\n숫자 맞추기 게임:");
        
        // 컴퓨터가 1에서 100 사이의 임의의 숫자를 선택 (예시로 73 사용)
        int targetNumber = 73;
        int count = 0;

        while(true){
            int tryNumber = scanner.nextInt();
            count++;
            if(tryNumber > targetNumber){System.out.println("더 작은 숫자를 입력하세요.");continue;}
            else if(tryNumber < targetNumber){System.out.println("더 큰 숫자를 입력하세요.");continue;}
            else if(tryNumber == targetNumber){System.out.println("정답입니다! 시도횟수:" + count); break;}
        }
        // TODO: while 반복문을 사용하여 사용자가 숫자를 맞출 때까지 반복하세요.
        // 1. 사용자로부터 숫자를 입력받으세요.
        // 2. 시도 횟수를 증가시키세요.
        // 3. 입력받은 숫자가 목표 숫자보다 크면 "더 작은 숫자를 입력하세요."를 출력하세요.
        // 4. 입력받은 숫자가 목표 숫자보다 작으면 "더 큰 숫자를 입력하세요."를 출력하세요.
        // 5. 입력받은 숫자가 목표 숫자와 같으면 "정답입니다!"와 시도 횟수를 출력하고 반복문을 종료하세요.
        
        
        // 5. 피보나치 수열 출력하기
        System.out.println("\n피보나치 수열 출력:");
        System.out.println("출력할 피보나치 수열의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        
        // TODO: while 반복문을 사용하여 입력받은 개수만큼 피보나치 수열을 출력하세요.
        // 피보나치 수열은 0, 1로 시작하며, 그 다음 숫자부터는 바로 앞의 두 숫자의 합입니다.
        // 예: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...

        System.out.print("몇 개의 피보나치 수를 출력할까요? ");

        int first = 0;   // 첫 번째 수
        int second = 1;  // 두 번째 수

        int count2 = 0;   // 몇 개 출력했는지 세는 변수

        while (count2 < n) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
            count2++;  // 출력했으니 개수 1 증가
        }



        int prev = 0;
        int prev2 = 1;
        for (int i = 0; i < count; i++) {
            int sum2 = prev + prev2;
            prev = prev2;
            prev2 = sum;
            System.out.print(sum + " ");
        }
        

        scanner.close();
    }
} 