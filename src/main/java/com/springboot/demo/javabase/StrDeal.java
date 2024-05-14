package com.springboot.demo.javabase;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program demo
 * @description: 字符串处理
 * @author: qitengjie
 * @create: 2024-05-10 11:06
 */
public class StrDeal {


    // a文件路径 (输入文件)
    private static final String input = "c:/A.txt";
    // b文件路径 (输出文件)
    private static final String output = "c:/B.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(input)));
        PrintWriter writer = new PrintWriter(new File(output));
        String message = null; // 存储用户输入的字符串
        try {
            while ((message = reader.readLine()) != null) {
                // 打印处理前的字符串
                System.out.println("读入的字符串为:" + message);
                int count = strCount(message, "\n");

                //反转后的行内容
                List<String> stringList = new ArrayList<>();
//                if (count>0) {
//                    //行内容截取开始位置
//                    int temp = 0;
//                    for (int i=0;i<=count;i++) {
//                        //commons-lang3-3.9
//                        int index1 = StringUtils.ordinalIndexOf(message,"\n",i);
//                        temp = index1;
//                        String substring = message.substring(temp, index1);
//                        if (substring.contains("'")) {
//                            continue;
//                        }
//                        stringList.add(new StringBuilder(substring).reverse().toString());
//                    }
//                }
//
//                if (CollectionUtils.isNotEmpty(stringList)) {
//                    //反转行
//                    Collections.reverse(stringList);
//                    message = StringUtils.join(stringList,"").toString;
//                }

                // 打印处理后的字符串
                System.out.println("处理后为:" + message);
                writer.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常，程序退出!");
        }
        writer.close();// 关闭
        reader.close();
    }

    /**
     *
     * @param str 源字符串
     * @param findByStr 被查询的字符串
     * @return 返回findByStr在str中出现的次数
     */
    public static int strCount(String str,String findByStr){
        String[] split = str.split("");
        return Arrays.asList(split).stream().filter(s -> s.equals(findByStr)).collect(Collectors.toList()).size();
    }
}
