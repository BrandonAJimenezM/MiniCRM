package com.crm.test.services;

import com.crm.test.Repository.CompanyLocationRepository;
import com.crm.test.Repository.CompanyRepository;
import com.crm.test.Repository.ContactRepository;
import com.crm.test.dto.CompanyDTO;
import com.crm.test.dto.CompanyDetailDTO;
import com.crm.test.dto.ContactDTO;
import com.crm.test.dto.LocationDTO;
import com.crm.test.model.Company;
import com.crm.test.model.CompanyLocation;
import com.crm.test.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyLocationRepository companyLocationRepository;
    private final ContactRepository contactRepository;

    // ✅ Crear company + ubicación
    public CompanyDTO saveCompany(CompanyDTO dto) {

        Company company = new Company();
        company.setEmployerIdentificationNumber(dto.employerIdentificationNumber());
        company.setName(dto.name());
        company.setStructure(dto.structure());
        company.setEmail(dto.email());
        company.setPhoneNumber(dto.phoneNumber());
        company.setIsActive(dto.isActive());

        Company savedCompany = companyRepository.save(company);

        CompanyLocation location = new CompanyLocation();
        location.setCompany(savedCompany);
        location.setFirstAddress(dto.location().first_address());
        location.setSecondAddress(dto.location().second_address());
        location.setCity(dto.location().city());
        location.setProvince(dto.location().province());
        location.setCountry(dto.location().country());

        companyLocationRepository.save(location);

        return toCompanyDTO(savedCompany, List.of(location));
    }

    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(company -> toCompanyDTO(company, companyLocationRepository.findByCompany_IdCompany(company.getIdCompany())))
                .toList();
    }


    public CompanyDetailDTO getById(Integer id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        List<CompanyLocation> locations = companyLocationRepository.findByCompany_IdCompany(id);
        List<Contact> contacts = contactRepository.findByCompany_IdCompany(id);

        return new CompanyDetailDTO(
                company.getIdCompany(),
                company.getEmployerIdentificationNumber(),
                company.getName(),
                company.getStructure(),
                company.getEmail(),
                company.getPhoneNumber(),
                company.getIsActive(),
                locations.stream().map(this::toLocationDTO).toList(),
                contacts.stream().map(this::toContactDTO).toList()
        );
    }

    // ✅ Actualizar empresa
    public CompanyDTO update(Integer id, CompanyDTO dto) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        company.setEmployerIdentificationNumber(dto.employerIdentificationNumber());
        company.setName(dto.name());
        company.setStructure(dto.structure());
        company.setEmail(dto.email());
        company.setPhoneNumber(dto.phoneNumber());
        company.setIsActive(dto.isActive());

        companyRepository.save(company);

        return toCompanyDTO(company, companyLocationRepository.findByCompany_IdCompany(id));
    }

    // ✅ Eliminar empresa
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }

    // ------------------ MAPPERS (entity → dto) -------------------------

    private CompanyDTO toCompanyDTO(Company company, List<CompanyLocation> locations) {
        LocationDTO locationDTO = null;
        if (!locations.isEmpty()) {
            CompanyLocation loc = locations.get(0);
            locationDTO = new LocationDTO(
                    loc.getFirstAddress(),
                    loc.getSecondAddress(),
                    loc.getCity(),
                    loc.getProvince(),
                    loc.getCountry()
            );
        }

        return new CompanyDTO(
                company.getEmployerIdentificationNumber(),
                company.getName(),
                company.getStructure(),
                company.getEmail(),
                company.getPhoneNumber(),
                company.getIsActive(),
                locationDTO
        );
    }

    private LocationDTO toLocationDTO(CompanyLocation location) {
        return new LocationDTO(
                location.getFirstAddress(),
                location.getSecondAddress(),
                location.getCity(),
                location.getProvince(),
                location.getCountry()
        );
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



