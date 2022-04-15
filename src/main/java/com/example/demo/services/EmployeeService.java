package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Employee;
import com.example.demo.repositries.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    final private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //TESTING
    public Optional<Employee> getByEmployeeId(String employeeId){
        Optional<Employee> employeeFound = employeeRepository.findByEmployeeId(employeeId);
        if(!employeeFound.isPresent()){
            throw new IllegalStateException("Employee not found with id " + employeeId);
        } else{
            return employeeFound;
        }
    }

    public Optional<Employee> getByDbId(int dbId){
        Optional<Employee> employeeFound = employeeRepository.findByDbId(dbId);
        if(!employeeFound.isPresent()){
            throw new IllegalStateException("Employee not found with database id " + dbId);
        } else{
            return employeeFound;
        }
    }

    public void addEmployee(Employee employee){

        Optional<Employee> employeeFound = employeeRepository.findEmployeeBySsn(employee.getSsn());
        if(employeeFound.isPresent()){
            throw new IllegalStateException("Employee found with identical SSN");
        } else{
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(Integer dbId){
        if(!employeeRepository.existsById(dbId)){
            throw new IllegalStateException("Database id " + dbId + " does not exist");
        } else{
            employeeRepository.deleteById(dbId);
        }
    }

    @Transactional
    public void updateEmployee(Integer dbId, Employee employee){
        Optional<Employee> existingRecord = employeeRepository.findByDbId(dbId);
        if(!existingRecord.isPresent()){
            throw new IllegalStateException("Employee not found with database id " + dbId);
        } else{
            existingRecord.get().updateEmployee(employee);
        }
    }
}
