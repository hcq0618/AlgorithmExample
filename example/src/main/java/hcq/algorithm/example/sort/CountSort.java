package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 计数排序 Ο(n+k)（其中k是整数的范围）
 * <p>
 * 它的优势在于在对一定范围内的整数排序时，快于任何比较排序算法。而且当O(k)>O(n*log(n))的时候其效率反而不如基于比较的排序（基于比较的排序的时间复杂度在理论上的下限是O(n*log(n)), 如归并排序，堆排序）
 * <p>
 * 1、花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
 * 2、开辟一块新的空间创建新的数组 B，长度为 ( max - min + 1)
 * 3、数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
 * 4、最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
 * <p>
 * Created by changqiang.huang on 2021/5/21 19:33
 */
public class CountSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6, 4, 3, 1, 2, 9};
        int[] minAndMaxValue = getMinAndMaxValue(array);

        System.out.print(Arrays.toString(countingSort(array, minAndMaxValue[0], minAndMaxValue[1])));
    }

    private static int[] countingSort(int[] original, int minValue, int maxValue) {
        int bucketLen = maxValue - minValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : original) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                original[sortedIndex] = j;
                sortedIndex++;
                bucket[j]--;
            }
        }
        return original;
    }

    private static int[] getMinAndMaxValue(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            } else if (minValue > value) {
                minValue = value;
            }
        }
        return new int[]{minValue, maxValue};
    }
}
