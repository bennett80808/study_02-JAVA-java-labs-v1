package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Driver 클래스 정의하기 (Car를 사용하는 관계)
 */
public class Driver {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (이름, 운전 경력 등)
    String name = "김상우";
    double drivingHistory = 4.6;
    
    
    // TODO: 생성자를 정의하세요.
    public Driver(String name,double drivingHistory) {
        this.name = name;
        this.drivingHistory = drivingHistory;
    }
    
    
    // TODO: 자동차를 운전하는 메소드를 정의하세요.
    // (Car 객체를 매개변수로 받아 사용 관계 구현)
    public void driveCar(Car car) {
        System.out.println("🚗 " + name + "님이 자동차를 운전합니다.");
        car.start();         // 시동 걸고
        car.accelerate(30);  // 속도 증가
    }
    
    
    // TODO: 자동차를 점검하는 메소드를 정의하세요.
    // (Car 객체를 매개변수로 받아 사용 관계 구현)
    public void checkCar(Car car) {
        System.out.println("🔍 " + name + "님이 자동차를 점검합니다.");
        car.getEngine().printInfo(); // 엔진 정보 확인
    }
    
    
    // TODO: 운전자의 정보를 출력하는 메소드를 정의하세요.
    public void printInfo() {
        System.out.println("👤 운전자 이름: " + name);
        System.out.println("🛣️ 운전 경력: " + drivingHistory + "년");
    }
    
} 