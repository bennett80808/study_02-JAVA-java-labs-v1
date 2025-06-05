package chapter2.labs.lab5;

import java.util.Scanner;

/**
 * 별표(*) 패턴 출력 실습
 */
public class StarPatternLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("패턴 출력을 위한 높이를 입력하세요: ");
        int height = scanner.nextInt();
        
        // 1. 직각삼각형 패턴 (왼쪽 정렬)
        System.out.println("\n1. 직각삼각형 패턴 (왼쪽 정렬)");

        int i = 1;
        while(i <= height) {
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            i++;
        }
        scanner.close();
        // 예시 (높이 5):
        // *
        // **
        // ***
        // ****
        // *****
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for ( i = 0; i < height; i++) {
            for (int j = height - i; j <= height; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        
        // 2. 직각삼각형 패턴 (오른쪽 정렬)
        System.out.println("\n2. 직각삼각형 패턴 (오른쪽 정렬)");
        // 예시 (높이 5):
        //     *
        //    **
        //   ***
        //  ****
        // *****
        System.out.println("패턴 출력을 위한 높이를 입력하세요: ");
        int height2 = scanner.nextInt();
        i = 1;
        while(i <= height2) {
            for(int j=1;j<=height2-i;j++){ System.out.print(" "); }
            for(int k=1;k<=i;k++){System.out.print("*");}
            System.out.println();
            i++;
        }


        // TODO: 위와 같은 패턴을 출력하세요.

        for ( i = 0; i < height; i++) {
            for (int j = 0; j <= height; j++) {
                if (height - i <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        
        // 3. 피라미드 패턴
        System.out.println("\n3. 피라미드 패턴");
        // 예시 (높이 5):
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        System.out.println("패턴 출력을 위한 높이를 입력하세요: ");
        int height3 = scanner.nextInt();
        i = 1;
        while(i <= height3) {
            for(int j=1;j<=height3-i;j++){System.out.print(" "); }
            for(int k=1;k<=2*i-1;k++){System.out.print("*");}
            System.out.println();
            i++;
        }

        // TODO: 위와 같은 패턴을 출력하세요.

        for ( i = 1; i <= height; i++) {
            // 공백 출력
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            // 줄 바꿈
            System.out.println();
        }

        // 4. 역삼각형 패턴
        System.out.println("\n4. 역삼각형 패턴");
        // 예시 (높이 5):
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        
        // TODO: 위와 같은 패턴을 출력하세요.
        System.out.println("패턴 출력을 위한 높이를 입력하세요: ");
        int height4 = scanner.nextInt();
        i = 1;
        while(i <= height4) {
            for(int j=0;j<i-1;j++){System.out.print(" "); }
            for(int k=1;k<=(2*(height4 - i + 1)-1);k++){System.out.print("*");}
            System.out.println();
            i++;
        }
        
        // 5. 다이아몬드 패턴
        System.out.println("\n5. 다이아몬드 패턴");
        // 예시 (높이 5, 실제 높이는 9):
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        int height5 = scanner.nextInt();  // 예: 5 입력

        int totalLines = 2 * height5 - 1; // 총 줄 수 = 9줄

        for ( i = 1; i <= totalLines; i++) {
            int spaceCount, starCount;

            if (i <= height) {  // 윗부분
                spaceCount = height5 - i;
                starCount = 2 * i - 1;
            } else {  // 아랫부분
                spaceCount = i - height5;
                starCount = 2 * (totalLines - i + 1) - 1;
            }

            // 공백 출력
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 0; k < starCount; k++) {
                System.out.print("*");
            }
            // 줄 바꾸기
            System.out.println();
        }
        // TODO: 위와 같은 패턴을 출력하세요.
        
        
        // 6. 모래시계 패턴
        System.out.println("\n6. 모래시계 패턴");
        // 예시 (높이 5, 실제 높이는 9):
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        
        // TODO: 위와 같은 패턴을 출력하세요.
        System.out.print("삼각형 높이 입력: ");
        int height6 = scanner.nextInt();  // 예를 들어 5 입력

        int totalLines2 = 2 * height6 - 1; // 총 줄 수 = 9줄

        for (i = 1; i <= totalLines2; i++) {
            int spaceCount, starCount;

            if (i <= height6) {  // 위쪽 (별 줄어드는 부분)
                spaceCount = i - 1;
                starCount = 2 * (height6 - i + 1) - 1;
            } else {  // 아래쪽 (별 늘어나는 부분)
                spaceCount = totalLines2 - i;
                starCount = 2 * (i - height6 + 1) - 1;
            }

            // 공백 출력
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 0; k < starCount; k++) {
                System.out.print("*");
            }
            // 줄 바꾸기
            System.out.println();
        }
        
        // 7. 숫자 피라미드 패턴
        System.out.println("\n7. 숫자 피라미드 패턴");
        // 예시 (높이 5):
        //     1
        //    121
        //   12321
        //  1234321
        // 123454321
        
        // TODO: 위와 같은 패턴을 출력하세요.
        System.out.print("피라미드 높이 입력: ");
        int height7 = scanner.nextInt();  // 예: 5 입력

        for (i = 1; i <= height7; i++) {
            // 1. 공백 출력
            for (int j = 1; j <= height7 - i; j++) {
                System.out.print(" ");
            }
            // 2. 왼쪽 오름차순 숫자 출력 (1부터 i까지)
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // 3. 오른쪽 내림차순 숫자 출력 (i-1부터 1까지)
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            // 4. 줄 바꿈
            System.out.println();
        }

    }
} 