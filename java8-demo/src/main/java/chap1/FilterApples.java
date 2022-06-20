/**
 * xingbili
 */

package chap1;

import appa.Author;
import appa.Book;
import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xinghuolin
 * @create: 2022/5/1 0:06
 */
public class FilterApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 150),
                new Apple("red", 200),
                new Apple("green", 150),
                new Apple("red", 200));
//        List<Apple> greenApples = filterGreenApples(inventory);
//        List<Apple> greenApples2 = inventory.stream().filter(apple -> "green".equals(apple.getColor())).collect(Collectors.toList());
//        List<Apple> getWeightApples = inventory.stream().filter(apple -> apple.getWeight() > 150).collect(Collectors.toList());
        // 排序
        inventory.sort(Comparator.comparing(Apple::getWeight));

//        List<Apple> greenApples = filterApples(inventory, Apple::isGreenApple);
//        List<Apple> heavyApples = filterApples(inventory, Apple::isHeavyApple);
//        List<Apple> heavyApples2 = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150);
//        System.out.println(heavyApples);
         List<Apple> heavyApples = filterApples(inventory,new AppleHeavyWeightPredicate());

         // 匿名内部类
        List<Apple> apples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });

        // lambda表达式
        List<Apple> apples2 = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150);

        // 为什么类型不能兼容呢？
//        List<Apple> redApples = (List<Apple>) filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

    }


    // 类型参数化后
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    /**
     * @Description: 根据颜色筛选苹果  第一版q
     * @Param: 传入一个List<Apple> inventory
     * @return: 返回一个List<Apple>
     * @Author: xinghuolin
     * @Date: 10:11
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @Description: 根据重量筛选苹果  第一版
     * @Param: 传入一个List<Apple> inventory
     * @return: 返回一个List<Apple>
     * @Author: xinghuolin
     * @Date: 10:11
     */
    public static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (weight > apple.getWeight()) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @Description: 筛选出重量大于150的苹果
     * @Param: 传入一个List<Apple> inventory
     * @return: 返回一个List<Apple>
     * @Author: xinghuolin    xingbili
     * @Date: 10:20
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }





    //

    /**
     * 筛选出绿色苹果
     *
     * @param inventory
     * @return list
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


}

interface Predicate<T>{
    boolean test(Object t);
}

// 第二版 使用谓词
interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
