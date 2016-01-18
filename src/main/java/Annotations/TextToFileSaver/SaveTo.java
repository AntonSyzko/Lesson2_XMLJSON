package Annotations.TextToFileSaver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ыг on 15.01.2016.
 * 2. Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
 1) в какой файл должен сохраниться текст
 2) метод, который выполнит сохранение.
 Написать класс Saver,
 который сохранит поле класса TextContainer в указанный файл.
 @SaveTo(path=“c:\\file.txt”)
 class Container {
 String text = “…”;
 @Saver
 public void save(..) {…}
 }
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveTo {
   String path();
}