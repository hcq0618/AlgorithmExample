package hcq.algorithm.example.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序 平均O(d(n+r))
 * <p>
 * 用于大量数，很长的数进行排序时。
 * <p>
 * 1. 将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
 * 2. 将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
 * <p>
 * Created by changqiang.huang on 2021/5/21 16:10
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 4, 2, 3, 5, 0, 8, 7, 6};
        sort(array);
        System.out.print(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        //首先确定排序的趟数;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int time = 0;
        //判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }

        //建立10个队列;
        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }

        //进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            //分配数组元素;
            for (int value : array) {
                // 得到数字的第time+1位数;
                int x = value % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(value);
                queue.set(x, queue2);
            }
            int count = 0;//元素计数器;
            // 收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k)
                        .size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

}
