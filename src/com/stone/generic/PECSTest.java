package com.stone.generic;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Supplier;

/**
 * PECS是针对T的，这里SOURCE，DEST不影响？
 * 类型	                         示例
 * 引用静态方法	                 ContainingClass::staticMethodName
 * 引用某个对象的实例方法	         containingObject::instanceMethodName
 * 引用某个类型的任意对象的实例方法	 ContainingType::methodName
 * 引用构造方法	                 ClassName::new
 *
 */
public class PECSTest {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceColletions, Supplier<DEST> colltionFactory) {
        DEST result = colltionFactory.get();
        for (T t : sourceColletions) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Person("Stone", LocalDate.of(1978, Month.JULY, 19), Person.Sex.MALE),
                new Person("Cosi", LocalDate.of(2013, Month.JANUARY, 29), Person.Sex.MALE)
        };

        final List<Person> personList = Arrays.asList(persons);

        //使用lambda表达式
        Set<Person> personSet = transferElements(personList, () -> new HashSet<>());
        System.out.println("personSet = " + personSet);

        //使用方法引用
        //引用的是构造方法
        Set<Person> personSet2 = transferElements(personList, HashSet::new);
        System.out.println("personSet2 = " + personSet2);
    }

}
