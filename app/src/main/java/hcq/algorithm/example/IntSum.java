package hcq.algorithm.example;

/**
 * 输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class IntSum {

    public void solution1(int[] origin, int sum) {

        //从后往前找到小于等于和的数字中最大一个数字 为了节省最大分配空间
        int max = 0;
        for (int i = 0; i < origin.length; i++) {
            if (origin[origin.length - i - 1] <= sum) {
                max = origin[origin.length - i - 1];
                break;
            }
        }

        //因为是个升序排序过的数组 所以建个哈希表 长度范围为小于等于和的数字中最大一个数字+1
        //这里有个问题就是 如果数字特别大 那这个占用空间就非常大
        int[] hashTable = new int[max + 1];

        //哈希表下标为数组中的数字 并赋值为1
        for (int i = 0; i < origin.length; i++) {
            hashTable[origin[i]] = 1;
        }

        //看是否有对应差的数字
        for (int i = 0; i < origin.length; i++) {
            int differ = sum - origin[i];
            if (hashTable[differ] == 1) {
                System.out.println(origin[i]);
                System.out.println(differ);
                break;
            }
        }
    }

    //    最初我们找到数组的第一个数字和最后一个数字。当两个数字的和大于输入的数字时，把较大的数字往前移动；当两个数字的和小于数字时，把较小的数字往后移动；当相等时，打完收工。
    public void solution2(int[] origin, int sum) {
        int begin = 0;
        int end = origin.length - 1;

        while (begin < end && origin[begin] + origin[end] != sum) {
            if (origin[begin] + origin[end] > sum) {
                //太大了 要小一点
                end--;
            } else {
                //太小了 要大一点
                begin++;
            }
        }

        System.out.println(origin[begin]);
        System.out.println(origin[end]);
    }
}
