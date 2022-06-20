package appa;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

/**
 * @author 86150
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Repeatable(Authors.class)
public @interface Author {
    String name();
}
