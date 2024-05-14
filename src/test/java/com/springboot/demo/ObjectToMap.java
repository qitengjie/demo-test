package com.springboot.demo;


import com.springboot.demo.stream.Users;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program demo-test
 * @description:
 * @author: jason.qi
 * @create: 2019-09-06 11:29
 */
public class ObjectToMap {
    public static void main(String[] args) {

        Users users = new Users("bbb","男",33,new Date());

//        String value = JSONObject.toJSONString(companyDO);
//        Map<String, Object> tempMap = JSONObject.parseObject(value, Map.class);


    }
}
