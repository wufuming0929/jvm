package chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：jvm
 * 包： chapter02
 * 类名称：HeapOOM.java
 * 类描述：堆内存溢出测试
 * 创建人：wufuming
 * 创建时间：2018年10月14日
 */
@SuppressWarnings("all")
public class HeapOOM {

    static class OOMObject{

    }
    public static void main(String[] arges) {
        /**
         * 本类是测试java堆内存溢出的例子，设置启动参数如下：
         * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
         * 参数说明：
         * 1）-Xms20m:设置堆最小内存为20m。
         * 2）-Xmx20m:设置堆最大内存为20m。
         * 3）-XX:+HeapDumpOnOutOfMemoryError:堆溢出时进行堆转储快照
         */
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true){
            list.add(new OOMObject());
        }
    }

}