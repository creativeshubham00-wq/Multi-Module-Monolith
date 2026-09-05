package com.dgshipping.educationtraining.repository;

import com.dgshipping.educationtraining.entity.TrainingCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCourseRepository extends JpaRepository<TrainingCourse, Long> {
}
