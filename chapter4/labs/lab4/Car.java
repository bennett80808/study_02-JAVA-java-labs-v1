package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Car 클래스 정의하기 (Engine을 포함하는 관계)
 */


public class Car {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (모델명, 색상, 속도, Engine 타입의 필드 등)
    private String modelName;      // 모델명
    private String color;          // 색상
    private int speed;             // 속도
    private Engine engine;         // 사용자 정의 클래스 타입의 필드
    
    
    // TODO: 생성자를 정의하세요.
    // (Engine 객체를 생성하여 포함관계 구현)


    public Car(String modelName, String color, int speed, int horsepower, String engineType, boolean isRunning) {
        this.modelName = modelName;
        this.color = color;
        this.speed = speed;

        // 포함관계 구현: Engine 객체를 내부에서 생성하여 포함
        this.engine = new Engine(horsepower, engineType, isRunning);
    }




    // TODO: 자동차를 시동하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)
    public void start() {
        System.out.println("🚗 " + modelName + " 시동 중...");
        engine.startEngine();  // 내부적으로 Engine의 메소드 호출
    }
    
    
    // TODO: 자동차를 정지하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)
    public void stop() {
        System.out.println("🚗 " + modelName + " 시동 끄는 중...");
        engine.stopEngine();  // 내부적으로 Engine의 메소드 호출
    }
    
    
    // TODO: 자동차의 속도를 증가시키는 메소드를 정의하세요.
    public void accelerate(int amount) {
        if (engine.isRunning()) {
            speed += amount;
            System.out.println("🚀 속도가 " + amount + "km/h 증가했습니다. 현재 속도: " + speed + "km/h");
        } else {
            System.out.println("❌ 엔진이 꺼져 있어 가속할 수 없습니다.");
        }
    }

    
    // TODO: 자동차의 속도를 감소시키는 메소드를 정의하세요.
    public void brake(int amount) {
        if (engine.isRunning()) {
            if (speed - amount < 0) {
                speed = 0;
            } else {
                speed -= amount;
            }
            System.out.println("🛑 속도가 " + amount + "km/h 감소했습니다. 현재 속도: " + speed + "km/h");
        } else {
            System.out.println("❌ 엔진이 꺼져 있어 감속할 수 없습니다.");
        }
    }
    
    
    // TODO: 자동차의 정보를 출력하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 정보도 출력)
    public void printInfo() {
        System.out.println("모델명: " + modelName);
        System.out.println("색상: " + color);
        System.out.println("속도: " + speed + "km/h");
        engine.printInfo();  // 엔진 정보 출력
    }
    
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.
    public String getModelName() {
        return modelName;
    }
    public String getColor() {
        return color;
    }
    public int getSpeed() {
        return speed;
    }
    public Engine getEngine() {
        return engine;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
} 