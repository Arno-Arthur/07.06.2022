package com.arno.service;

import com.arno.domain.Call;
import com.arno.dao.CallDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CallServiceImpl implements CallService {
    private final CallDao callDao;


    @Override
    public Call insert(String editCardDate, String reason, String bcc, String firstname, String middlename,
                       String lastname, String sex, String residence, int phoneNumber) {

        Call call = Call.builder()
                .edit_card_date(editCardDate)
                .reason(reason)
                .bcc(bcc)
                .firstname(firstname)
                .middlename(middlename)
                .lastname(lastname)
                .sex(sex)
                .residence(residence)
                .phone_number(phoneNumber)
                .build();

        return callDao.save(call);
    }

    @Override
    public List<Call> getAll() {
        return callDao.findAll();
    }

    @Override
    public Call getById(int id) {
        return callDao.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        callDao.deleteById(id);
    }

    @Override
    public List<Call> getForUser(int userId) {
        return callDao.getAllForUser(userId);
    }
}
