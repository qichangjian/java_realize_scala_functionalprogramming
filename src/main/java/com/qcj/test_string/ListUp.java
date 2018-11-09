package com.qcj.test_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 加强装饰原来list的方法
 * 实现新增的 参数为方法的 map方法
 */
public class ListUp {
    private List<String> list;

    public ListUp(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    /**
     * 实现 模拟 参数为方法的 map方法
     * @param mapFunction  map参数要传入的方法的接口。
     * @return 返回的
     */
    public List<String> map(MapFunction mapFunction){
        ArrayList<String> newList = new ArrayList<String>();
        for (String word:list) {
            //接口中的transformCase方法没有实际实现，需要自定义
            String string = mapFunction.transformCase(word);
            newList.add(string);
        }
        return newList;
    }

    /**
     * 实现 模拟 参数为方法的 map方法
     * @param mapFunction  map参数要传入的方法的接口。
     * @return 返回的还是新定义的ListUp
     */
    public ListUp map2(MapFunction mapFunction){
        ArrayList<String> newList = new ArrayList<String>();
        for (String word:list) {
            //接口中的transformCase方法没有实际实现，需要自定义
            String string = mapFunction.transformCase(word);
            newList.add(string);
        }
        this.setList(newList);
        return this;
    }

}
