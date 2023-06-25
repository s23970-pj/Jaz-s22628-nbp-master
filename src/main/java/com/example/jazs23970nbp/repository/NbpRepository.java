package com.example.jazs23970nbp.repository;

import com.example.jazs23970nbp.models.Currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbpRepository extends JpaRepository<Currency,Integer> {
}
