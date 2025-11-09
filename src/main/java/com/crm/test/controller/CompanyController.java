package com.crm.test.controller;

import com.crm.test.dto.CompanyDTO;
import com.crm.test.dto.CompanyDetailDTO;
import com.crm.test.model.Company;
import com.crm.test.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/bussiness")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody @Valid CompanyDTO companyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(companyService.saveCompany(companyDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> listCompany()  {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailDTO> getCompanyById(@PathVariable Integer id) {
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(
            @PathVariable Integer id,
            @Valid @RequestBody CompanyDTO request) {
        return ResponseEntity.ok(companyService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
