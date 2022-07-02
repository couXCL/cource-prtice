package com.xxx.course.service.impl;

import com.xxx.course.client.CourseListClient;
import com.xxx.course.entity.Course;
import com.xxx.course.model.dao.CoursePriceMapper;
import com.xxx.course.model.entity.CoursePrice;
import com.xxx.course.model.entity.CourseAndPrice;
import com.xxx.course.service.CoursePriceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoursePriceServiceImpl implements CoursePriceService {
    @Autowired
    private CoursePriceMapper coursePriceMapper;
    @Override
    public List<CoursePrice> selectAll() {
        return coursePriceMapper.selectAll();
    }

    @Override
    public BigDecimal getCoursePrice(Long courseId) {
        return coursePriceMapper.getCoursePrice(courseId);
    }

    @Autowired
    private CourseListClient courseListClient;
    @Override
    public List<CourseAndPrice> getCoursesAndPrice() {
        List<Course> courses = courseListClient.courseList();
        List<CourseAndPrice> courseAndPriceList = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course!=null){
                BigDecimal coursePrice = getCoursePrice(course.getCourseId());
                CourseAndPrice courseAndPrice = new CourseAndPrice();
                BeanUtils.copyProperties(course,courseAndPrice);//使用BeanUtils工具来将字段属性相同的拷贝到courseAndPrice中
                courseAndPrice.setPrice(coursePrice);
//                courseAndPrice.setName(course.getName());
//                courseAndPrice.setId(course.getId());
//                courseAndPrice.setCourseId(course.getCourseId());
                courseAndPriceList.add(courseAndPrice);
            }
        }
        return courseAndPriceList;
    }
}
