package com.crm.test.controller;

import com.crm.test.dto.ContactDTO;
import com.crm.test.dto.ContactDetailDTO;
import com.crm.test.dto.ContactRequestDTO;
import com.crm.test.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDTO> create(@Valid @RequestBody ContactRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contactService.saveContact(request));
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDetailDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(contactService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody ContactRequestDTO request) {
        return ResponseEntity.ok(contactService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

