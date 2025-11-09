package com.crm.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COMPANY_LOCATIONS")
public class CompanyLocation {

    @Id
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IDCOMPANY")
    private Company company;

    @Column(name = "FIRST_ADDRESS")
    private String firstAddress;

    @Column(name = "SECOND_ADDRESS")
    private String secondAddress;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "COUNTRY")
    private String country;

}
