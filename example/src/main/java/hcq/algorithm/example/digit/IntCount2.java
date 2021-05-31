package hcq.algorithm.example.digit;

/**
 * 数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。
 * <p>
 * 谷歌、微软面试题
 * <p>
 * Created by hcq0618 on 2015/12/27.
 */
public class IntCount2 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 1, 1, 3});
    }

    //数组中有个数字出现的次数超过了数组长度的一半。也就是说，有个数字出现的次数比其他所有数字出现次数的和还要多。
    public static void solution(int[] origin) {
        int result = 0;
        int count = 0;

        for (int j : origin) {
            if (count == 0) {
                //如果次数清空 说明不是这个数 则保存新的数
                result = j;
                count = 1;
            } else if (result == j) {
                //与当前保存的数字一致 则累加一次
                count++;
            } else {
                //否则递减一次
                count--;
            }
        }

        System.out.println(result);
    }
}
