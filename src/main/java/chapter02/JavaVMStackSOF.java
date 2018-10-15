package chapter02;

/**
 * 项目名称：jvm
 * 包： chapter02
 * 类名称：JavaVMStackSOF.java
 * 类描述：测试栈溢出
 * 创建人：wufuming
 * 创建时间：2018年10月15日
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] arges) throws Throwable {
        /**
         * 本类用于测试栈溢出，JVM启动参数设置如下：
         * VM Args:-Xss128k
         * 参数说明：
         * -Xss:设置栈的大小为128k
         */
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable t) {
            System.out.println("栈的深度:" + sof.stackLength);
            throw t;
        }
    }

}