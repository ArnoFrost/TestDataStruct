package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/20 19:52
 * @Version 1.0
 */
public class ReflectTest {
    public static void main(String[] args) {
        Person person = new Person("arno", 25);
//        Class clazz = person.getClass();
        Class<Person> clazz = Person.class;
        try {
            Field filed = clazz.getDeclaredField("age");
            filed.setAccessible(true);
            filed.setInt(person, 23);
            System.out.println(filed.get(person));

            Method method = clazz.getDeclaredMethod("testInnerMethod", int.class);
            method.setAccessible(true);
            method.invoke(person, 123);

            Method testMethod = clazz.getDeclaredMethod("testMethod", long.class);
            testMethod.setAccessible(true);
            testMethod.invoke(person, 1234L);

            Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            Person person1 = constructor.newInstance("Hello", 123);
            person1.testInnerMethod();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void testInnerMethod(int age) {
            System.out.println("innerMethod age = " + age);
        }

        public void testInnerMethod() {
            System.out.println("innerMethod");
        }

        public void testMethod(long number) {
            System.out.println("Test Method number = " + number);
        }
    }
}
