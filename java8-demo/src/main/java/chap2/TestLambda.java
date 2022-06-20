/**
 * xingbili
 */

package chap2;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: xinghuolin
 * @create: 2022/5/2 14:52
 */
public class TestLambda {


    public static void process(Runnable r) {
        r.run();
    }

    public static Callable<String> process(Callable<String> c) {
        return c;
    }
    

    public static void main(String[] args) {
       process(()-> System.out.println("hello"));
       process(()-> { });

    }
}
