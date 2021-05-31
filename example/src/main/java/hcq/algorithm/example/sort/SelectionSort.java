package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 选择排序 平均O(n^2)
 * <p>
 * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小(大)元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小(大)元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * <p>
 * Created by changqiang.huang on 2021/5/20 22:39
 */
public class SelectionSort {

    public static void main(String[] args) {
        solution(new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6});
    }

    public static void solution(int[] original) {
        int len = original.length;
        if (len == 0) {
            System.out.print(Arrays.toString(original));
            return;
        }

        for (int i = 0; i < len; i++) {
            int minIndex = i;
            //未排序的数列
            for (int j = i; j < len; j++) {
                //找到最小的数
                if (original[j] < original[minIndex]) {
                    //得到最小的数索引
                    minIndex = j;
                }
            }

            //交换当前数和最小数
            int temp = original[i];
            original[i] = original[minIndex];
            original[minIndex] = temp;
        }

        System.out.print(Arrays.toString(original));
    }
}
