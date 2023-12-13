package com.company.employee.Repositories;

import com.company.employee.Entities.Company;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
