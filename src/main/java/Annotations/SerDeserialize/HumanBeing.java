package Annotations.SerDeserialize;

import java.io.Serializable;

/**
 * Created by Ыг on 18.01.2016.
 * Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
 отмечены аннотацией @Save.
 */

public class HumanBeing implements Serializable {
    private static final long SERIAL_VERSION_UID = 11L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Save
    private String name;
    @Save
    private int age;

    private  boolean sexNonAnnotated;

    private transient long virtuesNonAnnotated;

    public HumanBeing(String n, int a, boolean s, long virtuesNonAnnotated){
        this.name = n;
        this.age = a;
        this.sexNonAnnotated = s;
        this.virtuesNonAnnotated = virtuesNonAnnotated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HumanBeing that = (HumanBeing) o;

        if (age != that.age) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "HumanBeing{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sexNonAnnotated+
                '}';
    }
}
