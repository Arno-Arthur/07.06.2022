package com.arno.service;

import com.arno.domain.Token;
import com.arno.domain.User;
import com.arno.dao.TokenR;
import com.arno.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenR tokenR;
    private final UserDao userDao;

    @Override
    public Token insert(String value, String expiration, int userId) {

        Optional<User> user = userDao.findById(userId);

        if(user == null){
            User.builder()
                    .id(userId).build();
        }

        Token token = Token.builder()
                .value(value)
                .expiration(expiration)
                .user(userId)
                .build();

        return tokenR.save(token);
    }

    @Override
    public List<Token> getAll() {
        return tokenR.findAll();
    }

    @Override
    public Token getById(int id) {
        return tokenR.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        tokenR.deleteById(id);
    }

    @Override
    public Integer getUserIdByToken(String value) {
        return tokenR.getTokenByValue(value).getUser();
    }
}
