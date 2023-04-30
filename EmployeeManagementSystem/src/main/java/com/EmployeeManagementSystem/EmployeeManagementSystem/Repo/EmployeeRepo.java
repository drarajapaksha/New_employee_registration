package com.EmployeeManagementSystem.EmployeeManagementSystem.Repo;

import com.EmployeeManagementSystem.EmployeeManagementSystem.Entiy.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {
}
