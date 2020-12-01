package com.youkeda.test;

import java.time.LocalDateTime;
import java.util.*;

import com.youkeda.model.*;

import com.youkeda.service.*;
import com.youkeda.service.impl.*;

/**
 * PageTest
 */
public class CourseTimetableTest {

    private static CourseService courseService = new CourseServiceImpl();
    private static ClassesService classesService = new ClassesServiceImpl();
    private static CourseTimetableService courseTimetableService = new CourseTimetableServiceImpl();

    public static void main(String[] args) {

        initCourse();
        initClasses();

        LocalDateTime startDay = LocalDateTime.of(2019, 9, 1, 8, 0, 0);
        LocalDateTime endDay = LocalDateTime.of(2020, 1, 15, 18, 0, 0);

        invokeCourse1(startDay, endDay);

        CourseTimetable courseTimetable = courseTimetableService.queryForClasses("c_100");

        System.out.println(courseTimetable.getClasses().getName());
        System.out.println(courseTimetable.getCourse().getName());
        System.out.println("第四次课程是:" + courseTimetable.getTimetables().get(3).getStartTime());

        int last = courseTimetable.getTimetables().size() - 1;

        System.out.println("最后一次课程是:" + courseTimetable.getTimetables().get(last).getStartTime());

    }

    private static void invokeCourse1(LocalDateTime startDay, LocalDateTime endDay) {

        CourseTimetable courseTimetable = new CourseTimetable();

        Course course = courseService.get("s_100");
        courseTimetable.setCourse(course);

        Classes classes = classesService.get("c_100");
        courseTimetable.setClasses(classes);
        courseTimetable.setTeacher("张王");

        List<WeekPlan> weekPlans = new ArrayList<>();
        WeekPlan weekPlan = new WeekPlan();
        weekPlan.setWeekDay(2);
        weekPlan.setCount(2);
        weekPlan.setTime("am");
        weekPlans.add(weekPlan);

        weekPlan = new WeekPlan();
        weekPlan.setWeekDay(4);
        weekPlan.setCount(2);
        weekPlan.setTime("pm");
        weekPlans.add(weekPlan);

        courseTimetableService.invoke(courseTimetable, startDay, endDay, weekPlans);
    }

    private static void initCourse() {
        Course course = new Course();
        course.setId("s_100");
        course.setName("高等数学");
        course.setSections(48);
        courseService.add(course);

        course = new Course();
        course.setId("s_101");
        course.setName("C语言");
        course.setSections(50);
        courseService.add(course);

        course = new Course();
        course.setId("s_102");
        course.setName("编译原理");
        course.setSections(20);
        courseService.add(course);

        course = new Course();
        course.setId("s_103");
        course.setName("Java 语言");
        course.setSections(56);
        courseService.add(course);
    }

    private static void initClasses() {
        Classes classes = new Classes();
        classes.setId("c_100");
        classes.setName("计算机1班");
        classes.setStartYear(2018);
        classesService.add(classes);

        classes = new Classes();
        classes.setId("c_200");
        classes.setName("计算机2班");
        classes.setStartYear(2019);
        classesService.add(classes);
    }

}