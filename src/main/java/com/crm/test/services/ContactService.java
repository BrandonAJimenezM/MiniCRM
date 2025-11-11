package com.crm.test.services;

import com.crm.test.Repository.CompanyRepository;
import com.crm.test.Repository.ContactRepository;
import com.crm.test.dto.CompanySimpleDTO;
import com.crm.test.dto.ContactDTO;
import com.crm.test.dto.ContactDetailDTO;
import com.crm.test.dto.ContactRequestDTO;
import com.crm.test.model.Company;
import com.crm.test.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;

    public ContactDTO saveContact(ContactRequestDTO dto) {

        Company company = companyRepository.findById(dto.idCompany())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Contact contact = new Contact();
        contact.setCompany(company);
        contact.setFirstName(dto.firstName());
        contact.setMiddleName(dto.middleName());
        contact.setLastName(dto.lastName());
        contact.setMothersName(dto.mothersName());
        contact.setNickname(dto.nickname());
        contact.setBirthday(dto.birthday());
        contact.setGender(dto.gender());
        contact.setIsActive(dto.isActive());

        Contact saved = contactRepository.save(contact);
        return toContactDTO(saved);

    }

    public List<ContactDTO> getAll() {
        return contactRepository.findAll()
                .stream()
                .map(this::toContactDTO)
                .toList();
    }

    public ContactDetailDTO getById(Integer id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        CompanySimpleDTO companyDTO = new CompanySimpleDTO(
                contact.getCompany().getIdCompany(),
                contact.getCompany().getName(),
                contact.getCompany().getEmployerIdentificationNumber()
        );

        return new ContactDetailDTO(
                contact.getIdContact(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getNickname(),
                contact.getGender(),
                contact.getIsActive(),
                companyDTO
        );
    }

    public ContactDTO update(Integer id, ContactRequestDTO dto) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        Company company = companyRepository.findById(dto.idCompany())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        contact.setCompany(company);
        contact.setFirstName(dto.firstName());
        contact.setMiddleName(dto.middleName());
        contact.setLastName(dto.lastName());
        contact.setMothersName(dto.mothersName());
        contact.setNickname(dto.nickname());
        contact.setBirthday(dto.birthday());
        contact.setGender(dto.gender());
        contact.setIsActive(dto.isActive());

        Contact saved = contactRepository.save(contact);

        return toContactDTO(saved);
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }

    private ContactDTO toContactDTO(Contact contact) {
        return new ContactDTO(
                contact.getIdContact(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getNickname(),
                contact.getGender(),
                contact.getIsActive()
        );
    }

}
