package com.company.employee.Application.Interfaces;

import org.springframework.data.domain.Page;
import com.company.employee.Entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> GetAll();
    void Save(Employee employee);
    Employee GetBydId(long id);
    void Delete(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize);
}
