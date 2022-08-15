package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.*;

/**
 * 快速排序
 */
public class QuickSortTest {

    /**
     * 荷兰国旗问题
     * <p>
     * 问题一
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
     * 要求额外空间复杂度0（1），时间复杂度0（N）
     * <p>
     * 问题二（荷兰国旗问题）
     * 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放在数组的中间，大于num的数放在数组的 右边。
     * 要求额外空间复杂度0（1），时间复杂度(N)0
     */
    @Test
    public void netherlandsFlag() {
        int N = 10;
        int[] randomArray = makeIntArray(N);
        int num = randomArray[N - 2];
        /*
         思路:
         从左到右数数
         小了就放左边 大了就放右边 相等不动
         */
        int smallIndex = 0;
        int bigIndex = randomArray.length - 1;
        for (int i = 0; i < randomArray.length && i <= bigIndex; i++) {
            if (randomArray[i] < num) {
                swap(randomArray, i, smallIndex++);
            }
            if (randomArray[i] > num) {
                swap(randomArray, i, bigIndex--);
            }
        }
        System.out.println("randomArray is " + Arrays.toString(randomArray) + ", num is " + num);
    }

    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        // 打牌的时候 平均分成两堆牌组
        // 不断地往下拆分
        // 直到剩余一张
        // 然后不断向上合并排序
        process(array, 0, array.length - 1);
    }

    public void process(int[] array, int l, int r) {
        if (l < r) {
            swap(array, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(array, l, r);
            process(array, l, p[0] - 1);
            process(array, p[1] + 1, r);
        }
    }

    /**
     * 对数组进行拆分
     * 最后一个数字作为比较的数字 num
     * 分为 <num 区 ==num区 >num区
     *
     * @param array 原数组
     * @param l     左边界
     * @param r     右边界
     * @return 返回 == num区的左边界跟右边界
     */
    private int[] partition(int[] array, int l, int r) {
        int smallIndex = l - 1; // < 区边界
        int bigIndex = r; // > 区边界
        /*
        此方法 有问题  比较值记为 num
        <区 比较值 下标向右移动 原数组继续向右遍历没有问题
        >区 只比较一次可能会有问题 可能交换过来的数字没有与num进行比较只进行一次比较直接遍历下一个数字是有问题的
        所以得用while 而不是for
        for (int i = l; i <= r && i <= bigIndex; i++) {
            if (array[i] < array[r]) {
                swap(array, i, smallIndex++);
            }
            if (array[i] > array[r]) {
                swap(array, i, bigIndex--);
            }
        }*/
        while (l < bigIndex) { // 只要遍历的下标还没与>区的下标碰撞
            if (array[l] < array[r]) {
                swap(array, ++smallIndex, l++);
            } else if (array[l] > array[r]) {
                swap(array, --bigIndex, l); // 这里不 ++ 是因为交换过来的数字可能还没进行比较 需要再次进入循环
            } else {
                l++;
            }
        }
        swap(array, bigIndex, r); // 将最后一个数字即比较数字num 与 >区第一个数字进行交换
        return new int[]{smallIndex + 1, bigIndex};
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
