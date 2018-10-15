package chapter02;

/**
 * 项目名称：jvm
 * 包： chapter02
 * 类名称：JavaVMStackOOM.java
 * 类描述：测试-创建大量线程至OOM
 * 创建人：wufuming
 * 创建时间：2018年10月15日
 */
public class JavaVMStackOOM {
    /**
     * 本类是测试创建大量线程导致OOM。经实测，运行这个代码会导致电脑死机！
     */
    public void dontStop(){
        while (true){
        }
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] arges) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}