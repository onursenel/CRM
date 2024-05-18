package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAccountRepository extends JpaRepository<BillingAccount,String> {
}
