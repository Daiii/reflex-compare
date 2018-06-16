package compare;

import com.sun.tools.internal.jxc.ap.Const;
import constant.Constants;
import util.ReflexUtil;

import java.util.Comparator;
import java.util.Date;

/**
 * 排序器
 *
 * @author zhangbo
 * @date 2018/6/16
 */
public class ImComparator implements Comparator {

    /**
     * 排序类型 1正序 -1倒序
     */
    private int sort;

    /**
     * 字段名
     */
    private String[] filed;

    /**
     * 比较器
     *
     * @param o1 value1
     * @param o2 value2
     * @return 结果
     */
    public int compare(Object o1, Object o2) {
        int result = 0;
        for (String file : filed) {
            Object value1 = ReflexUtil.invokeMethod(file, o1);
            Object value2 = ReflexUtil.invokeMethod(file, o2);
            if (value1 == null || value2 == null)
                continue;

            if (value1 instanceof Integer) {
                int v1 = Integer.valueOf(value1.toString());
                int v2 = Integer.valueOf(value2.toString());

                if (v1 == v2)
                    continue;

                if (sort == Constants.ASC)
                    return v1 - v2;
                else if (sort == Constants.DESC)
                    return v2 - v1;

            } else if (value1 instanceof Date) {
                Date d1 = (Date) value1;
                Date d2 = (Date) value2;

                if (d1.compareTo(d2) == 0)
                    continue;

                if (sort == Constants.ASC)
                    return d1.compareTo(d2);
                else if (sort == Constants.DESC)
                    return d2.compareTo(d1);

            } else if (value1 instanceof Long) {
                long v1 = Long.valueOf(value1.toString());
                long v2 = Long.valueOf(value2.toString());

                if (v1 == v2)
                    continue;

                if (sort == Constants.ASC)
                    return v1 > v2 ? 1 : -1;
                else if (sort == Constants.DESC)
                    return v2 > v1 ? 1 : -1;

            } else if (value1 instanceof Double) {
                double v1 = Double.valueOf(value1.toString());
                double v2 = Double.valueOf(value2.toString());

                if (v1 == v2)
                    continue;

                if (sort == Constants.ASC)
                    return v1 > v2 ? 1 : -1;
                else if (sort == Constants.DESC)
                    return v2 > v1 ? 1 : -1;
            } else if (value1 instanceof String) {
                String v1 = value1.toString();
                String v2 = value2.toString();

                result = v1.compareTo(v2);
                if (result == 0)
                    continue;

                if (sort == Constants.ASC)
                    return result > 0 ? 1 : -1;
                else if (sort == Constants.DESC)
                    return result < 0 ? 1 : -1;
            }
        }
        return result;
    }

    /**
     * 构造函数
     *
     * @param sort  排序规则 1正序 -1倒序
     * @param filed 字段名
     */
    public ImComparator(int sort, String... filed) {
        this.sort = sort;
        this.filed = filed;
    }
}
