package chapter5.labs.lab3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    private ArrayList<Buyable> items;
    
    // TODO: 생성자 정의
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public ArrayList<Buyable> getItems() {return items;}

    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addItem(Buyable item) {
        items.add(item);
        System.out.println("아이템 추가 - " + item.getName());
    }
    
    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void removeItem(String itemName) {
        Iterator<Buyable> iterator = items.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Buyable item = iterator.next();
            if (item.getName().equals(itemName)) {
                iterator.remove();
                System.out.println("장바구니에서 제거되었습니다." + item.getName());
                found = true;
                break;
            }
        }
        if (!found) {System.out.println("해당 상품이 장바구니에 없습니다.");}
    }
    
    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public int getTotalPrice() {
        int total = 0;
        for (Buyable item : items) { total+=item.getPrice(); }
        return total;
    }
    
    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void printItems() {
        if(items.isEmpty()) {System.out.println("장바구니가 비어있습니다."); return;}

        System.out.println("장바구니 목록");
        for (Buyable item : items) {System.out.println("-" + item.getName() + ": " + item.getPrice() + "원");}
        System.out.println("총합계: " + getTotalPrice() + "원");
    }
} 