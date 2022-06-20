package appa;

import java.lang.annotation.Retention;

/**
 * @author 86150
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Authors {
    Author[] value();
}
