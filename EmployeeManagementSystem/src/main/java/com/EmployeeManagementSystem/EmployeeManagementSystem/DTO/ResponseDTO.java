package com.EmployeeManagementSystem.EmployeeManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseDTO {
    public String message;
    public String code;
    public Object content;
}
