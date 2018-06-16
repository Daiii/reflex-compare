package util;

import compare.ImComparator;

import java.util.Comparator;

/**
 * 排序工具类
 *
 * @author zhangbo
 * @date 2018/6/16
 */
public class CompareUtil {

    /**
     * 通用排序
     *
     * @param sort  排序类型 1正序 2倒序
     * @param filed 字段
     * @param <t>   对象
     * @return 排序结果
     */
    public static <t> Comparator createComparator(int sort, String... filed) {
        return new ImComparator(sort, filed);
    }
}
