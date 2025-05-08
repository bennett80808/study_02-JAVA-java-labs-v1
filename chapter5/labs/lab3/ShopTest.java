package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성
        Book book = new Book("노인과 바다", 10000, "헤밍웨이");
        
        // TODO: Electronics 객체 생성
        Electronics electronics = new Electronics("Model Z", 210000, "BMW");
        
        // TODO: DiscountedBook 객체 생성
        DiscountedBook discountedBook = new DiscountedBook("이성과 감성", 5000, "제인", 50);
        
        // TODO: ShoppingCart 객체 생성
        ShoppingCart shoppingCart = new ShoppingCart();
        
        // TODO: 장바구니에 상품 추가하기
        shoppingCart.addItem(electronics);
        shoppingCart.addItem(book);
        shoppingCart.addItem(discountedBook);
        
        // TODO: 장바구니 내용과 총액 출력하기
        shoppingCart.getTotalPrice();
        
        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        shoppingCart.printItems();
        
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        System.out.println("할인된 목록");
        for (Buyable item : shoppingCart.getItems()) {
            if (item instanceof Discountable) {
                Discountable dicountedItems = (Discountable) item;
                System.out.println("-" + item.getName() + " -할인율: " + dicountedItems.getDiscountPercentage()
                        + "% -최종가: " + item.getPrice() + "원");
            }

        }
    }
} 