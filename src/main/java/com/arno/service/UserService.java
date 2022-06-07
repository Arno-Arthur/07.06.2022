package com.arno.service;

import com.arno.domain.Token;
import com.arno.domain.User;

import java.util.List;

public interface UserService {

    User insert(String firstname,
                String middlename,
                String lastname,
                Token tokenId,
                String workingPosition,
                String login,
                String password,
                int organizationId
    );

    List<User> getAll();

    User getById(int id);

    void deleteById(int id);

    User getByLoginAndPassword(String login, String password);


}
