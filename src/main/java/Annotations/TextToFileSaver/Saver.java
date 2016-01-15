package Annotations.TextToFileSaver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Ыг on 15.01.2016.
 * 2. Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
 1) в какой файл должен сохраниться текст 2) метод, который выполнит сохранение. Написать класс Saver,
 который сохранит поле класса TextContainer в указанный файл.
 @SaveTo(path=“c:\\file.txt”)
 class Container {
 String text = “…”;
 @Saver
 public void save(..) {…}
 }
 */
@SaverAnnotation
public class Saver {

    public void save() {

        TextContainer txtCont = new TextContainer("text to save again ");

        String withdrawedFromAnnotationPath = TextContainer.class.getAnnotation(SaveTo.class).path();
        String veryTextToSave = getStringFieldTosave(txtCont);


        FileOutputStream fos = null;
        File withdrawed=null;

        try {
            withdrawed = new File(withdrawedFromAnnotationPath);
            fos = new FileOutputStream(withdrawed);


            if (!withdrawed.exists()) {
                withdrawed.createNewFile();
            }

            byte[] contentAsBytes = veryTextToSave.getBytes();

            fos.write(contentAsBytes);
            fos.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if(fos!=null){
               try {
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

    }

    static String getStringFieldTosave(TextContainer txtCon){
        Class<?> cls = TextContainer.class;
        Field[] flds = cls.getDeclaredFields();
        String res = "";



        for(Field fl : flds){
            try {
                int mod = fl.getModifiers();
                if(Modifier.isPrivate(mod)){
                    fl.setAccessible(true);
                }
                res = (String) fl.get(txtCon);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return res;
    }



    public static void main(String[] args) {

        Saver saverObj = new Saver();
        saverObj.save();

    }

}
