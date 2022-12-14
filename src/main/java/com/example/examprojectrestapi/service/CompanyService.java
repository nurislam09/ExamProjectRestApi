package com.example.examprojectrestapi.service;

import com.example.examprojectrestapi.dto.request.CompanyRequest;
import com.example.examprojectrestapi.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    List<CompanyResponse> getAllCompany();

    CompanyResponse getCompanyById(Long id);

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    CompanyResponse deleteCompanyById(Long id);
}
