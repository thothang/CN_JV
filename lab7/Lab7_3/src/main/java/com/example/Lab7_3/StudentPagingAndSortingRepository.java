package com.example.Lab7_3;

import com.example.Lab7_3.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student, Long> {
}
