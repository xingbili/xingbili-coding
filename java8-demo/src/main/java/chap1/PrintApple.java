/**
 * xingbili
 */

package chap1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 打印苹果
 * @author: xinghuolin
 * @create: 2022/5/1 10:48
 */
public class PrintApple {



    public static void main(String[] args) {
        List<Apple> inventory = Apple.inventory;
        prettyPrintApple(inventory, new AppleSimpleFormatter());
        prettyPrintApple(inventory, new AppleColorFormatter());

        // 匿名内部类
        prettyPrintApple(inventory, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                return apple.getColor();
            }
        });
        //  lambda表达式
        prettyPrintApple(inventory, (Apple apple) -> apple.getColor());


    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list , Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}


interface AppleFormatter {
    String accept(Apple apple);
}

class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return apple.getWeight() + "g " + apple.getColor();
    }
}

class AppleColorFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return apple.getColor() + "颜色的苹果 " + apple.getWeight() + "g";
    }
}