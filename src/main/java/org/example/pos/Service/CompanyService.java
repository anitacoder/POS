package org.example.pos.Service;

import org.example.pos.Model.Company;
import org.example.pos.dto.request.CompanyRequest;
import org.example.pos.dto.response.CompanyResponse;

import java.util.List;
import java.util.Optional;

public interface CompanyService{
    CompanyResponse createCompany(CompanyRequest companyRequest);

    List<Company> getAllCompanies();

    Optional<Company> getCompanyById(Long id);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);
    CompanyResponse deleteCompany(Long id);
    public void saveSingleCompany(Company company);



}