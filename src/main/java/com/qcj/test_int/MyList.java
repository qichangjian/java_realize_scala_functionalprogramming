package com.qcj.test_int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *   测试map，reduce方法
 *
 *  模拟使用类似于scala函数式编程
 *  模拟mapreduce中的map和reduce方法：
 *  一堆数字经过map后，再经过reduce得到最终的结果
 */
public class MyList {
    public static void main(String[] args) {
        //构造数据
        Integer[] numbers1 = {3,1,5,7,9};
        Integer[] numbers2 = {1,5,9};
        Integer[] numbers3 = {3,5,7};
        Integer[] numbers4 = {3,1,5,7,20};
        List<Integer> maps = maps(Arrays.asList(numbers1), Arrays.asList(numbers2), Arrays.asList(numbers3), Arrays.asList(numbers4));
        ListUp listUps = new ListUp(maps);
        ReduceFunction reduceFunction = new ReduceFunction() {
            @Override
            public Integer mathMethod(List<Integer> mathInt) {
                Integer result = Collections.max(mathInt);
                return result;
            }
        };
        Integer reduce = listUps.reduce(reduceFunction);
        System.out.println("Reduce-Max:"+reduce);
    }

    /**
     * 传入多个list返回一个经过map后的list
     */
    public static List<Integer> maps(List<Integer> ... lists){
        List<Integer> result = new ArrayList<Integer>();
        for (List<Integer> ints:lists) {
            //包装list方法，让其实现map方法
            ListUp listUp = new ListUp(ints);
            //最大值实现
            MapFunction max_mapFunction = new MapFunction() {
                @Override
                public Integer mathMethod(List<Integer> mathInt) {
                    Integer max = Collections.max(mathInt);
                    return max;
                }
            };
            Integer resultNum_max = listUp.map(max_mapFunction);
            System.out.println(resultNum_max);
            result.add(resultNum_max);
        }
        return result;
    }


}
