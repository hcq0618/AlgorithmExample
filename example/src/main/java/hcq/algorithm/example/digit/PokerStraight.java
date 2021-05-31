package hcq.algorithm.example.digit;

import java.util.ArrayList;
import java.util.Random;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2-10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class PokerStraight {

    public static void main(String[] args) {
        int[] pokers = new int[5];
        //随机五张牌 0看成是大小王
        Random random = new Random();

        for (int i = 0; i < pokers.length; i++) {
            pokers[i] = random.nextInt(14);
            System.out.println(pokers[i]);
        }

        solution(pokers);
        solution(new int[]{1, 3, 2, 4, 6, 5, 8, 7, 9, 12, 13, 11, 0});
    }

    public static void solution(int[] pokers) {
        int pokersSize = pokers.length;
        int zeroCount = 0;

        ArrayList<Integer> newPokers = new ArrayList<>(pokersSize);
        //先从小到大做直接插入排序
        for (int poker : pokers) {

            //0为大小王 可以代表任何数 所以跳过不加入排序后的数组 但要计数
            if (poker == 0) {
                zeroCount++;
                continue;
            }

            if (newPokers.isEmpty()) {
                newPokers.add(poker);
                continue;
            }

            for (int i = 0; i < pokersSize; i++) {
                if (poker >= newPokers.get(i)) {
                    if (i + 1 < newPokers.size()) {
                        if (poker <= newPokers.get(i + 1)) {
                            newPokers.add(i + 1, poker);
                            break;
                        }
                    } else {
                        newPokers.add(poker);
                        break;
                    }
                } else {
                    newPokers.add(Math.max(i - 1, 0), poker);
                    break;
                }
            }
        }

        //如果原数组中有大小王 则size！=pokersSize;
        boolean isStraight = true;
        int size = newPokers.size();
        //每相邻两个数的差之和
        int sum = 0;

        for (int i = 0; i < size; i++) {
            //输出排序后的数组
            //System.out.println(newPokers.get(i));

            if (i + 1 < size) {
                if (newPokers.get(i)
                        .equals(newPokers.get(i + 1))) {
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
