package top.kongk.unit07.setandmap.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * 描述：唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/description/
 *
 * @author kk
 */
public class LeetCode804 {

    public int uniqueMorseRepresentations(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new TreeSet<>();

        for (String word : words) {

            if (word == null || word.length() == 0) {
                continue;
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < word.length(); ++j) {

                int index = (int) word.charAt(j) - 'a';

                if (index >= 0 && index < 26) {
                    sb.append(morse[index]);
                }
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
