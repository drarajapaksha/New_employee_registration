package com.EmployeeManagementSystem.EmployeeManagementSystem.Controller;

import com.EmployeeManagementSystem.EmployeeManagementSystem.DTO.EmployeeDTO;
import com.EmployeeManagementSystem.EmployeeManagementSystem.DTO.ResponseDTO;
import com.EmployeeManagementSystem.EmployeeManagementSystem.Service.EmployeeService;
import com.EmployeeManagementSystem.EmployeeManagementSystem.Util.varList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;
    @Autowired
    public ResponseDTO responseDTO;

    @PostMapping("/saveEmpl")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String response = employeeService.saveEmployee(employeeDTO);
            if (response.equals("00")) {
                responseDTO.setCode(varList.RSP_SUCCESS);
                responseDTO.setMessage("success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (response.equals("06")) {
                responseDTO.setCode(varList.RSP_DUPLICATED);
                responseDTO.setMessage("employees are registered");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(varList.RSP_FAILED);
                responseDTO.setMessage("error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping("/updateEmpl")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String response = employeeService.updateEmployee(employeeDTO);
            if (response.equals("00")) {
                responseDTO.setCode(varList.RSP_SUCCESS);
                responseDTO.setMessage("success update");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (response.equals("01")) {
                responseDTO.setCode(varList.RSP_DUPLICATED);
                responseDTO.setMessage("employee is not registered");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(varList.RSP_FAILED);
                responseDTO.setMessage("error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception ex) {
            responseDTO.setCode(varList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity getAllEmployee(@RequestBody EmployeeDTO employeeDTO) {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployee();
        try {
            responseDTO.setCode(varList.RSP_SUCCESS);
            responseDTO.setMessage("success update");
            responseDTO.setContent(employeeDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            responseDTO.setCode(varList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    @GetMapping("/serchEmployee/{empID}")
    public ResponseEntity serchEmployee(@PathVariable int empID)
    {
        try{
            EmployeeDTO employeeDTO=employeeService.searchEmployee(empID);
            if (employeeDTO!=null)
            {
                responseDTO.setCode(varList.RSP_SUCCESS);
                responseDTO.setMessage("success ");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else {
                responseDTO.setCode(varList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Not employee available in this ID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }


        }catch (Exception ex)
        {
            responseDTO.setCode(varList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    @DeleteMapping("/deleteEmployee/{empID}")
    public ResponseEntity deleteEmployee(@PathVariable int empID)
    {
        try{
            String response=employeeService.deleteEmployee(empID);
            if (response.equals("00"))
            {
                responseDTO.setCode(varList.RSP_SUCCESS);
                responseDTO.setMessage("success ");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else {
                responseDTO.setCode(varList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Not employee available in this ID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }


        }catch (Exception ex)
        {
            responseDTO.setCode(varList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
