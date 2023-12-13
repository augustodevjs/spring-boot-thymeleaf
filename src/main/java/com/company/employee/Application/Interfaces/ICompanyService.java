package com.company.employee.Application.Interfaces;

import org.springframework.data.domain.Page;
import com.company.employee.Entities.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> GetAll();
    void Save(Company company);
    Company GetBydId(long id);
    void Delete(long id);
    Page<Company> findPaginated(int pageNo, int pageSize);
}
