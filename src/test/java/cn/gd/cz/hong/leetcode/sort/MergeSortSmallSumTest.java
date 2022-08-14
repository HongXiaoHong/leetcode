package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.notNeedSorted;

/**
 * 合并排序 延伸 小和问题
 */
public class MergeSortSmallSumTest {

    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        // 利用合并排序的思路
        /*
        小和问题
        在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和
        可以转换为 该数字 在右边多少个比自己大的数字 乘积 之和
        与合并差异是 先合并右边 不是先合并左边 不然会计算跟自己相等数字的结果
         */
        System.out.println("process  is  :" + process(array, 0, array.length - 1));
        ;
    }

    public int process(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(array, l, mid)
                + process(array, mid + 1, r)
                + merge(array, l, mid, r);
    }

    private int merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int lIndex = l;
        int rIndex = mid + 1;
        int i = 0;
        int sum = 0;
        while (lIndex <= mid && rIndex <= r) {
            sum += array[lIndex] < array[rIndex] ? array[lIndex] * (r - rIndex + 1) : 0;
            help[i++] = array[lIndex] < array[rIndex] ? array[lIndex++] : array[rIndex++];
        }
        while (lIndex <= mid) {
            help[i++] = array[lIndex++];
        }
        while (rIndex <= r) {
            help[i++] = array[rIndex++];
        }
        System.arraycopy(help, 0, array, l, help.length);
        return sum;
    }

    @Test
    public void test() {
        int[] randomArray = {1, 3, 4, 2, 5};
        System.out.println("before: ");
        System.out.println(Arrays.toString(randomArray));
        sort(randomArray);
        System.out.println("after: ");
        System.out.println(Arrays.toString(randomArray));
    }
}
