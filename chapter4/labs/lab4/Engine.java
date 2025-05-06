package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */

public class Engine {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)
    private int horsepower;
    private String type;
    private boolean isRunning;



    // TODO: 생성자를 정의하세요.
    public Engine(int horsepower, String type, boolean isRunning) {
        this.horsepower = horsepower;
        this.type = type;
        this.isRunning = isRunning;
    }
    
    
    // TODO: 엔진을 시작하는 메소드를 정의하세요.
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("🔧 엔진이 시동되었습니다.");
        } else {
            System.out.println("⚠️ 이미 시동이 걸려 있습니다.");
        }
    }
    
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.
    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println("🔧 엔진이 꺼집니다.");
        } else {
            System.out.println("⚠️ 이미 엔진이 꺼져 있습니다.");
        }
    }
    
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
    public boolean isRunning() {
        return isRunning;
    }
    
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.
    public void printInfo() {
        System.out.println("🔍 엔진 정보:");
        System.out.println("- 출력(horsepower): " + horsepower + " HP");
        System.out.println("- 타입(type): " + type);
        System.out.println("- 상태: " + (isRunning ? "시동 켜짐" : "시동 꺼짐"));
    }
    
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.
    // Getter: 마력
    public int getHorsepower() {
        return horsepower;
    }

    // Setter: 마력
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    // Getter: 타입
    public String getType() {
        return type;
    }

    // Setter: 타입
    public void setType(String type) {
        this.type = type;
    }
    
} 