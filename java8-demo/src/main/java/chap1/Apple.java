/**
 * xingbili
 */

package chap1;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xinghuolin
 * @create: 2022/5/1 10:48
 */
public class Apple {
    private int weight;
    private String color;

    public Apple(String color, int weight) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> inventory;

    static {
        inventory = Arrays.asList(new Apple("green", 150),
                new Apple("red", 200),
                new Apple("green", 150),
                new Apple("red", 200));
    }

    public interface ApplePredicate<T> {
        boolean test(T t);
    }

    @Override
    public String toString() {
        return "Apple{" + "weight=" + weight + ", color='" + color + "'}";
    }
}
