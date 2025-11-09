package com.crm.test.Repository;

import com.crm.test.model.CompanyLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Integer> {
    List<CompanyLocation> findByCompany_IdCompany(Integer companyId);
}
