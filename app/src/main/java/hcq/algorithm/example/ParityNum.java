package hcq.algorithm.example;

/**
 * 输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class ParityNum {

    //两个指针 分别位置前后 相向移动 若前面的是偶数则交换并移动指针 若后面是奇数则交换并移动指针 最后在中间相遇
    public void solution(int[] origin) {
        int begin = 0;
        int end = origin.length - 1;

        while (begin < end) {
            int front = origin[begin];
            int back = origin[end];

            if (front % 2 == 0) {

                if (back % 2 == 1) {
                    //前偶数 后奇数 交换 两个指针都要移动
                    int temp = front;
                    origin[begin] = back;
                    origin[end] = temp;

                    end--;
                    begin++;
                } else {
                    //前后都是偶数 不用交换 只移动后面的指针
                    end--;
                }

            } else {
                if (back % 2 == 1) {

                    //前后都是奇数 不用交换 只移动前面的指针
                    begin--;
                } else {

                    //位置正确 不用交换 只移动两个指针
                    begin++;
                    end--;
                }
            }
        }

        for (int i = 0; i < origin.length; i++) {
            System.out.println(origin[i]);
        }
    }
}
