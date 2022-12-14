package com.example.examprojectrestapi.controller;

import com.example.examprojectrestapi.dto.request.CompanyRequest;
import com.example.examprojectrestapi.dto.response.CompanyResponse;
import com.example.examprojectrestapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getAllCompany")
    public List<CompanyResponse> getAllCompany(){
        return companyService.getAllCompany();
    }

    @GetMapping("/getCompanyById/{companyId}")
    public CompanyResponse getCompanyById(@PathVariable Long companyId){
        return companyService.getCompanyById(companyId);
    }

    @PostMapping("/saveCompany")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest){
        return  companyService.saveCompany(companyRequest);
    }

    @PutMapping("/updateCompany/{companyId}")
    public CompanyResponse updateCompany(@PathVariable Long companyId,@RequestBody CompanyRequest companyRequest){
        return companyService.updateCompany(companyId, companyRequest);
    }
    @DeleteMapping("/deleteCompany/{companyId}")
    public CompanyResponse deleteCompany(@PathVariable Long companyId){
        return  companyService.deleteCompanyById(companyId);
    }
}
