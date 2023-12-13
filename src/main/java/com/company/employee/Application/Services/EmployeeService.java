package com.company.employee.Application.Services;

import org.springframework.data.domain.Page;
import com.company.employee.Entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.company.employee.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.employee.Application.Interfaces.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository _employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this._employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> GetAll() {
        return _employeeRepository.findAll();
    }

    @Override
    public void Save(Employee employee) {
        this._employeeRepository.save(employee);
    }

    @Override
    public Employee GetBydId(long id) {
        Optional<Employee> optional = this._employeeRepository.findById(id);
        Employee employee;

        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }

    @Override
    public void Delete(long id) {
        this._employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this._employeeRepository.findAll(pageable);
    }
}
