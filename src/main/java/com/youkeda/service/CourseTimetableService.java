package com.youkeda.service;

import com.youkeda.model.*;
import java.time.LocalDateTime;
import java.util.List;


public interface CourseTimetableService {

    void invoke(CourseTimetable courseTimetable, LocalDateTime startDay, LocalDateTime endDay,
            List<WeekPlan> weekPlans);

    CourseTimetable queryForClasses(String classesId);

}