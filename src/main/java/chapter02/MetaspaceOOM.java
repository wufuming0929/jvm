package chapter02;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 项目名称：jvm
 * 包： chapter02
 * 类名称：MetaspaceOOM.java
 * 类描述：测试-元空间OOM
 * 创建人：wufuming
 * 创建时间：2018年10月16日
 */
public class MetaspaceOOM {

    public static void main(String[] arges) {
        /**
         *本类测试元空间OOM，设置JVM参数如下:
         * VM args:-XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=20m
         *参数说明：
         * -XX:MetaspaceSize=20m:设置元空间初始大小为20m
         * -XX:MaxMetaspaceSize=20m:设置元空间最大内存为20m
         */
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{
    }
}