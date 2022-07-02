package com.xxx.course.service.impl;

import com.xxx.course.model.entity.CoursePrice;
import com.xxx.course.service.CoursePriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CoursePriceServiceImplTest {
@Autowired
private CoursePriceService coursePriceService;
    @Test
    void selectAll() {
        List<CoursePrice> coursePrices = coursePriceService.selectAll();
        System.out.println(coursePrices);
    }
}