package com.xxx.course.controller;

import com.xxx.course.entity.Course;
import com.xxx.course.service.CourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 课程列表controller
 */
@RestController
public class CourseListController {
    @Autowired
    private CourseListService courseListService;

    @GetMapping("/courses")
    public List<Course> courseList(){
        return courseListService.getCourseList();
    }
}
