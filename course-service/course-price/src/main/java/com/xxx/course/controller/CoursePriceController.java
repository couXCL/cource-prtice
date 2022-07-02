package com.xxx.course.controller;

import com.xxx.course.client.CourseListClient;
import com.xxx.course.entity.Course;
import com.xxx.course.model.entity.CoursePrice;
import com.xxx.course.model.entity.CourseAndPrice;
import com.xxx.course.service.CoursePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CoursePriceController {
    @Autowired
    private CoursePriceService coursePriceService;
    @Autowired
    private CourseListClient courseListClient;

    //调用编写的feign客户端接口来调用远程的方法
    @GetMapping("/coursesInPrice")
    public List<Course> coursesInPrice(){
        return courseListClient.courseList();
    }
    @GetMapping("/coursesAndPrice")
    public List<CourseAndPrice> getCoursesAndPrice(){
        return coursePriceService.getCoursesAndPrice();
    }

    @GetMapping("/courseprice")
    public List<CoursePrice> selectAll(){
        return coursePriceService.selectAll();
    }

    @GetMapping("/price")
    public BigDecimal getCoursePrice(Long courseId){
        return coursePriceService.getCoursePrice(courseId);
    }


}
