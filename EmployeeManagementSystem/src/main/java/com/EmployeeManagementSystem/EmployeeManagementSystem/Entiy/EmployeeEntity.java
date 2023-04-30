package com.EmployeeManagementSystem.EmployeeManagementSystem.Entiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "EmployeePersonalDetails")
public class EmployeeEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String employeeName;
    private String employeeAddress;
    private String employeeCont;
}
