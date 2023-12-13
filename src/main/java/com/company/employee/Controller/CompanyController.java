package com.company.employee.Controller;

import org.springframework.ui.Model;
import com.company.employee.Entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.company.employee.Application.Services.CompanyService;

import java.util.List;

@Controller
public class CompanyController {
    private CompanyService _companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this._companyService = companyService;
    }

    @GetMapping("/company")
    public String viewHomePage(Model model) {
        return findPaginated(1, model);
    }

    @GetMapping("/company/addCompany")
    public String addCompany(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "addCompany";
    }

    @PostMapping("/company/save-company")
    public String saveCompany(@ModelAttribute("company") Company company) {
        _companyService.Save(company);
        return "redirect:/company";
    }

    @GetMapping("/company/updateCompany/{id}")
    public String updateCompany(@PathVariable(value = "id") long id, Model model) {
        Company company = _companyService.GetBydId(id);
        model.addAttribute("company", company);
        return "updateCompany";
    }

    @GetMapping("/company/deleteCompany/{id}")
    public String deleteCompany(@PathVariable (value = "id") long id) {
        this._companyService.Delete(id);
        return "redirect:/company";
    }

    @GetMapping("/pageCompany/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Company> page = _companyService.findPaginated(pageNo, pageSize);
        List<Company> listCompanies = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listCompanies", listCompanies);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        return "company";
    }
}
