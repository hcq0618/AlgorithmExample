package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 归并排序 平均O(nlog2n)
 * <p>
 * 该算法是采用分治法(Divide and Conquer)的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列;即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * 速度仅次于快排，内存少的时候使用，可以进行并行计算的时候使用。
 * <p>
 * 1. 选择相邻两个数组成一个有序序列。
 * 2. 选择相邻的两个有序序列组成一个有序序列。
 * 3. 重复第二步，直到全部组成一个有序序列。
 * <p>
 * Created by changqiang.huang on 2021/5/20 23:58
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(mergeSort(new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6})));
    }

    public static int[] mergeSort(int[] original) {
        int len = original.length;
        if (len < 2) {
            return original;
        }

        int mid = len / 2;
        int[] left = mergeSort(Arrays.copyOfRange(original, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(original, mid, len));

        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }

        return result;
    }

}
