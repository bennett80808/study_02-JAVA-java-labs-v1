package chapter8.labs.lab2;
import java.util.Objects;
/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 *
 * 도서 관리 시스템에서 사용할 도서 클래스입니다.
 */
public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int publicationYear;
    private double price;
    
    /**
     * 생성자
     */
    public Book(String isbn, String title, String author, String category, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publicationYear = publicationYear;
        this.price = price;
    }
    
    // TODO: getter와 setter 메소드를 구현하세요.
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    // TODO: toString 메소드를 오버라이드하세요.
    @Override
    public String toString() {
        return String.format("[ISBN: %s, 제목: %s, 저자: %s, 분야: %s, 출간연도: %d, 가격: %.2f원]",
                isbn, title, author, category, publicationYear, price);
    }
    
    // TODO: equals 메소드를 오버라이드하세요.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return Objects.equals(this.isbn, other.isbn);
    }
    
    // TODO: hashCode 메소드를 오버라이드하세요.
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
    
    /**
     * Comparable 인터페이스의 compareTo 메소드 구현
     * 기본적으로 ISBN 기준으로 비교합니다.
     */
    @Override
    public int compareTo(Book other) {
        // TODO: ISBN 기준으로 비교하도록 구현하세요.
         return this.isbn.compareTo(other.isbn); // 기본 정렬: ISBN 오름차순
    }
} 