package hcq.algorithm.example;

import java.util.ArrayList;

/**
 * 输入n个整数，输出其中最小的k个。
 * <p>
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 * <p>
 * Created by hcq0618 on 2015/12/27.
 */
public class IntMin {

    public void solution(int k, int... origin) {

        ArrayList<Integer> newList = new ArrayList<>(origin.length);

        //先直接插入排序
        for (int i = 0; i < origin.length; i++) {

            for (int j = 0; j < origin.length; j++) {
                if (j >= newList.size()) {
                    newList.add(origin[i]);
                    break;
                }

                if (origin[i] >= newList.get(j)) {
                    if (j + 1 < newList.size()) {
                        if (origin[i] <= newList.get(j + 1)) {
                            newList.add(j + 1, origin[i]);
                            break;
                        }
                    } else {
                        newList.add(origin[i]);
                        break;
                    }
                } else {
                    if (j - 1 <= 0) {
                        newList.add(0, origin[i]);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(newList.get(i));
        }
    }
}
