package com.youkeda.service.impl;

import java.util.*;
import java.time.*;

import com.youkeda.model.*;
import com.youkeda.service.*;

public class CourseTimetableServiceImpl implements CourseTimetableService {

    private static List<CourseTimetable> COURSE_TimetableS = new ArrayList<>();

    public void invoke(CourseTimetable courseTimetable, LocalDateTime startDay, LocalDateTime endDay,
            List<WeekPlan> weekPlans) {

        if (courseTimetable.getTimetables() == null) {
            courseTimetable.setTimetables(new ArrayList<>());
        }

        // 根据课时安排课程
        int sections = courseTimetable.getCourse().getSections();

        // 获取学习的总天数
        long days = Duration.between(startDay, endDay).toDays();

        // 循环要上课的天数
        for (int i = 0; i < days; i++) {
            if (sections == 0) {
                break;
            }
            // 使用 plusDays 让日期递增
            LocalDateTime now = startDay.plusDays(i);

            for (WeekPlan weekplan : weekPlans) {
                // 如果当前的星期等于课程安排的星期数，今天要上课
                if (now.getDayOfWeek().getValue() == weekplan.getWeekDay()) {
                    Timetable Timetable = new Timetable();
                    Timetable.setId(UUID.randomUUID().toString());

                    // 默认从8点开始上课
                    LocalDateTime begin = now.withHour(8).withMinute(0);
                    // 如果是下午从13点开始上课
                    if (weekplan.getTime().equals("pm")) {
                        begin = now.withHour(13).withMinute(0);
                    }
                    Timetable.setStartTime(begin);
                    // 每节课耗时一个小时，所以结束时间等于开始时间+几节
                    Timetable.setEndTime(begin.plusHours(weekplan.getCount()));

                    courseTimetable.getTimetables().add(Timetable);
                    sections = sections - weekplan.getCount();
                }

            }
        }

        COURSE_TimetableS.add(courseTimetable);

    }

    public CourseTimetable queryForClasses(String classesId) {

        for (CourseTimetable courseTimetable : COURSE_TimetableS) {
            if (courseTimetable.getClasses().getId().equals(classesId)) {
                return courseTimetable;
            }
        }
        return null;
    }

}