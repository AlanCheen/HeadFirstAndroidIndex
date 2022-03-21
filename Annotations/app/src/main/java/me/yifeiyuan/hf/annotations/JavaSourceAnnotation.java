package me.yifeiyuan.hf.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 程序亦非猿 on 2022/3/21.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface JavaSourceAnnotation {

    String stringValue() default "JavaSourceAnnotation";

    int intValue() default -2;
}
