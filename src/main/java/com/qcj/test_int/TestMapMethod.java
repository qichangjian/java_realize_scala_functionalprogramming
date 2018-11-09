package com.qcj.test_int;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试 listUp中的map方法
 */
public class TestMapMethod {
    public static void main(String[] args) {
        //构造数据
        Integer[] numbers = {3,1,5,7,9};
        List<Integer> ints = Arrays.asList(numbers);

        //包装list方法，让其实现map方法
        ListUp listUp = new ListUp(ints);

        //使用接口实现类
        //最大值实现
        MapFunction max_mapFunction = new MapFunction() {
            @Override
            public Integer mathMethod(List<Integer> mathInt) {
                Integer max = Collections.max(mathInt);
                return max;
            }
        };
        //最小值实现
        MapFunction min_mapFunction = new MapFunction() {
            @Override
            public Integer mathMethod(List<Integer> mathInt) {
                Integer min = Collections.min(mathInt);
                return min;
            }
        };
        //平均值实现
        MapFunction avg_mapFunction = new MapFunction() {
            @Override
            public Integer mathMethod(List<Integer> mathInt) {
                Integer num=0;
                for (Integer number:mathInt) {
                    num += number;
                }
                Integer avg = num/mathInt.size();
                return avg;
            }
        };
        //list数量实现
        MapFunction count_mapFunction = new MapFunction() {
            @Override
            public Integer mathMethod(List<Integer> mathInt) {
                return mathInt.size();
            }
        };
        //总值实现
        MapFunction num_mapFunction = new MapFunction() {
            @Override
            public Integer mathMethod(List<Integer> mathInt) {
                Integer num = 0;
                for (Integer number:mathInt) {
                    num += number;
                }
                return num;
            }
        };
        int resultNum_max = listUp.map(max_mapFunction);
        int resultNum_min = listUp.map(min_mapFunction);
        int resultNum_avg = listUp.map(avg_mapFunction);
        int resultNum_count = listUp.map(count_mapFunction);
        int resultNum_num = listUp.map(num_mapFunction);
        System.out.println(resultNum_max + ":" + resultNum_min + ":" + resultNum_avg+ ":" + resultNum_count+ ":" + resultNum_num);
    }
}
