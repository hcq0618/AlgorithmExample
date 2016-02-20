package hcq.algorithm.example;

/**
 * 问题1：定义Fibonacci数列如下：
 * /  0                      n=0
 * f(n)=      1                      n=1
 * \  f(n-1)+f(n-2)          n>=2
 * 输入n，用最快的方法求该数列的第n项。
 * <p/>
 * 问题2：一个人上台阶可以一次上1个，2个，或者3个，问这个人上n层的台阶，总共有几种走法？
 * 把n级台阶时的跳法看成是n的函数，记为f(n)。当n>2时，第一次跳的时候就有两种不同的选择：一是第一次只跳1级，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1)；另外一种选择是第一次跳2级，此时跳法数目等于后面剩下的n-2级台阶的跳法数目，即为f(n-2)。因此n级台阶时的不同跳法的总数f(n)=f(n-1)+(f-2)。
 * <p/>
 * 如下公式：
 * /      1                                      n=1
 * f(n)=     2                                    n=2
 * 4                                      n=3       //111, 12, 21, 3
 * \  f(n-1)+(f-2)+f(n-3)                        n>3
 * <p/>
 * Created by hcq0618 on 2015/12/25.
 */
public class Fibonacci {

    public int fibonacci1(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    public int fibonacci2(int steps) {
        int[] result = {0, 1, 2, 4};
        if (steps < 4)
            return result[steps];
        return fibonacci2(steps - 1) + fibonacci2(steps - 2) + fibonacci2(steps - 3);
    }
}
