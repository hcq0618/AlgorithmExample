package hcq.algorithm.example;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
 * <p/>
 * 例如输入“I am a student.”，则输出“student. a am I”。
 * <p/>
 * Created by hcq0618 on 2015/12/27.
 */
public class ReverseWord {

    public void solution(String origin) {
        String[] words = origin.split(" ");

        StringBuilder sb = new StringBuilder(origin.length());

        for (int i = 0; i < words.length; i++) {
            sb.append(words[words.length - i - 1]);
            if (i < words.length - 1)
                sb.append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
