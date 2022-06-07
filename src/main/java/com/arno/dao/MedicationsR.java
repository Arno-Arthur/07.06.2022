package com.arno.dao;

import com.arno.domain.Medications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationsR extends JpaRepository<Medications,Integer> {
}
