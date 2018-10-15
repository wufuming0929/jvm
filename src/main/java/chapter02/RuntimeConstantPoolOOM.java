package chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：jvm
 * 包： chapter02
 * 类名称：RuntimeConstantPoolOOM.java
 * 类描述：测试运行时常量池OOM
 * 创建人：wufuming
 * 创建时间：2018年10月16日
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] arges) {
        /**
         *本类测试运行时常量池OOM，设置参数如下：
         * VM Args:-Xms20m -Xmx20m
         * 经过测试：
         * 1）直接运行报错误java.lang.OutOfMemoryError: GC overhead limit exceeded
         * 2）如果每添加一次睡1ms，则会报java.lang.OutOfMemoryError: Java heap space
         * 经过查看visualVM,表明1.8的运行时常量池在堆中。
         */
        List<String> list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }

}