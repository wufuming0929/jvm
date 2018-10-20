package chapter03;

/**
 * 项目名称：jvm
 * 包： chapter03
 * 类名称：AllocateObject.java
 * 类描述：测试-对象的内存分配
 * 创建人：wufuming
 * 创建时间：2018年10月20日
 */
public class AllocateObject {

    private static final int _1MB=1024*1024;

    public static void main(String[] arges) {
        /**
         * 本类测试新分配对象到Eden区，当Eden区内存不够时发生Minor GC,
         * 并且在GC完成后，Survivor区存不下存活的对象而发生分配担保机制，
         * 直接把GC后存活的对象分配到老年代。测试JVM参数如下：
         * VM ARGS:-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
         *参数说明：
         * 1）-verbose:gc：打印GC日志
         * 2）-Xmn10m：新生代分配10mn内存
         * 3）-XX:+PrintGCDetails：打印GC日志
         * 4）-XX:SurvivorRatio=8:设置Eden区与Survivor的内存大小比例为8:1
         */
        byte[] allocate1,allocate2,allocate3,allocate4;

        allocate1 = new byte[2 * _1MB];
        allocate2 = new byte[2 * _1MB];
        allocate3 = new byte[2 * _1MB];

        allocate4 = new byte[4 * _1MB];//发生Minor GC
    }
}