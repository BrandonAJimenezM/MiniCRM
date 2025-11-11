package com.crm.test.model;

import com.crm.test.enums.Structure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Entity
@Table(name = "COMPANY")
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
    @SequenceGenerator(name = "seq_company", sequenceName = "SEQ_COMPANY", allocationSize = 1)
    @Column(name = "IDCOMPANY")
    private Integer idCompany;

    @Column(name = "EMPLOYER_IDENTIFICATION_NUMBER")
    private String employerIdentificationNumber;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "STRUCTURE")
    private Structure structure;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyLocation> locations;

}
