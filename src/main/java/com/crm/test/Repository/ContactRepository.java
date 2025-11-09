package com.crm.test.Repository;

import com.crm.test.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByCompany_IdCompany(Integer companyId);
}
