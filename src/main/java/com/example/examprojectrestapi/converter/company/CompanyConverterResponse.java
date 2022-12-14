package com.example.examprojectrestapi.converter.company;

import com.example.examprojectrestapi.dto.response.CompanyResponse;
import com.example.examprojectrestapi.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyConverterResponse {
    public CompanyResponse create(Company company) {
        if (company == null) return null;
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        //companyResponse.setStudent(company.getStudent());
        return companyResponse;
    }

    public List<CompanyResponse> getAll(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company c : companies) {
            companyResponses.add(create(c));
        }
        return companyResponses;
    }
}
