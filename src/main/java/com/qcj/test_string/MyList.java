package com.qcj.test_string;

import java.util.Arrays;
import java.util.List;

/**
 * 简单的案例:
 *      java 的scala函数式编程
 * 需求：
 *      将字符串转指定大小写。比如将Scala转换成SCALA或者scala。
 * 实现流程：
 *      将字符串添加到字符数组中，利用装饰模式，加强list，
 *      调用接口的转换方法，最终的转换规则由自己指定。
 * 优点：
 *      硬编码较少
 */
public class MyList {
    public static void main(String[] args) {
        //构造测试数据
        String[] words = {"Hdfs","MapReduce","Spark"};
        List<String> list = Arrays.asList(words);

        //包装list方法，让其实现map方法
        ListUp listUp = new ListUp(list);

        //调用map传入方法参数的方法
        /**
         * 这里比较灵活，
         * 方法一：使用接口的实现类
         * 方法二：使用匿名类
         * 方法三：使用lambda表达式
         */
        //方法一：使用接口的实现类
        MapFunction function = new MapFunction() {
            @Override
            public String transformCase(String string) {
                return string.toLowerCase();
            }
        };
        List<String> mapList = listUp.map(function);
        System.out.println(mapList.toString());

        //方法二：使用匿名类
        List<String> mapList2 = listUp.map(new MapFunction() {
            @Override
            public String transformCase(String string) {
                return string.toUpperCase();
            }
        });
        System.out.println(mapList2.toString());

        //方法三：使用lambda表达式
        List<String> mapList3 = listUp.map(string -> string.toUpperCase());
        System.out.println(mapList3.toString());

        //调用map2方法可以实现连续调用
        ListUp mapList4 = listUp.map2(string -> string.toUpperCase()).map2(string -> string.toLowerCase());
        System.out.println(mapList4.getList().toString());
    }
}
