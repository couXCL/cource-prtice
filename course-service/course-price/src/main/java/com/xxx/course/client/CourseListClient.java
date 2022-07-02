package com.xxx.course.client;

import com.xxx.course.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 课程列表的Feign客户端
 */
//value指明是哪个项目中的，fallback指发生断路时调用哪个类，默认是调用远端的方法的，远端的方法没法调用时调用fallback指定的类
@FeignClient(value = "course-list",fallback = CourseListClientHystrix.class)
@Primary
public interface CourseListClient {
    @GetMapping("/courses")
    List<Course> courseList();
}
