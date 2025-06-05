package chapter7.labs.lab2;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TextFileIOLab {
    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";
    private static final File FILE = new File(FILE_PATH);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int switchNum = getIntInput(scanner, 1, 7);
            scanner.nextLine(); // flush newline
            switch (switchNum) {
                case 1 -> createTextFile(scanner);
                case 2 -> readTextFile();
                case 3 -> searchTextInFile(scanner);
                case 4 -> replaceTextInFile(scanner);
                case 5 -> countFileStats();
                case 6 -> appendToFile(scanner);
                case 7 -> {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
            }
            System.out.println("계속하려면 Enter, 종료하려면 아무 키 입력 후 Enter:");
            if (!scanner.nextLine().isEmpty()) break;
        }
    }

    private static void showMenu() {
        System.out.println("\n===== 텍스트 파일 처리 프로그램 =====");
        System.out.println("1. 텍스트 파일 생성하기");
        System.out.println("2. 텍스트 파일 읽기");
        System.out.println("3. 텍스트 파일에서 검색하기");
        System.out.println("4. 텍스트 파일에서 문자열 치환하기");
        System.out.println("5. 파일 통계 계산하기");
        System.out.println("6. 파일에 내용 추가하기");
        System.out.println("7. 종료");
    }

    private static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print(min + " 이상 " + max + " 이하의 숫자 입력: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number >= min && number <= max) return number;
            } else {
                scanner.next(); // consume wrong token
            }
            System.out.println("잘못된 입력입니다.");
        }
    }

    private static void createTextFile(Scanner scanner) {
        System.out.println("텍스트 파일 생성하기");
        if (FILE.exists()) {
            System.out.print("파일이 이미 존재합니다. 덮어쓸까요? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("n")) return;
        }

        System.out.println("입력할 텍스트 (빈 줄 입력 시 종료):");
        List<String> lines = new ArrayList<>();
        int lineNum = 1;
        while (true) {
            System.out.print("입력 " + lineNum + ": ");
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            lines.add(lineNum + ": " + input);
            lineNum++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ 파일 생성 완료.");
        } catch (IOException e) {
            System.err.println("❌ 파일 저장 실패: " + e.getMessage());
        }
    }

    private static void readTextFile() {
        System.out.println("텍스트 파일 읽기");
        if (!FILE.exists()) {
            System.err.println("❌ 파일이 존재하지 않습니다.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNum++ + ": " + line);
            }
        } catch (IOException e) {
            System.err.println("❌ 파일 읽기 실패: " + e.getMessage());
        }
    }

    private static void searchTextInFile(Scanner scanner) {
        System.out.println("텍스트 파일에서 검색하기");
        if (!FILE.exists()) {
            System.err.println("❌ 파일이 존재하지 않습니다.");
            return;
        }

        System.out.print("검색할 텍스트: ");
        String keyword = scanner.nextLine();
        System.out.print("대소문자 구분? (y/n): ");
        boolean caseSensitive = scanner.nextLine().trim().equalsIgnoreCase("y");

        Pattern pattern = caseSensitive
                ? Pattern.compile(Pattern.quote(keyword))
                : Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE);

        int matchCount = 0, lineNum = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String highlighted = matcher.replaceAll("\u001B[31m" + keyword + "\u001B[0m");
                    System.out.println(lineNum + ": " + highlighted);
                    matchCount++;
                }
                lineNum++;
            }
            System.out.println("총 " + matchCount + "개의 결과를 찾았습니다.");
        } catch (IOException e) {
            System.err.println("❌ 검색 중 오류: " + e.getMessage());
        }
    }

    private static void replaceTextInFile(Scanner scanner) {
        System.out.println("텍스트 파일에서 문자열 치환하기");
        if (!FILE.exists()) {
            System.err.println("❌ 파일이 존재하지 않습니다.");
            return;
        }

        System.out.print("찾을 문자열: ");
        String target = scanner.nextLine();
        System.out.print("바꿀 문자열: ");
        String replacement = scanner.nextLine();
        System.out.print("대소문자 구분? (y/n): ");
        boolean caseSensitive = scanner.nextLine().trim().equalsIgnoreCase("y");
        System.out.print("모두 바꿀까요? (y/n): ");
        boolean replaceAll = scanner.nextLine().trim().equalsIgnoreCase("y");

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("❌ 파일 읽기 실패: " + e.getMessage());
            return;
        }

        Pattern pattern = caseSensitive
                ? Pattern.compile(Pattern.quote(target))
                : Pattern.compile(Pattern.quote(target), Pattern.CASE_INSENSITIVE);

        int modifiedLines = 0;
        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.find()) {
                lines.set(i, replaceAll ? matcher.replaceAll(replacement) : matcher.replaceFirst(replacement));
                modifiedLines++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("총 " + modifiedLines + "줄이 수정되었습니다.");
        } catch (IOException e) {
            System.err.println("❌ 저장 실패: " + e.getMessage());
        }
    }

    private static void countFileStats() {
        System.out.println("파일 통계 계산하기");
        if (!FILE.exists()) {
            System.err.println("❌ 파일이 존재하지 않습니다.");
            return;
        }

        int lines = 0, words = 0, chars = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                if (!line.trim().isEmpty()) {
                    words += line.trim().split("\\s+").length;
                }
                chars += line.length();
            }
            System.out.println("줄 수: " + lines + ", 단어 수: " + words + ", 문자 수: " + chars);
        } catch (IOException e) {
            System.err.println("❌ 통계 처리 실패: " + e.getMessage());
        }
    }

    private static void appendToFile(Scanner scanner) {
        System.out.println("파일에 내용 추가하기");
        if (!FILE.exists()) {
            System.err.println("❌ 파일이 존재하지 않습니다.");
            return;
        }

        List<String> newLines = new ArrayList<>();
        int lineNum = 1;
        System.out.println("내용 입력 (빈 줄로 종료):");
        while (true) {
            System.out.print("입력 " + lineNum + ": ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) break;
            newLines.add(lineNum + ": " + input);
            lineNum++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.newLine();
            writer.write("--- 추가된 내용 ---");
            writer.newLine();
            for (String line : newLines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ 내용 추가 완료.");
        } catch (IOException e) {
            System.err.println("❌ 추가 실패: " + e.getMessage());
        }
    }
}


//package chapter7.labs.lab2;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import static TextFileIOLab.FILE;
//import static TextFileIOLab.FILE;
//import static TextFileIOLab.FILE_PATH;
//import static TextFileIOLab.FILE_PATH;
//
///**
// * 텍스트 파일을 생성하고 처리하는 실습
// *
// * 이 실습에서는 Java의 파일 입출력 기능을 활용하여
// * 텍스트 파일을 생성, 읽기, 검색, 수정하는 다양한 작업을 수행합니다.
// */
//public class TextFileIOLab {
//    // 파일 경로 상수
//    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";
//    private static final File FILE = new File(FILE_PATH);
//
//    public static void main(String[] args) {
//        // TODO: 사용자 입력을 받기 위한 Scanner 객체를 생성하세요.
//            Scanner scanner = new Scanner(System.in);
//
//
//        // TODO: 프로그램 메인 루프를 구현하세요.
//        while(true){
//            int switchNum = getIntInput(scanner, 1, 7);
//            switch (switchNum){
//                case 1:
//                    createTextFile(scanner);
//                    break;
//                case 2:
//                    readTextFile();
//                    break;
//                case 3:
//                    searchTextInFile(scanner);
//                    break;
//                case 4:
//                    replaceTextInFile(scanner);
//                    break;
//                case 5:
//                    countFileStats();
//                    break;
//                case 6:
//                    appendToFile(scanner);
//                    break;
//                case 7:
//                    return;
//                default:
//                    System.out.println("Invalid input");
//
//            }
//            System.out.println("계속 하려면 Enter를 누르세요. 끝내려면 Enter 이외의 것을 누르세요.");
//            String goOrStop = scanner.nextLine();
//            if (goOrStop.isEmpty()){
//                continue;
//            }else{ return;}
//        }
//        // 1. showMenu() 메소드를 호출하여 메뉴 표시
//        // 2. getIntInput() 메소드를 호출하여 사용자 선택 받기 (1~7 사이의 값)
//        // 3. switch 문을 사용하여 사용자 선택에 따른 메소드 호출
//        //    - 1: createTextFile()
//        //    - 2: readTextFile()
//        //    - 3: searchTextInFile()
//        //    - 4: replaceTextInFile()
//        //    - 5: countFileStats()
//        //    - 6: appendToFile()
//        //    - 7: 프로그램 종료
//        // 4. 계속하려면 Enter 키를 누르도록 안내 메시지 출력
//
//    }
//
//    /**
//     * 메뉴 출력
//     */
//    private static void showMenu() {
//        // TODO: 텍스트 파일 처리 프로그램의 메뉴를 출력하세요.
//        System.out.println("1. 텍스트 파일 생성하기");
//        System.out.println("2. 텍스트 파일 읽기");
//        System.out.println("3. 텍스트 파일에서 검색하기");
//        System.out.println("4. 텍스트 파일에서 문자열 치환하기");
//        System.out.println("5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)");
//        System.out.println("6. 파일에 내용 추가하기");
//        System.out.println("7. 종료");
//        // 1. 텍스트 파일 생성하기
//        // 2. 텍스트 파일 읽기
//        // 3. 텍스트 파일에서 검색하기
//        // 4. 텍스트 파일에서 문자열 치환하기
//        // 5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)
//        // 6. 파일에 내용 추가하기
//        // 7. 종료
//    }
//
//    /**
//     * 사용자로부터 정수 입력 받기
//     */
//    private static int getIntInput(Scanner scanner, int min, int max) {
//        // TODO: 사용자로부터 min과 max 사이의 정수를 입력받아 반환하세요.
//        while(true) {
//            System.out.print(min + "이상 " + max + "이하의 숫자를 입력하세요");
//            int number = scanner.nextInt();
//            if (!(number >= min && number <= max)) {
//                System.out.println("범위를 확인하고 다시 입력하세요");
//                continue;
//            }
//            else {
//                return number;
//            }
//        }
//        // 1. 사용자 입력을 정수로 변환 시도
//        // 2. 입력값이 min과 max 사이의 값인지 확인
//        // 3. 잘못된 입력이 들어온 경우 적절한 메시지 출력 후 다시 입력 요청
//        // 4. 유효한 입력을 받을 때까지 반복
//
//         // 구현 후 이 줄을 수정하세요.
//    }
//
//    /**
//     * 텍스트 파일 생성
//     */
//    private static void createTextFile(Scanner scanner) {
//        // TODO: "텍스트 파일 생성하기" 타이틀을 출력하세요.
//        System.out.println("텍스트 파일 생성하기");
//        // TODO: 파일이 이미 존재하는지 확인하세요.
//        if (!FILE.exists()) {
//            System.err.println("❌ 파일이 존재하지 않습니다: " + FILE_PATH);
//            return;
//        }else{
//            System.out.println("파일이 있습니다. 덮어쓰시겠습니까? (y/n)");
//            String answer = scanner.nextLine().trim().toLowerCase();
//            if (answer.equals("n")) {
//                System.out.println("파일을 덮어쓰지 않고 프로그램을 종료합니다.");
//                return;
//            } else if (answer.equals("y")) {
//                try(FileWriter writer = new FileWriter(FILE)){
//                    writer.write("이 파일은 덮어씌기 되었습니다.\n");
//                    writer.write("파일 이름" + FILE_PATH + "\n");
//                    System.out.println("파일이 성공적으로 덮어씌어졌습니다.");
//
//                } catch (IOException e) {
//                    System.err.println("파일 덮어씌기 중 에러 발생");
//                }
//            }
//        }
//        // 1. File 객체를 생성하고 exists() 메소드를 사용하여 확인
//        // 2. 파일이 이미 존재하면 덮어쓸지 사용자에게 물어보기
//        // 3. 사용자가 'n'을 입력하면 메소드 종료
//
//        // TODO: 사용자로부터 파일에 저장할 내용을 입력받으세요.
//        System.out.println("파일에 저장할 내용을 입력하세요. 끝나면 빈줄을 입력하세요.");
//        List<String> lines = new ArrayList<>();
//        int lineNum = 1;
//        while(true){
//            System.out.println("입력 " + lineNum + ": ");
//            String line = scanner.nextLine();
//            if (line.isEmpty()){break;}
//
//            String numberedLine = lineNum + ":" + line;
//            lines.add(numberedLine);
//            lineNum++;
//        }
//        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
//        // 2. 입력된 각 줄에 줄 번호 표시하기
//        // 3. 입력받은 내용을 List<String>에 저장
//
//        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 쓰세요.
//        // 1. try-with-resources 구문 사용
//        // 2. FileWriter와 BufferedWriter 생성
//        // 3. 리스트의 각 줄을 파일에 쓰기 (newLine() 메소드 활용)
//        // 4. 예외 처리 및 성공 메시지 출력
//        try(
//                FileWriter fileWriter = new FileWriter(FILE_PATH);
//                BufferedWriter bw = new BufferedWriter(fileWriter);
//        ){
//            for (String line : lines) {
//                bw.write(line);
//                bw.newLine();
//            }
//            System.out.println("파일 저장 완료");
//        } catch (IOException e) {
//            System.err.println("파일 저장 중 오류 발생");
//        }
//    }
//
//    /**
//     * 텍스트 파일 읽기
//     */
//    private static void readTextFile() {
//        // TODO: "텍스트 파일 읽기" 타이틀을 출력하세요.
//        System.out.println("텍스트 파일 읽기");
//        // TODO: 파일이 존재하는지 확인하세요.
//        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
//        if (!FILE.exists()) {
//            System.err.println("❌ 파일이 존재하지 않습니다: " + FILE_PATH);
//            return;
//        }
//
//        // TODO: BufferedReader를 사용하여 파일 내용을 읽고 출력하세요.
//        // 1. try-with-resources 구문 사용
//        // 2. FileReader와 BufferedReader 생성
//        // 3. readLine() 메소드를 사용하여 한 줄씩 읽기
//        // 4. 각 줄 앞에 줄 번호 붙여서 출력
//        // 5. 예외 처리 및 완료 메시지 출력
//        try(
//            FileReader fileReader = new FileReader(FILE_PATH);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//                ){
//            String line;
//            int lineNum = 1;
//
//            while((line = bufferedReader.readLine()) != null){
//                System.out.println(lineNum + ": " + line);
//                lineNum++;
//            }
//
//        } catch (IOException e){
//            System.err.println("파일 읽기 중 오류 발생" + e.getMessage());
//        }
//        }
//    }
//
//    /**
//     * 텍스트 파일에서 문자열 검색
//     */
//    private static void searchTextInFile(Scanner scanner) {
//        // TODO: "텍스트 파일에서 검색하기" 타이틀을 출력하세요.
//        System.out.println("텍스트 파일에서 검색하기");
//        // TODO: 파일이 존재하는지 확인하세요.
//        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
//        if (!TextFileIOLab.FILE.exists()) {
//            System.err.println("❌ 파일이 존재하지 않습니다: " + TextFileIOLab.FILE_PATH);
//            return;
//        }
//
//
//        // TODO: 사용자로부터 검색할 텍스트와 대소문자 구분 여부를 입력받으세요.
//        System.out.print("🔍 검색할 텍스트를 입력하세요: ");
//        String keyword = scanner.nextLine();
//
//        System.out.print("🔡 대소문자 구분할까요? (y/n): ");
//        String caseChoice = scanner.nextLine().trim().toLowerCase();
//        boolean caseSensitive = caseChoice.equals("y");
//
//        int matchCount = 0;
//        int lineNumber = 1;
//        // TODO: BufferedReader를 사용하여 파일을 읽으면서 검색어 찾기
//        // 1. try-with-resources 구문 사용
//        // 2. 대소문자 구분 여부에 따라 검색 전략 결정
//        // 3. 일치하는 부분 찾으면 해당 줄 출력 (검색어 하이라이트)
//        // 4. Pattern, Matcher 클래스를 활용하여 검색어 하이라이트
//        // 5. 검색 결과 통계 출력 (몇 개의 일치 항목을 찾았는지)
//        // 6. 예외 처리
//        try (
//                BufferedReader reader = new BufferedReader(new FileReader(file))
//        ) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // ✅ 4. 정규 표현식 준비
//                Pattern pattern = caseSensitive ?
//                        Pattern.compile(Pattern.quote(keyword)) :
//                        Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE);
//
//                Matcher matcher = pattern.matcher(line);
//
//                // ✅ 5. 일치하는 부분 찾기
//                if (matcher.find()) {
//                    // ✅ 하이라이트용 문자열 생성 (굵게 처리)
//                    String highlightedLine = matcher.replaceAll("\u001B[31m" + keyword + "\u001B[0m"); // 빨간색 표시
//                    System.out.println(lineNumber + ": " + highlightedLine);
//                    matchCount++;
//                }
//
//                lineNumber++;
//            }
//
//            // ✅ 6. 검색 결과 출력
//            System.out.println("\n✅ 검색 완료! 총 " + matchCount + "개의 결과를 찾았습니다.");
//
//        } catch (IOException e) {
//            System.err.println("❌ 파일 읽기 중 오류: " + e.getMessage());
//        }
//    }
//
//    /**
//     * 텍스트 파일에서 문자열 치환
//     */
//    private static void replaceTextInFile(Scanner scanner) {
//        // TODO: "텍스트 파일에서 문자열 치환하기" 타이틀을 출력하세요.
//        System.out.print("텍스트 파일에서 문자열 치환하기 ");
//        // TODO: 파일이 존재하는지 확인하세요.
//        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
//        if (!TextFileIOLab.FILE.exists()) {
//            System.err.println("❌ 파일이 존재하지 않습니다: " + TextFileIOLab.FILE_PATH);
//            return;
//        }
//        // TODO: 사용자로부터 다음 정보를 입력받으세요:
//        // 1. 찾을 텍스트
//        // 2. 변경할 텍스트
//        // 3. 대소문자 구분 여부 (y/n)
//        // 4. 모든 일치 항목 변경 또는 첫 일치 항목만 변경 여부 (y/n)
//
//        // TODO: 파일 내용을 List<String>으로 읽어오세요.
//        // 1. try-with-resources 구문 사용
//        // 2. BufferedReader를 사용하여 모든 줄을 리스트에 저장
//
//        // TODO: 각 줄에서 검색어를 찾아 치환하세요.
//        // 1. 대소문자 구분 여부와 모든/첫 일치 항목 변경 여부에 따라 적절한 메소드 사용
//        //    - String.replace() 또는 String.replaceAll()
//        //    - 정규식 패턴 사용 시 Pattern.CASE_INSENSITIVE 플래그 활용
//        // 2. 몇 개의 라인이 변경되었는지 카운트
//
//        // TODO: 변경된 내용을 파일에 다시 쓰세요.
//        // 1. try-with-resources 구문 사용
//        // 2. BufferedWriter를 사용하여 수정된 내용 쓰기
//        // 3. 변경된 라인 수 출력
//        // 4. 예외 처리
//        System.out.print("1. 찾을 텍스트: ");
//        String target = scanner.nextLine();
//
//        System.out.print("2. 변경할 텍스트: ");
//        String replacement = scanner.nextLine();
//
//        System.out.print("3. 대소문자 구분할까요? (y/n): ");
//        boolean caseSensitive = scanner.nextLine().trim().equalsIgnoreCase("y");
//
//        System.out.print("4. 모든 항목 변경할까요? (y/n - n이면 첫 번째 항목만 변경): ");
//        boolean replaceAll = scanner.nextLine().trim().equalsIgnoreCase("y");
//
//        List<String> lines = new ArrayList<>();
//
//        // 📥 파일을 한 줄씩 읽어서 리스트에 저장
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                lines.add(line);
//            }
//        } catch (IOException e) {
//            System.err.println("❌ 파일 읽기 오류: " + e.getMessage());
//            return;
//        }
//
//        // 🔄 치환 작업
//        int modifiedLineCount = 0;
//
//        Pattern pattern = caseSensitive ?
//                Pattern.compile(Pattern.quote(target)) :
//                Pattern.compile(Pattern.quote(target), Pattern.CASE_INSENSITIVE);
//
//        for (int i = 0; i < lines.size(); i++) {
//            String originalLine = lines.get(i);
//            Matcher matcher = pattern.matcher(originalLine);
//
//            if (matcher.find()) {
//                modifiedLineCount++;
//
//                if (replaceAll) {
//                    lines.set(i, matcher.replaceAll(replacement)); // 모든 항목 변경
//                } else {
//                    lines.set(i, matcher.replaceFirst(replacement)); // 첫 항목만 변경
//                }
//            }
//        }
//
//        // 💾 변경된 내용을 파일에 다시 쓰기
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (String line : lines) {
//                writer.write(line);
//                writer.newLine();
//            }
//
//            System.out.println("✅ 총 " + modifiedLineCount + "줄이 변경되었습니다.");
//
//        } catch (IOException e) {
//            System.err.println("❌ 파일 쓰기 오류: " + e.getMessage());
//        }
//
//    }
//
//    /**
//     * 파일 통계 계산 (라인 수, 단어 수, 문자 수)
//     */
//    private static void countFileStats() {
//        // TODO: "파일 통계 계산하기" 타이틀을 출력하세요.
//        System.out.println("=== 파일 통계 계산하기 ===");
//        // TODO: 파일이 존재하는지 확인하세요.
//        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
//        if (!TextFileIOLab.FILE.exists()) {
//            System.err.println("❌ 파일이 존재하지 않습니다: " + TextFileIOLab.FILE_PATH);
//            return;
//        }
//        // TODO: 파일 통계를 계산하세요.
//        // 1. try-with-resources 구문 사용
//        // 2. BufferedReader를 사용하여 파일 읽기
//        // 3. 라인 수 계산 (반복문에서 라인 카운트 증가)
//        // 4. 단어 수 계산 (각 라인을 공백으로 분할하여 단어 카운트)
//        // 5. 문자 수 계산 (각 라인의 길이 합산)
//        int lineCount = 0;
//        int wordCount = 0;
//        int charCount = 0;
//        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
//            String line;
//            while((line = reader.readLine()) != null){
//                lineCount++;
//                wordCount += line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;
//                charCount += line.length();
//            }
//            // ✅ 통계 출력
//            System.out.println("📊 파일 통계 결과:");
//            System.out.println("- 라인 수: " + lineCount);
//            System.out.println("- 단어 수: " + wordCount);
//            System.out.println("- 문자 수: " + charCount);
//
//        } catch (IOException e) {
//            // ✅ 예외 처리
//            System.err.println("❌ 파일 읽기 중 오류 발생: " + e.getMessage());
//        }
//    }
//
//        // TODO: 계산된 통계 정보를 출력하세요.
//        // 1. 라인 수
//        // 2. 단어 수
//        // 3. 문자 수
//        // 4. 예외 처리
//
//
//
//    /**
//     * 파일에 내용 추가
//     */
//    private static void appendToFile(Scanner scanner) {
//        // TODO: "파일에 내용 추가하기" 타이틀을 출력하세요.
//        System.out.println("=== 파일에 내용 추가하기 ===");
//        // TODO: 파일이 존재하는지 확인하세요.
//        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
//        if (!TextFileIOLab.FILE.exists()) {
//            System.err.println("❌ 파일이 존재하지 않습니다: " + TextFileIOLab.FILE_PATH);
//            return;
//        }
//        // TODO: 사용자로부터 추가할 내용을 입력받으세요.
//        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
//        // 2. 입력된 각 줄에 줄 번호 표시하기
//        // 3. 입력받은 내용을 List<String>에 저장
//        List<String> newLines = new ArrayList<>();
//        int lineNumber = 1;
//
//        // ✅ 1. 사용자로부터 입력 받기
//        System.out.println("추가할 내용을 입력하세요 (빈 줄 입력 시 종료):");
//        while (true) {
//            System.out.print("입력 " + lineNumber + ": ");
//            String input = scanner.nextLine();
//            if (input.trim().isEmpty()) break;
//
//            newLines.add(lineNumber + ": " + input);
//            lineNumber++;
//        }
//        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 추가하세요.
//        // 1. try-with-resources 구문 사용
//        // 2. FileWriter(파일경로, true)를 사용하여 append 모드로 열기
//        // 3. 구분선("--- 추가된 내용 ---") 추가
//        // 4. 리스트의 각 줄을 파일에 추가
//        // 5. 예외 처리 및 성공 메시지 출력
//        try (
//                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))  // append 모드
//        ) {
//            writer.newLine();  // 줄 띄우기
//            writer.write("--- 추가된 내용 ---");
//            writer.newLine();
//
//            for (String line : newLines) {
//                writer.write(line);
//                writer.newLine();
//            }
//
//            System.out.println("✅ 파일에 성공적으로 추가되었습니다.");
//
//        } catch (IOException e) {
//            System.err.println("❌ 파일 쓰기 중 오류 발생: " + e.getMessage());
//        }
//
//    }
//}
//

