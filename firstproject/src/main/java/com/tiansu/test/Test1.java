package com.tiansu.test;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author wanggy
 * @date 2018/6/20
 * @desc 实体类User
 */
public class Test1
{
    User user1 = new User("zhangsan", 11,1000);
    User user2 = new User("lisi", 22,2000);
    User user3 = new User("wangwu", 33,3000);
    List<User> userList = Arrays.asList(user1, user2, user3);

    List<String> stringList = Arrays.asList("abc", "abd", "abcd");

    public List<User> getUserAge(List<User> userList)
    {
        List<User> users = new ArrayList<>();
        for(User user : userList)
        {
            if(user.getAge() < 20)
            {
                users.add(user);
            }
        }
        return users;
    }

    public List<User> getUserSalary(List<User> userList)
    {
        List<User> users = new ArrayList<>();
        for(User user : userList)
        {
            if(user.getSalary() < 3000)
            {
                users.add(user);
            }
        }
        return users;
    }


    public List<User> getUser(List<User> userList, Predicate<User> userPredicate)
    {
        List<User> users = new ArrayList<>();
        for(User user : userList)
        {
            if(userPredicate.test(user))
            {
                users.add(user);
            }
        }
        return users;
    }

    @Test
    public void test1()
    {
        List<User> users = getUser(userList, user -> user.getAge() < 20);
        for (User user : users)
        {
            System.out.println(user);
        }
    }
    
    /**
     * @description 消费型接口示例
     * @author wanggy
     * @date 2018/6/22 15:52
    */
    public void consumer(double money, Consumer<Double> consumer)
    {
        consumer.accept(money);
    }

    @Test
    public void test2()
    {
        consumer(20, aDouble -> System.out.println("消费了" + aDouble + "元"));
    }
    /**
     * @description 供给型接口示例
     * @author wanggy
     * @date 2018/6/22 15:58
    */
    public List<Integer> supply(Integer num, Supplier<Integer> supplier)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++)
        {
            list.add(supplier.get());
        }
        return list;
    }
    @Test
    public void test3()
    {
        List<Integer> list = supply(5, () -> new Random().nextInt(100));
        for (Integer i : list)
        {
            System.out.println(i);
        }
    }

    /**
     * @description 函数式接口示例
     * @author wanggy
     * @date 2018/6/22 16:02
    */
    public String function(String str, Function<String, String> function)
    {
        return function.apply(str);
    }

    @Test
    public void test4()
    {
        System.out.println(function(" HELLO WORLD ", s -> s.trim() + " !"));
    }
    
    /**
     * @description 断言型接口示例
     * @author wanggy
     * @date 2018/6/22 16:10
    */
    public boolean asserts(String str, Predicate<String> predicate)
    {
        return predicate.test(str);
    }

    @Test
    public void test5()
    {
        boolean result = asserts("HELLO", s -> s.length() > 5);
        System.out.println(result);
    }

    /**
     * @description Comparator接口的示例
     * @author wanggy
     * @date 2018/6/22 17:13
    */
    public Integer compare(List<String> stringList, Comparator<String> comparator)
    {
        return comparator.compare(stringList.get(0), stringList.get(1));
    }

    @Test
    public void test6()
    {
        Integer i = compare(stringList, (x, y) -> x.compareTo(y));
        System.out.println(i);
    }
}
