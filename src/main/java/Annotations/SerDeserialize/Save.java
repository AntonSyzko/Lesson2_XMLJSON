package Annotations.SerDeserialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ыг on 18.01.2016.
 * Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
 отмечены аннотацией @Save.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Save {

}
