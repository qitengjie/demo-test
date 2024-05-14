package com.springboot.demo.javabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program demo
 * @description:题目：
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * ————————————————
 * 版权声明：本文为CSDN博主「白眉道长」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_33550394/article/details/114859201
 *
 * 思路leetcode
 * 看到这道题目的时候，大家应该回想起我们之前讲解回溯法专题的时候，讲过的一道题目回溯算法：分割回文串，就是枚举字符串的所有分割情况。
 * 回溯算法：分割回文串：是枚举分割后的所有子串，判断是否回文。
 * 本道是枚举分割所有字符串，判断是否在字典里出现过。
 *
 * ## 总结
 * 本题和我们之前讲解回溯专题的回溯算法：分割回文串非常像，所以我也给出了对应的回溯解法。
 * 稍加分析，便可知道本题是完全背包，而且是求能否组成背包，所以遍历顺序理论上来讲 两层for循环谁先谁后都可以！
 * 但因为分割子串的特殊性，遍历背包放在外循环，将遍历物品放在内循环更方便一些。
 * 本题其实递推公式都不是重点，遍历顺序才是重点，如果我直接把代码贴出来，估计同学们也会想两个for循环的顺序理所当然就是这样，甚至都不会想为什么遍历背包的for循环为什么在外层。
 * @author: qitengjie
 * @create: 2022-05-18 14:39
 */
public class StrWordDictTest1 {

    public static boolean workBreak(String s, List<String> wordDict){
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i =1; i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (wordDict.contains(s.substring(j,i)) && valid[j]){
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }

    public static void main(String[] args) {
        String str = "catsandog";

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        boolean b = workBreak(str, wordDict);
        System.out.println(b);

    }


}





