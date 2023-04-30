package com.EmployeeManagementSystem.EmployeeManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int empId;
    private String employeeName;
    private String employeeAddress;
    private String employeeCont;
}
