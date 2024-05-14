package com.springboot.demo.javabase;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @program demo
 * @description:
 * @author: qitengjie
 * @create: 2022-05-17 14:25
 */
public class StrWordDictTest {

    public boolean containDic(String strParam, List<String> dictList){
        boolean containFlag = false;
        if (StringUtils.isEmpty(strParam) || CollectionUtils.isEmpty(dictList)){
            return containFlag;
        }

        for (String dict : dictList) {
            if (strParam.contains(dict)){
                String[] split = strParam.split(dict);
                List<String> spList = Arrays.asList(split);
                return dictList.containsAll(spList);
            }
        }

        return containFlag;
    }
}
