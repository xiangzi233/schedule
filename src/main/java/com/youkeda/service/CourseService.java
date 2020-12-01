package com.youkeda.service;

import com.youkeda.model.*;


public interface CourseService {

    void add(Course course);

    Course get(String courseId);

}