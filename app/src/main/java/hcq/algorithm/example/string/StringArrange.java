package hcq.algorithm.example.string;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class StringArrange {

    public static void main(String[] args) {
        solution("abc");
    }

    public static void solution(String origin) {
        arrange(origin.toCharArray(), 0, origin.length());
    }

    //例如：对于字符串ABC来讲，它所有的排列就是 A + BC 的排列 加上 B + AC 的排列，再加上 C + AB的排列。
    //而BC的排列是 B + C 的排列 加上 C + B 的排列。
    private static void arrange(char[] chars, int begin, int end) {
        if (begin == end) {
            //当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        } else {
            // 多个字母全排列  
            for (int i = begin; i < end; i++) {
                //起始与第i个交换
                swap(chars, begin, i);

                //后续元素递归全排列
                arrange(chars, begin + 1, end);

                //位置还原
                swap(chars, begin, i);
            }
        }
    }

    private static void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
