package hcq.algorithm.example.sort;

import java.util.Arrays;

/**
 * 插入排序 平均O(n^2)
 * <p>
 * 1. 将第一个数和第二个数排序，然后构成一个有序序列
 * 2. 将第三个数插入进去，构成一个新的有序序列。
 * 3. 对第四个数、第五个数……直到最后一个数，重复第二步。
 * <p>
 * Created by changqiang.huang on 2021/5/20 22:53
 */
public class InsertionSort {
    public static void main(String[] args) {
        solution(new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6});
    }

    public static void solution(int[] original) {
        int len = original.length;
        if (len == 0) {
            System.out.print(Arrays.toString(original));
            return;
        }

        //插入的次数
        for (int i = 1; i < len; i++) {
            //要插入的数
            int insertNum = original[i];
            //已经排序好的序列元素个数
            int j = i - 1;
            while (j >= 0 && original[j] > insertNum) {
                //序列从后到前循环，将大于insertNum的数向后移动一格
                original[j + 1] = original[j];
                //元素向前移动一格
                j--;
            }
            //将需要插入的数放在要插入的位置。
            original[j + 1] = insertNum;
        }

        System.out.print(Arrays.toString(original));
    }
}
