package com.youkeda.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.youkeda.model.*;
import com.youkeda.service.*;

/**
 * CourseServiceImpl
 */
public class CourseServiceImpl implements CourseService {
    private static List<Course> COURSES = new ArrayList<>();

    public void add(Course course) {

        COURSES.add(course);

    }

    public Course get(String courseId) {

        for (Course course : COURSES) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;

    }

}