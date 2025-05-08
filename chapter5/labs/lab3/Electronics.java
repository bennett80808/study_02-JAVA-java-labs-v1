package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Electronics 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Electronics implements Buyable {
    // TODO: 전자제품의 속성 정의 (예: 이름, 가격, 제조사)
    String name;
    int price;
    String maker;
    
    // TODO: 생성자 정의
    Electronics(String name, int price, String maker) {
        this.name = name;
        this.price = price;
        this.maker = maker;
    }
    
    // TODO: Buyable 인터페이스의 메소드 구현
    @Override
    public int getPrice(){return price;}

    @Override
    public String getName(){return name;}

    @Override
    public void productInfo(){
        System.out.println("Name: " + name + " Price: " + price + " Maker: " + maker);
    }
    
    // TODO: 전자제품만의 고유한 메소드 추가
    public void electronicOrigin(){System.out.println("It is electronic origin");}
} 