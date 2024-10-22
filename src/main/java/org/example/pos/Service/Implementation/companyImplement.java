package org.example.pos.Service.Implementation;

import lombok.RequiredArgsConstructor;
import org.example.pos.Model.Company;
import org.example.pos.Service.CompanyService;
import org.example.pos.dto.request.CompanyRequest;
import org.example.pos.dto.response.CompanyResponse;
import org.example.pos.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class companyImplement implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompany_email(companyRequest.getCompanyEmail());
        company.setCompany_name(companyRequest.getCompanyName());
        company.setCompany_location(companyRequest.getCompanyLocation());
        company.setCompany_logo(companyRequest.getCompanyLogo());
        company.setCompany_phone_number(companyRequest.getCompanyPhoneNumber());

        Company savedCompany = companyRepository.save(company);
        return new CompanyResponse(savedCompany.getCompany_name());
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company updatedCompany = optionalCompany.get();
            updatedCompany.setCompany_email(companyRequest.getCompanyEmail());
            updatedCompany.setCompany_name(companyRequest.getCompanyName());
            updatedCompany.setCompany_location(companyRequest.getCompanyLocation());
            updatedCompany.setCompany_logo(companyRequest.getCompanyLogo());
            updatedCompany.setCompany_phone_number(companyRequest.getCompanyPhoneNumber());
            Company savedEditedCompany = companyRepository.save(updatedCompany);
            return new CompanyResponse(savedEditedCompany.getCompany_name());
        } else {
            throw new IllegalStateException("Company with ID " + id + " not found.");
        }
    }

    @Override
    public CompanyResponse deleteCompany(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            companyRepository.delete(optionalCompany.get());
            return new CompanyResponse(optionalCompany.get().getCompany_name());
        } else {
            throw new IllegalStateException("Company with ID " + id + " not found.");
        }
    }

    @Override
    public void saveSingleCompany(Company company) {

    }
}
