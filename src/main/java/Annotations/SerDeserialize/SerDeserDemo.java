package Annotations.SerDeserialize;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ыг on 18.01.2016.
 * Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
 отмечены аннотацией @Save.
 *
 */
public class SerDeserDemo {
    public static void main(String[] args) {

     File f = serializeHuman();

        Map res = deserialize(f);
        System.out.println(res.toString());
    }

    public static File serializeHuman() {
        File file = null;

        try {
            Map res = getFields(new HumanBeing("A", 5, true, 5));
            file = null;

            try {
                file = new File("C:\\Users\\Ыг\\Desktop\\JAVA\\Random\\src\\main\\java\\Annotations\\SerDeserialize\\AnnotatedFieldsResult.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(res);
                return file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }//serialize




    public static Map deserialize(File serialized){
        Map result = new HashMap<>();

        try{
            FileInputStream fis = new FileInputStream(serialized);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (Map) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }



    public static Map getFields(HumanBeing hb) throws IllegalAccessException {
        Map res = new HashMap<>();
        Class<?> cls =hb.getClass();

        Field[] fileds = cls.getDeclaredFields();
        for(Field f : fileds){

            if(f.isAnnotationPresent(Save.class)){
                   int mod = f.getModifiers();
                   if(Modifier.isPrivate(mod))
                       f.setAccessible(true);

                      if(f.getType() == String.class){
                          res.put(f.getName(), f.get(hb));

                      }
                    if(f.getType() == int.class){
                        res.put(f.getName(), f.getInt(hb));

                    }



                   }

            }


return res;

    }
}
