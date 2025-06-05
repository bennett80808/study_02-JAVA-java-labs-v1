package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Book 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Book implements Buyable {
    // TODO: 책의 속성 정의 (예: 제목, 가격, 저자)
    String title;
    int price;
    String author;
    
    // TODO: 생성자 정의
    Book(String title, int price, String author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }
    
    // TODO: Buyable 인터페이스의 메소드 구현
    @Override
    public int getPrice(){return price;}

    @Override
    public String getName(){return title;}

    @Override
    public void productInfo(){
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Author: " + author);
    }
    // TODO: 책만의 고유한 메소드 추가
    public void Origin(){
        System.out.println("책 고유의 메소드입니다.");
    }
} 