package hcq.algorithm.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2-10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class PokerStraight {

    public void solution(int[] pokers) {
        if (pokers == null) {
            pokers = new int[5];
            //随机五张牌 大小王看成是0
            Random random = new Random();

            for (int i = 0; i < pokers.length; i++) {
                pokers[i] = random.nextInt(14);
                System.out.println(pokers[i]);
            }
        }

        int pokersSize = pokers.length;
        int zeroCount = 0;

        ArrayList<Integer> newPokers = new ArrayList<>(pokersSize);
        //先从小到大做直接插入排序
        for (int i = 0; i < pokersSize; i++) {

            //0为大小王 可以代表任何数 所以跳过不加入排序后的数组 但要计数
            if (pokers[i] == 0) {
                zeroCount++;
                continue;
            }

            for (int j = 0; j < pokersSize; j++) {
                if (j >= newPokers.size()) {
                    newPokers.add(pokers[i]);
                    break;
                }

                if (pokers[i] >= newPokers.get(j)) {
                    if (j + 1 < newPokers.size()) {
                        if (pokers[i] <= newPokers.get(j + 1)) {
                            newPokers.add(j + 1, pokers[i]);
                            break;
                        }
                    } else {
                        newPokers.add(pokers[i]);
                        break;
                    }
                } else {
                    if (j - 1 <= 0) {
                        newPokers.add(0, pokers[i]);
                        break;
                    }
                }
            }
        }

        boolean isStraight = true;
        //如果原数组中有大小王 则size！=pokersSize;
        int size = newPokers.size();
        //每相邻两个数的差之和
        int sum = 0;

        for (int i = 0; i < size; i++) {
            //输出排序后的数组
            System.out.println(newPokers.get(i));

            if (i + 1 < size) {
                if (newPokers.get(i) == newPokers.get(i + 1)) {
                    //有对子就不是顺子
                    isStraight = false;
                    break;
                } else {
                    sum += newPokers.get(i + 1) - newPokers.get(i) - 1;
                    //如果每相邻两个数的差之和大于大小王的个数 则说明通过无法大小王补位来成为顺子
                    if (sum > zeroCount) {
                        isStraight = false;
                        break;
                    }
                }
            }
        }

        System.out.println("isStraight:" + isStraight);
    }
}
