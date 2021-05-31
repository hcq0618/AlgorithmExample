package hcq.algorithm.example.string;

/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”。
 * <p/>
 * 微软面试题
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class StringDelete {

    public static void main(String[] args) {
        solution("They are students.", "aeiou");
    }

    public static void solution(String origin, String delStr) {
        //一个char占两个字节=16位 所以表示char有2^16种可能
        // 创建一个简单的哈希表 每个位置下标代表char的ASCII码值 所存的值为出现的计数
        int[] hashTable = new int[(int) Math.pow(2, 16)];

        //把要删除字符串的字符标记为1
        int len = delStr.length();
        for (int i = 0; i < len; i++) {
            char c = delStr.charAt(i);
            hashTable[c] = 1;
        }

        len = origin.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = origin.charAt(i);
            //如果不是要被删除的字符 则输出
            if (hashTable[c] != 1) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
