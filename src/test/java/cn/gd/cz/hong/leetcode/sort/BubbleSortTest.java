package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.*;

/**
 * 冒泡排序
 */
public class BubbleSortTest {

    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        // 打牌的时候 从左到右 依次拿起两张牌 前面比后面的大 进行交换
        // 继续往后比较直到把最大的都挪到最后
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    @Test
    public void test() {
        int[] randomArray = makeIntArray(10);
        System.out.println("before: ");
        System.out.println(Arrays.toString(randomArray));
        sort(randomArray);
        System.out.println("after: ");
        System.out.println(Arrays.toString(randomArray));
    }
}
