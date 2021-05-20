package hcq.algorithm.example.digit;

import java.util.ArrayList;

/**
 * 输入n个整数，输出其中最小的k个。
 * <p>
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 * <p>
 * Created by hcq0618 on 2015/12/27.
 */
public class IntMin {

    public static void main(String[] args) {
        solution(3, 2, 6, 8, 7, 5, 1);
    }

    public static void solution(int k, int... origin) {
        ArrayList<Integer> sortList = new ArrayList<>(origin.length);

        //先直接插入排序
        for (int value : origin) {
            if (sortList.isEmpty()) {
                sortList.add(value);
                continue;
            }

            int size = sortList.size();
            for (int i = 0; i < size; i++) {
                if (value >= sortList.get(i)) {
                    if (i + 1 < size) {
                        if (value <= sortList.get(i + 1)) {
                            sortList.add(i + 1, value);
                            break;
                        }
                    } else {
                        sortList.add(value);
                        break;
                    }
                } else {
                    sortList.add(Math.max(i - 1, 0), value);
                    break;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(sortList.get(i));
        }
    }
}
