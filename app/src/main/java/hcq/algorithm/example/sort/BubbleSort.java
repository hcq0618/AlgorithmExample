package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 冒泡排序 平均O(n^2)
 * <p>
 * 两个数比较大小，较大的数下沉，较小的数冒起来。
 * 一般不用。
 * <p>
 * (1)比较相邻的元素。如果第一个比第二个大，就交换它们两个;
 * <p>
 * (2)对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数;
 * <p>
 * (3)针对所有的元素重复以上的步骤，除了最后一个;
 * <p>
 * (4)重复步骤1~3，直到排序完成。
 * <p>
 * Created by changqiang.huang on 2021/5/20 22:15
 */
public class BubbleSort {

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
            //后面已排序的 不用比较
            for (int j = 0; j < len - i - 1; j++) {
                //如果大于则交换 冒泡到最后面
                if (original[j + 1] < original[j]) {
                    int temp = original[j];
                    original[j] = original[j + 1];
                    original[j + 1] = temp;
                }
            }
        }

        System.out.print(Arrays.toString(original));
    }
}
