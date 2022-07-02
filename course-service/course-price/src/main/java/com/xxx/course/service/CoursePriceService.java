package com.xxx.course.service;

import com.xxx.course.model.entity.CoursePrice;
import com.xxx.course.model.entity.CourseAndPrice;

import java.math.BigDecimal;
import java.util.List;

public interface CoursePriceService {
    List<CoursePrice> selectAll();

    BigDecimal getCoursePrice(Long courseId);
    List<CourseAndPrice> getCoursesAndPrice();
}
