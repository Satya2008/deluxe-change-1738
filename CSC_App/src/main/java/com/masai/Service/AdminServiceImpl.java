package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Department;
import com.masai.Entity.Operator;
import com.masai.Exception.DepartmentException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;
import com.masai.Repository.DepartmentRepository;
import com.masai.Repository.OperatorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public Department addDepartment(Department d) throws LoginException {
        
        Department savedDepartment = departmentRepository.save(d);
        return savedDepartment;
    }

    @Override
    public Department removeDepartment(int id) throws DepartmentException, LoginException {
       
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        }
        Department department = departmentOptional.get();
        departmentRepository.delete(department);
        return department;
    }

    @Override
    public Department modifyDepartment(int id) throws DepartmentException, LoginException {
        
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        }
        Department department = departmentOptional.get();
       ;
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department findDepartmentById(int id) throws DepartmentException, LoginException {
        
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        }
        return departmentOptional.get();
    }

    @Override
    public Operator addOperator(Operator o) throws LoginException {
       
        Operator savedOperator = operatorRepository.save(o);
        return savedOperator;
    }

    @Override
    public Operator removeOperatorById(int id) throws OperatorException, LoginException {
        
        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if (!operatorOptional.isPresent()) {
            throw new OperatorException("Operator not found");
        }
        Operator operator = operatorOptional.get();
        operatorRepository.delete(operator);
        return operator;
    }

    @Override
    public Operator modifyOperator(int id) throws OperatorException, LoginException {
       
        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if (!operatorOptional.isPresent()) {
            throw new OperatorException("Operator not found");
        }
        Operator operator = operatorOptional.get();
        
        operatorRepository.save(operator);
        return operator;
    }

    @Override
    public Operator findOperatorById(int id) throws OperatorException, LoginException {
       
        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if (!operatorOptional.isPresent()) {
            throw new OperatorException("Operator not found");
        }
        return operatorOptional.get();
    }

    @Override
    public List<Operator> getAllOperators() throws LoginException {
        
        List<Operator> allOperators = operatorRepository.findAll();
        return allOperators;
    }
}
