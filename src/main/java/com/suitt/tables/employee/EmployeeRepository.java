package com.suitt.tables.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
//    @Query(value = "select * from employee", nativeQuery = true)
//    List<Employee> findAll();
}
