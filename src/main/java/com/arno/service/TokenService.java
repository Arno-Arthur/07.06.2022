package com.arno.service;


import com.arno.domain.Token;

import java.util.List;

public interface TokenService {

    Token insert(String value,
                 String expiration,
                 int userId
    );

    List<Token> getAll();

    Token getById(int id);

    void deleteById(int id);

    Integer getUserIdByToken(String value);


}
