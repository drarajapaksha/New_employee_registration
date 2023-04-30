package com.EmployeeManagementSystem.EmployeeManagementSystem.Service;

import com.EmployeeManagementSystem.EmployeeManagementSystem.DTO.EmployeeDTO;
import com.EmployeeManagementSystem.EmployeeManagementSystem.Entiy.EmployeeEntity;
import com.EmployeeManagementSystem.EmployeeManagementSystem.Repo.EmployeeRepo;
import com.EmployeeManagementSystem.EmployeeManagementSystem.Util.varList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO) {

        if (employeeRepo.existsById(employeeDTO.getEmpId())) {
            return varList.RSP_DUPLICATED;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
            return varList.RSP_SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmpId())) {
            employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
            return varList.RSP_SUCCESS;
        } else {
            return varList.RSP_NO_DATA_FOUND;
        }
    }

   // @GetMapping("/getAllEmployee")
    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>() {


        }.getType());
    }

    public EmployeeDTO searchEmployee(int empID) {
        if (employeeRepo.existsById(empID)) {
            EmployeeEntity employeeEntity = employeeRepo.findById(empID).orElse(null);
            return modelMapper.map(employeeEntity,EmployeeDTO.class);

        } else {
            return null;
        }
    }
    public String deleteEmployee(int empID)
    {
        if (employeeRepo.existsById(empID))
        {
            employeeRepo.deleteById(empID);
            return varList.RSP_SUCCESS;
        }else
        {
            return varList.RSP_NO_DATA_FOUND;
        }

    }

}
