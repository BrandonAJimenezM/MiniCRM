package com.crm.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact")
    @SequenceGenerator(name = "seq_contact", sequenceName = "SEQ_CONTACT", allocationSize = 1)
    @Column(name = "IDCONTACT")
    private Integer idContact;

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
    private LocalDate birthday;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

}
