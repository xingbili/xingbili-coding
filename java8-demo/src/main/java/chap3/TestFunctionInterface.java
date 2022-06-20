/**
 * xingbili
 */

package chap3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: xinghuolin
 * @create: 2022/5/3 10:53
 */
public class TestFunctionInterface {

    /*
     * 读取文件路劲的方式 不推荐
     * 1、直接读取路径  File file = new File("data.txt");
     * 2、使用ClassLoader.getSystemResource()方法;
     * 3、使用ClassLoader.getSystemResourceAsStream()方法;
     **/
    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) throws IOException {
//        process(() -> System.out.println("Hello"));
//        processFile();
//        readFile();

        testMyFunctionInterface(()->System.out.println("Hello"));
    }

    public static String processFile() throws IOException {
        String file = ClassLoader.getSystemResource("data.txt").getPath();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        return file;
    }

    public static void readFile() throws IOException {
        File file = new File("data2.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void testMyFunctionInterface(MyFunctionalInterface myFunctionInterface) {
        myFunctionInterface.method();
    }



}

@FunctionalInterface
interface MyFunctionalInterface {
    void method();
}


