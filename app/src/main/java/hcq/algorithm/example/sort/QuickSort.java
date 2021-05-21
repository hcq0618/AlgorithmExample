package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 快速排序 平均O(nlog2n)
 * <p>
 * 要求时间最快时。
 * <p>
 * 1. 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 2. 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 * <p>
 * Created by changqiang.huang on 2021/5/21 15:36
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6};
        quickSort(array, 0, array.length - 1);
        System.out.print(Arrays.toString(array));
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end)) { i++; }
                while ((numbers[j] > base) && (j > start)) { j--; }
                if (i <= j) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) { quickSort(numbers, start, j); }
            if (end > i) { quickSort(numbers, i, end); }
        }
    }
}
