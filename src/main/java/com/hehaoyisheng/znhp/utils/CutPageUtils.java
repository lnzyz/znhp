package com.hehaoyisheng.znhp.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yunzhao on 2017/8/5.
 */
public class CutPageUtils {
    //判断分页数据是否正确
    public static int getInteger(Integer integer){
        return integer == null ? 0 : integer;
    }

    public static int getCount(Integer integer){
        return integer == null ? 0 : 20;
    }

    /**
     * 切割List
     * @param list
     * @param from
     * @param count
     * @param <T>
     * @return
     */
    public static <T> List<T> divide(List<T> list, int from, int count){
        List<T> result = Lists.newArrayList();
        if(from > list.size()){
            return result;
        }
        int end = from + count;
        end = end > list.size() ? list.size() : end;
        for(int i = from; i < end; i++){
            result.add(list.get(i));
        }
       return result;
    }
}
