package com.springboot.demo.javabase;

import java.util.*;

/**
 * @program demo
 * @description: 给定一个字符串， 请将字符串李的字符按照出现的频率降序排列
 * 输入 tree
 * 输出 eert 或者eetr 都正确
 *
 * 思路leetcode
 * HashMap执行一遍统计，然后用列表存储（char-字符, int-重复次数）信息，按重复次数从大到小对列表排序，拼装最终的String。
 * @author: qitengjie
 * @create: 2022-05-17 14:18
 */
public class StrSort {

    public String frequencySort(String s){
        long start = System.currentTimeMillis();

        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0)+1);
            list.add(aChar);
        }

        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2)- map.get(o1);
            }
        });

        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : list) {
            while (map.get(character)>0){
                stringBuffer.append(character);
                map.put(character, map.get(character)-1);
            }
        }
        System.out.println("haoshi :"+ (System.currentTimeMillis()-start));

        return stringBuffer.toString();

    }

    public static void main(String[] args) {
        StrSort strSort = new StrSort();
        String tree = strSort.frequencySort("tree");
        System.out.println(tree);
    }

}
