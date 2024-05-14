package com.springboot.demo.javabase;

/**
 * @program demo
 * @description: 给一个只包含'（'和'）'的字符串，找出最长有效（格式正确且连续） 括号子串的长度
 *
 * 思路leetcode
 * 对字符串遍历，进行括弧有效性验证，记录最大的有效长度。同样的方式，倒序再来一次，取最大值。
 * 时间复杂度 2*s.length；速度极快，10ms超越100%的人群
 *
 * @author: qitengjie
 * @create: 2022-05-17 14:37
 */
public class SpeStrTest {

    //本菜思路--
//    public static int maxLength(String strParam){
//        int maxFlag = 0;
//        if (!strParam.contains("(") && !strParam.contains(")")){
//            return maxFlag;
//        }
//
//        int begin = strParam.indexOf("(");
//        int end = strParam.lastIndexOf(")");
//        String substring = strParam.substring(begin, end);
//        //todo substring 判断（）包含数量是否一致， 数量多的取上一个
//
//        return end - begin;
//    }

    public int longestValidParentheses(String s){
        char[] chars = s.toCharArray();
        return Math.max(calc(chars,0,1,chars.length,'('),calc(chars,chars.length-1,-1,-1,')'));
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validlen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validlen ? max : validlen;
                sum = 0;
                currLen = 0;
                validlen = 0;
            } else if (sum == 0) {
                validlen = currLen;
            }
        }
        return max > validlen ? max : validlen;
    }

    public static void main(String[] args) {
//        int length = SpeStrTest.maxLength("(()");
//        int length = SpeStrTest.maxLength(")()())");
//        int length = SpeStrTest.maxLength("");
//        int length = SpeStrTest.maxLength("(((d(abc)))");
//        longestValidParentheses.
        SpeStrTest speStrTest = new SpeStrTest();
        int length = speStrTest.longestValidParentheses(")()())");

        System.out.println("最长有效括号字符串的长度："+length);

    }
}
