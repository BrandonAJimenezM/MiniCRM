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
@Table(name = "CONTACT")
public class Contact {

    @Id
    @Column(name = "IDCONTACT")
    private int idContact;

    @ManyToOne
    @JoinColumn(name = "IDCOMPANY")
    private Company company;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOTHERS_NAME")
    private String mothersName;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "BIRTHDAY")
    private String birthday;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

}
