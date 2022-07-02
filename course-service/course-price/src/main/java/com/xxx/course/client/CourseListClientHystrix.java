package com.xxx.course.client;

import com.xxx.course.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 断路器实现类,当远端无法调用时，会默认调用此类中的方法
 */
@Component //标明这是一个组件
public class CourseListClientHystrix implements CourseListClient{//实现之前编写的CourseListClient接口

    @Override
    public List<Course> courseList() {
        //返回一个默认课程给前端
        List<Course> defaultCourses = new ArrayList<>();
        Course course = new Course();
        course.setId(1l);
        course.setCourseId(1l);
        course.setName("默认课程");
        course.setValid(1);
        defaultCourses.add(course);
        return defaultCourses;
    }
}
