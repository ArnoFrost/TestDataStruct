package annotation.notnull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义属性非空校验注解
 *
 * @Author: wwh
 * @Date: 2019/1/16 15:19:10
 */
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

    /**
     * 获取参数名
     *
     * @return
     */
    String fileName();
}
