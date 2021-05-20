package hcq.algorithm.example.digit;

/**
 * 输入一个整数，求该整数的二进制表达中有多少个1。例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
 * 微软面试题
 * Created by hcq0618 on 2015/12/25.
 */
public class BinaryCount {

    public static void main(String[] args) {
        binaryCount(10);
    }

    //我们先判断整数的最右边一位是不是1。接着把整数右移一位，原来处于右边第二位的数字现在被移到第一位了，再判断是不是1。这样每次移动一位，直到这个整数变成0为止。
    //如何判断一个整数的最右边一位是不是1 有两种方法
    //1、对2求余 看余数是否为1
    //2、与整数1做与运算 由于1除了最右边一位以外，其他所有位都为0，因此如果与运算的结果为1，表示整数的最右边一位是1，否则是0。
    //由于位运算效率高于乘除运算 所以最优选择第二种
    public static void binaryCount(int i) {
        int count = 0;

        while (i != 0) {
            if ((i & 1) == 1) {
                count++;
            }

            i = i >> 1;
        }

        System.out.println(count);
    }
}
