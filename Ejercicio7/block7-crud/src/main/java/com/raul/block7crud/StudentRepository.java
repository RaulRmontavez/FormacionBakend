package com.raul.block7crud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
}
