package com.company.employee.Controller;

import com.company.employee.Entities.Company;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import com.company.employee.Entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.employee.Application.Services.CompanyService;
import com.company.employee.Application.Services.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService _employeeService;
    private CompanyService _companyService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this._employeeService = employeeService;
        this._companyService = companyService;
    }

    @GetMapping("/employee")
    public String viewHomePage(Model model) {
        return findPaginated(1, model);
    }

    @GetMapping("/employee/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        List<Company> companies = _companyService.GetAll();
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companies);
        return "addEmployee";
    }

    @PostMapping("/employee/save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        _employeeService.Save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/updateEmployee/{id}")
    public String updateEmployee(@PathVariable(value = "id") long id, Model model) {
        Employee employee = _employeeService.GetBydId(id);
        List<Company> companies = _companyService.GetAll();
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companies);
        return "updateEmployee";
    }

    @GetMapping("/employee/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {
        this._employeeService.Delete(id);
        return "redirect:/employee";
    }

    @GetMapping("/pageEmployee/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Employee> page = _employeeService.findPaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        return "employee";
    }
}
