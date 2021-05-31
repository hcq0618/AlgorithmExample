package hcq.algorithm.example.digit;

/**
 * 输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class IntSum {

    //最初我们找到数组的第一个数字和最后一个数字。当两个数字的和大于输入的数字时，把较大的数字往前移动；当两个数字的和小于数字时，把较小的数字往后移动；当相等时，打完收工。
    public void solution(int[] origin, int sum) {
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
