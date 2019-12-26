package com.springboot.demo.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program hr-core
 * @description: 获取Stream
 * @author: jason
 * @create: 2019-08-18 00:07
 */
public class testStream {

    List<StreamUser> list = Arrays.asList(new StreamUser("aaa",11),
            new StreamUser("bbb",22),
            new StreamUser("ccc",91),
            new StreamUser("ddd",44),
            new StreamUser("eee",555)
    );


    public static void main(String[] args) {
        //数组
        String[] aa = {"aaa","bbb","ccc"};
        Stream<String> arrayStream = Arrays.stream(aa);
        //集合
        List<String> listString = Arrays.asList("ab","ac","bc");
        Stream<String> listStream = listString.stream();
        //值
        Stream<String> valueStream = Stream.of("aaa","bbb");

    }

    /**
     * forEach 迭代输出每条数据
     */
    @Test
    public void testForEach(){


        //java8 前
        System.out.println("java8 前");
        for (StreamUser user : list) {
            System.out.println(user);
        }

        //java8 lambda
        System.out.println("java8 lambda");
        list.forEach(user ->System.out.println(user));

        //java8 Stream lambda
        System.out.println("java8 Stream lambda");
        list.stream().forEach(user->System.out.println(user));

    }

    /**
     * sort 排序.
     */
    public void testSort(){
        System.out.println("-----排序前----");
        list.forEach(StreamUser ->System.out.println(StreamUser));

        System.out.println("-------排序后-------");
        //Java 8 前
        System.out.println("-------Java 8 前------");

        Collections.sort(list, new Comparator<StreamUser>() {
            @Override
            public int compare(StreamUser o1, StreamUser o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });

        for (StreamUser user : list) {
            System.out.println(user);
        }

        //java 8 stream 方法引用

        System.out.println("java 8 stream 方法引用");
        list.stream().sorted(Comparator.comparing(StreamUser::getAge)).forEach (StreamUser ->System.out.println(StreamUser));

        IntSummaryStatistics ii = new IntSummaryStatistics();
    }

    /**
     * filter 过滤
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:00
     */
    @Test
    public void testFilter(){
        //输出年龄大于50的人
        System.out.println("------过滤前-----");
        list.forEach(user->System.out.println(user));
        System.out.println("------过滤后-----");
        //Java 8 前
        System.out.println("java 8 前");
        for (StreamUser user : list) {
            System.out.println(user);
        }
        //java 8 stream
        System.out.println("java 8 stream");
        list.stream().filter((streamUser) -> streamUser.getAge()>50).forEach(streamUser ->System.out.println(streamUser));

    }

    /**
     * limit 截断
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:01
     */
    @Test
    public void testLimit(){
        //从第三个开始截断，只输出前三个
        System.out.println("------截断前------");
        list.forEach(StreamUser ->System.out.println(StreamUser));
        System.out.println("------截断后------");
        //java 8 前
        System.out.println("------Java 8 前------");
        for (int i=0;i<3;i++){
            System.out.println(list.get(i));
        }
        System.out.println("------Java 8 stream-----");
        list.stream().limit(3).forEach(StreamUser->System.out.println(StreamUser));

    }

    /**
     * skip 跳过
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:10
     */
    @Test
    public void testSkip(){
        //跳过前三个元素，从第四个开始输出
        System.out.println("----跳过前----");
        list.forEach(streamUser -> System.out.println(streamUser));
        System.out.println("----跳过后----");
        //Java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        //java 8 stream
        System.out.println("java 8 stream");
        list.stream().skip(3).forEach(StreamUser-> System.out.println(StreamUser));
    }




    /**
     * distinct()：使用该方法去重，注意：必须重写对应泛型的hashCode()和equals()方法
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:32
     */
    @Test
    public void testDistinct(){
        //因为Arrays.asList返回的是Arrays的内部类ArrayList，操作remove，add会报错
        ArrayList<StreamUser> users = new ArrayList<>(list);
        //为list去除重复数据
        System.out.println("------去重前------");
        list.forEach(StreamUser-> System.out.println(StreamUser));
        System.out.println("------去重后------");
        //java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < users.size()-1; i++) {
            for (int j = users.size() - 1; j >= 0; j--) {
                if (users.get(j).getAge()==users.get(i).getAge()&&users.get(j).getName().equals(users.get(j).getName())){
                 users.remove(i);
                }
            }

        }
        for (StreamUser user : users) {
            System.out.println(user);
        }
        //java 8 stream
        System.out.println("java 8 stream");
        users.stream().distinct().forEach(user-> System.out.println(user));
    }

    //***根据上述方法，完成去重+按照年龄大于40以后从小到大+只取前二
    @Test
    public void demo(){
        list.stream().distinct().filter(user->user.getAge()>40).sorted(
                Comparator.comparing(StreamUser::getAge)).limit(2).forEach(streamUser -> System.out.println(streamUser));
    }

    /**
     * 测试计算
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:37
     */
    @Test
    public void testNum(){
        IntSummaryStatistics num = list.stream().mapToInt(u->u.getAge()).summaryStatistics();
        System.out.println("总共人数："+num.getCount());
        System.out.println("平均年龄："+num.getAverage());
        System.out.println("最大年龄："+num.getMax());
        System.out.println("最小年龄："+num.getMin());
        System.out.println("年龄之和："+num.getMin());
    }

    /**
     * map()：接收一个方法作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * getAge()).collect(toList());
     *     ages.forEach(age -> System.out.println(age));
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:38
     */
    @Test
    public void testMap(){
        //只输出所有人的年龄
        list.stream().forEach(streamUser -> System.out.println(streamUser));
        System.out.println("映射后-----》");
        List<Integer> ages = list.stream().map(streamUser -> streamUser.getAge()).collect(Collectors.toList());
        ages.forEach(age-> System.out.println(age));

        //小写转大写
        List<String> words = Arrays.asList("aaa","bbb","ccc");
        System.out.println("全部大写----》");
        List<String> collet = words.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        collet.forEach(s -> System.out.println(s));
    }

    /**
     * flatMap()：对每个元素执行mapper指定的操作，
     * 并用所有mapper返回的Stream中的元素组成一个新的Stream作为最终返回结果，
     * 通俗易懂就是将原来的stream中的所有元素都展开组成一个新的stream
     *
     *
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:51
     */
    @Test
    public void testFlatMap(){
        //创建一个 装有两个泛型为integer的集合
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5));
        Stream<Integer> integerStream = stream.flatMap(
        (Function<List<Integer>,Stream<Integer>>) integers->integers.stream());
        //为新的集合
        List<Integer> collet = integerStream.collect(Collectors.toList());
        System.out.println("新stream大小："+collet.size());
        System.out.println("-----合并后----");
        collet.forEach(o-> System.out.println(o));

    }


    /**
     * 10、findFirst() ：使用该方法获取第一个元素
     * @param:
     * @return: void
     * @author: jason
     * @date: 2019-08-21 22:59
     */
    @Test
    public void testStream(){
       StreamUser user = list.stream().findFirst().get();
        System.out.println(user);

    }
}
