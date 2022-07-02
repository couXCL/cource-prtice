package com.xxx.course.service.impl;

import com.xxx.course.dao.CourseMapper;
import com.xxx.course.entity.Course;
import com.xxx.course.service.CourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseListServiceImpl implements CourseListService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> getCourseList() {
        return courseMapper.findValidCourse();
    }
}
