package com.arno.service;

import com.arno.domain.Medications;

import java.util.List;

public interface MedicationsService {

    Medications insert(
            String category,
            String name,
            String receipt
    );

    List<Medications> getAll();

    Medications getById(int id);

    void deleteById(int id);
}
