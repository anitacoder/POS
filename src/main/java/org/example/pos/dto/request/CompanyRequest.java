package org.example.pos.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {
    private String companyName;
    private String companyLocation;
    private String companyEmail;
    private String companyLogo;
    private String companyPhoneNumber;
}
