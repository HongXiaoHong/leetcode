package cn.gd.cz.hong.leetcode.stream.grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 流 分组测试
 * https://blog.csdn.net/u012250875/article/details/55126531?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-55126531-blog-85268814.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-55126531-blog-85268814.pc_relevant_default&utm_relevant_index=5
 * 这个博主说 Comparator 可以用做分组
 * 但是我实在不敢苟同 觉得使用Stream去分组就可以
 * Comparator 用作比较就可以了
 */
public class Hello {
    static class Apple {
        public String color;
        public int weight;

        public Apple(String color, int weight) {
            super();
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Apple [color=" + color + ", weight=" + weight + "]";
        }
    }

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Hello.Apple("红", 205));
        list.add(new Hello.Apple("红", 131));
        list.add(new Hello.Apple("绿", 248));
        list.add(new Hello.Apple("绿", 153));
        list.add(new Hello.Apple("黄", 119));
        list.add(new Hello.Apple("黄", 224));
        /*
        多条件分组可参 Java stream 多情况分组
        来自 <https://blog.csdn.net/hfaflanf/article/details/106428767>
         */
        Map<String, List<Apple>> colorGroups = list.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println("colorGroups : " + colorGroups);
        Map<Integer, List<Apple>> heavyweightGroups = list.stream().collect(Collectors.groupingBy(apple -> apple.weight / 100));
        System.out.println("heavyweightGroups : " + heavyweightGroups);
    }
}
