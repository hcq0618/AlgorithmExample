package hcq.algorithm.example;

/**
 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 * 这道题是2006年google的一道笔试题。
 * Created by hcq0618 on 2015/12/25.
 */
public class CharCount {

    //一个char占两个字节 16位 所以表示char有2^16种可能 
    // 创建一个简单的哈希表 每个位置下标代表char的ASCII码值 所存的值为出现的计数
    private int[] hashTable = new int[(int) Math.pow(2, 16)];

    //时间复杂度O(n) 不需要嵌套循环
    public void charCount(String origin) {

        int len = origin.length();
        for (int i = 0; i < len; i++) {
            char temp = origin.charAt(i);
            hashTable[temp] += 1;
        }

        for (int i = 0; i < len; i++) {
            char temp = origin.charAt(i);
            if (hashTable[temp] == 1) {
                System.out.println(temp);
                break;
            }
        }

    }
}
