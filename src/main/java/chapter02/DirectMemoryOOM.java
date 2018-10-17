package chapter02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 项目名称：jvm
 * 包： chapter02
 * 类名称：DirectMemoryOOM.java
 * 类描述：测试-本机内存溢出
 * 创建人：wufuming
 * 创建时间：2018年10月17日
 */
public class DirectMemoryOOM {
    /**
     * 该类用来测试本机直接内存OOM,利用unsafe类的方法绕过JVM内存，直接在堆外分配内存。
     * 设置JVM参数如下或者不设置参数也会OOM：
     * VM Args:-Xmx20m -XX:MaxDirectMemorySize=20m
     * 参数说明:
     * -XX:MaxDirectMemorySize=20:设置直接内存大小为20m。
     */
    private static final int _1MB = 1024 * 1024;//1MB内存

    public static void main(String[] arges) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            //该方法会在堆外分配内存,不受JVM内存管理。必须显示的调用unsafe.freeMemory()方法才会释放内存。
            unsafe.allocateMemory(_1MB);
            //unsafe.freeMemory();
        }
    }
}