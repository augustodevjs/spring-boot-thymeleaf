package com.company.employee.Application.Services;

import com.company.employee.Entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.company.employee.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.employee.Application.Interfaces.ICompanyService;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {
    private final CompanyRepository _companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this._companyRepository = companyRepository;
    }

    @Override
    public List<Company> GetAll() {
        return this._companyRepository.findAll();
    }

    @Override
    public void Save(Company company) {
        this._companyRepository.save(company);
    }

    @Override
    public Company GetBydId(long id) {
        Optional<Company> optional = this._companyRepository.findById(id);
        Company company;

        if(optional.isPresent()) {
            company = optional.get();
        } else {
            throw new RuntimeException("Company not found");
        }

        return company;
    }

    @Override
    public void Delete(long id) {
        this._companyRepository.deleteById(id);
    }

    @Override
    public Page<Company> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this._companyRepository.findAll(pageable);
    }
}
