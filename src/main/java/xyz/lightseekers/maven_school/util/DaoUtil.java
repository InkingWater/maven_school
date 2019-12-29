package xyz.lightseekers.maven_school.util;

/**
 * @Author: ZhiliangJia
 * @Description:
 * @Date:Create in 10:12 2019/12/28
 * @Modified User:
 */
public class DaoUtil {
    public final static int INSERT = 0;
    public final static int UPDATE = 1;
    public final static int DELETE = 2;


    public static String messageString(int i, int t) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (t) {
            case INSERT:
                stringBuilder.append("插入了");
                break;
            case UPDATE:
                stringBuilder.append("更新了");
                break;
            case DELETE:
                stringBuilder.append("删除了");
                break;
        }
        stringBuilder.append(i);
        stringBuilder.append("条数据");
        return stringBuilder.toString();
    }

}
