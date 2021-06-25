package hcq.algorithm.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by changqiang.huang on 2021/6/24 20:52
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int length = str.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            String sub = str.substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                int len = s.length();
                if (i >= len) {
                    sub = "";
                    break;
                }
                String sub2 = s.substring(0, i + 1);
                if (!sub.equals(sub2)) {
                    sub = "";
                    break;
                }
            }
            if (sub.length() > 0) {
                result = sub;
            }
        }
        return result;
    }

}
