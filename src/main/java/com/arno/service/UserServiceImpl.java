package com.arno.service;

import com.arno.domain.Organization;
import com.arno.domain.Token;
import com.arno.domain.User;
import com.arno.dao.OrganizationR;
import com.arno.dao.UserDao;
import com.arno.rest.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final OrganizationR organizationR;

    @Override
    public User insert(String firstname, String middlename, String lastname, Token token_id, String workingPosition, String login, String password, int organizationId) {

       Optional<Organization> organization = organizationR.findById(organizationId);

        if(organization == null){
            Organization.builder()
                    .id(organizationId).build();
        }

        User user = User.builder()
                .firstname(firstname)
                .middlename(middlename)
                .lastname(lastname)
                .token_id(token_id)
                .working_position(workingPosition)
                .login(login)
                .password(password)
                .organization_id(organization.get())
                .build();
        return userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User getById(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        return userDao.getByLoginAndPassword(login,password);
    }

}
