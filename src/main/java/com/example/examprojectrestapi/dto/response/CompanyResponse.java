package com.example.examprojectrestapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {

    private Long id ;

    private String companyName;

    private String locatedCountry;

   // private int student;
}
