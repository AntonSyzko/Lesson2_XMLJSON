package Annotations;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ыг on 14.01.2016.
 * Создать аннотацию, которая принимает параметры для метода.
 * Написать код, который вызовет метод,
 помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
 GIT - JAVA_PRO_Lesson1_Task1
 */
public class HomeTask1 {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface HomeTest1{
        int param1();
        int param2();

    }

    static class Holder{

        @HomeTest1(param1 = 1,param2 = 2)
        public int myAnnotatedMethod(int a, int b){
            int res = a+b;

             return res;
        }
    }


    public static void main(String[] args) {

        Class<?> cls = Holder.class;
        Method[] mts = cls.getDeclaredMethods();
        // instnce of my class to pass to invoke method
        Holder holder = new Holder();

        for(Method mt : mts){
           // HomeTest1 hm = cls.getAnnotation(HomeTest1.class);
            HomeTest1 hm = mt.getAnnotation(HomeTest1.class);
            if(mt.isAnnotationPresent(HomeTest1.class)){

                System.out.println(" Method " + mt.getName() + " of the  class " + cls.getSimpleName() + "  holds the values " + hm.param1() + " and  " + hm.param2());
                try {
                   Integer res = (Integer) mt.invoke(holder,hm.param1(),hm.param2());
                    System.out.println(" the result of the method " + mt.getName()+ " with passed parameters   " + hm.param1() + " and " + hm.param2() + " is " +res);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
