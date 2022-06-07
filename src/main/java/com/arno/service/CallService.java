package com.arno.service;

import com.arno.domain.Call;

import java.util.List;

public interface CallService {

    Call insert( String editCardDate,
                 String reason,
                 String bcc,
                 String firstname,
                 String middlename,
                 String lastname,
                 String sex,
                 String residence,
                 int phoneNumber
    );

    List<Call> getAll();

    Call getById(int id);

    void deleteById(int id);

    List<Call> getForUser(int userId);

}
