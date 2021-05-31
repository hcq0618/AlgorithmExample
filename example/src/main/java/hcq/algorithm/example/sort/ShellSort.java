package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 希尔排序 平均O(nlog2n)
 * <p>
 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2)的第一批算法之一。它与插入排序的不同之处在于，它会优先比较距离较远的元素。
 * <p>
 * 1. 首先确定分的组数。将数的个数设为n，取奇数k=n/2，将下标差值为k的数分为一组，构成有序序列。
 * 2. 然后对组中元素进行插入排序。
 * 3. 然后将length/2，重复1,2步，直到length=0为止。
 * <p>
 * Created by changqiang.huang on 2021/5/20 23:49
 */
public class ShellSort {

    public static void main(String[] args) {
        solution(new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6});
    }

    public static void solution(int[] original) {
        int len = original.length;
        if (len == 0) {
            System.out.print(Arrays.toString(original));
            return;
        }

        int d = original.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                //分的组数
                for (int i = x + d; i < original.length; i += d) {
                    //组中的元素，从第二个数开始
                    //j为有序序列最后一位的位数
                    int j = i - d;
                    int temp = original[i];//要插入的元素
                    for (; j >= 0 && temp < original[j]; j -= d) {
                        //从后往前遍历
                        original[j + d] = original[j];
                        //向后移动d位
                    }
                    original[j + d] = temp;
                }
            }
        }

        System.out.print(Arrays.toString(original));
    }
}