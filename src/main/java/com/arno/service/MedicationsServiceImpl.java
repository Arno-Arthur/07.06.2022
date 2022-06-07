package com.arno.service;

import com.arno.domain.Medications;
import com.arno.dao.MedicationsR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationsServiceImpl implements MedicationsService {

    private final MedicationsR medicationsR;


    @Override
    public Medications insert(String category, String name, String receipt) {
        Medications medications = Medications.builder()
                .category(category)
                .name(name)
                .receipt(receipt)
                .build();
        return medicationsR.save(medications);
    }

    @Override
    public List<Medications> getAll() {
        return medicationsR.findAll();
    }

    @Override
    public Medications getById(int id) {
        return medicationsR.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        medicationsR.deleteById(id);
    }
}
