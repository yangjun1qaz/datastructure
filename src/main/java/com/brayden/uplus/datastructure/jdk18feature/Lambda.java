package com.brayden.uplus.datastructure.jdk18feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (parameters)->expression
 * <p>
 * (paramsters)->{statements;}
 * <p>
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/6/9
 */
public class Lambda {


    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};

        List<String> players = Arrays.asList(atp);

        ArrayList<Student> test = new ArrayList<>();


        // 使用 lambda表达式进行for循环
        players.forEach((player) -> {
            Student student = new Student();
            student.setUsername(player);
            test.add(student);
        });

        test.forEach((t -> {
            System.out.println(t);
        }));

// 在 Java 8 中使用双冒号操作符(double colon operator)
        //players.forEach(System.out::println);

        //使用lambda表达式开启线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"----execute");
        }).start();

    }
}


class Student {
    public String username;
    public Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}