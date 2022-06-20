/**
 * xingbili
 */

package appa;

import java.util.Arrays;

/**
 * @description:
 * @author: xinghuolin
 * @create: 2022/4/30 23:50
 */
@Author(name = "xingbili")
@Author(name = "xingbili")
public class Book {
    public static void main(String[] args) {
        Author[] authors = Book.class.getAnnotationsByType(Author.class);
        Arrays.asList(authors).stream().forEach(a -> {
            System.out.println(a.name());
        });
    }
}
