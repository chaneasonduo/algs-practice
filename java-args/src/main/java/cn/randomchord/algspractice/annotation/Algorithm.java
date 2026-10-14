package cn.randomchord.algspractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 限定该注解只能用于类、接口、枚举等类型上
public @interface Algorithm {
}
