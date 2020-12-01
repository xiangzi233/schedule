package com.youkeda;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class YkdTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.test.CourseTimetableTest");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.CourseTimetableTest`类");
            return;
        }

        PrintStream out = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        try {
            Method method = aClass.getMethod("main", String[].class);
            try {
                method.invoke(null, (Object)new String[] {});
            } catch (Exception e) {
                System.setOut(out);
                error("`CourseTimetableTest`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`CourseTimetableTest`类没有创建 main 方法");
            return;
        }

        String result = baos.toString();
        System.setOut(out);

        String[] strings = result.split("\n");

        if (!strings[strings.length-1].contains("2019-11-21")) {
            error("CourseTimetableTest 运行结果不对，请检查题目要求");
        }

    }

}
