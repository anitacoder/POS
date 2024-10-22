package org.example.pos.Controller;

import lombok.RequiredArgsConstructor;
import org.example.pos.Model.Company;
import org.example.pos.Service.CompanyService;
import org.example.pos.dto.request.CompanyRequest;
import org.example.pos.dto.response.CompanyResponse;
import org.example.pos.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyRepository companyRepository;

    @PostMapping("/save")
    public CompanyResponse saveCompany(@RequestBody @Validated CompanyRequest companyRequest) {
        companyService.createCompany(companyRequest);
        return new CompanyResponse(companyRequest.getCompanyName());
    }

    @GetMapping("/allCompanies")
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "companies";
    }

    @GetMapping("get/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("/update/{id}")
    public String updateCompany(@PathVariable Long id, @ModelAttribute Company company, Model model) {
        CompanyRequest companyRequest = new CompanyRequest();
        companyRequest.setCompanyName(company.getCompany_name());
        companyRequest.setCompanyEmail(company.getCompany_email());
        companyRequest.setCompanyLocation(company.getCompany_location());
        companyRequest.setCompanyLogo(company.getCompany_logo());
        companyRequest.setCompanyPhoneNumber(company.getCompany_phone_number());

        companyService.updateCompany(id, companyRequest);
        return "redirect:/register/allCompanies"; // Redirect to the list page after updating
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return "redirect:/register/allCompanies"; // Redirect to the list page after deleting
    }

    @PostMapping("/saveSingle")
    public String saveSingleCompany(@ModelAttribute Company company, Model model) {
        companyService.saveSingleCompany(company);
        model.addAttribute("addCompany", "Company saved successfully!");
        return "addCompany";  // Redirect to the companies list page after saving
    }

    @GetMapping("/addCompany")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "addCompany";  // Thymeleaf template name for the company list
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        Optional<Company> companyOptional = companyService.getCompanyById(id);
        if (companyOptional.isPresent()) {
            model.addAttribute("company", companyOptional.get());
        } else {
            // Handle the case when the company is not found
            model.addAttribute("error", "Company not found");
        }
        return "showUpdateForm";
    }
}
