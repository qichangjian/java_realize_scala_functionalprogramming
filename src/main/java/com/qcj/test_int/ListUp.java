package com.qcj.test_int;

import java.util.ArrayList;
import java.util.List;

/**
 * 加强装饰原来list的方法
 * 实现新增的 参数为方法的 map方法
 */
public class ListUp {
    private List<Integer> list;

    public ListUp(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Integer map(MapFunction mapFunction){
        //接口中的mathMethod方法没有实际实现，需要自定义
        Integer result = mapFunction.mathMethod(list);
        return result;
    }

    public Integer reduce(ReduceFunction reduceFunction){
        Integer reduceResult = reduceFunction.mathMethod(list);
        return reduceResult;
    }
}
