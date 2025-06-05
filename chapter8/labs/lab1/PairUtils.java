package chapter8.labs.lab1;
import java.util.List;
import java.util.function.Predicate;
/**
 * Lab 1: 제네릭 유틸리티 클래스
 *
 * 다양한 제네릭 메소드를 포함한 유틸리티 클래스를 구현하세요.
 */
public class PairUtils {
    
    /**
     * 두 객체로 구성된 Pair 객체를 생성하는 정적 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
    
    /**
     * Pair 객체의 키와 값을 바꾼 새로운 Pair 객체를 반환하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.getValue(), pair.getKey());
    }
    
    /**
     * 숫자 타입의 Pair 객체에서 키와 값의 합을 계산하는 메소드
     * Number 또는 그 하위 클래스 타입만 허용
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <N extends Number> double sum(Pair<N, N> pair) {
        return pair.getKey().doubleValue() + pair.getValue().doubleValue();
    }
    
    /**
     * 두 Pair 객체를 비교하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> boolean equals(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.equals(p2);
    }
    
    /**
     * 리스트에서 조건에 맞는 요소로 구성된 Pair 객체를 찾는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <T> Pair<T, T> findMatchingPair(List<T> list, Predicate<T> condition) {
        for (int i = 0; i < list.size(); i++) {
            T first = list.get(i);
            if (condition.test(first)) {
                for (int j = i + 1; j < list.size(); j++) {
                    T second = list.get(j);
                    if (condition.test(second)) {
                        return new Pair<>(first, second);
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * 와일드카드를 사용하여 Pair 객체의 모든 가능한 타입을 처리하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static void printPair(Pair<?, ?> pair) {
        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
    }
} 