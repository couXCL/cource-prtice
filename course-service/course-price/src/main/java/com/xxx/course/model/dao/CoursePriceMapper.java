package com.xxx.course.model.dao;

import com.xxx.course.model.entity.CoursePrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface CoursePriceMapper {
    List<CoursePrice> selectAll();

    BigDecimal getCoursePrice(@Param("courseId") Long courseId);
}
