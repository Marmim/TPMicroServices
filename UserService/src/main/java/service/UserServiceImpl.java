package service;

import jakarta.transaction.Transactional;
import org.example.Repositories.UserRepo;
import org.example.dto.UserDtoRequest;
import org.example.dto.UserDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDtoResponse addUser(UserDtoRequest userDtoRequest) {
        UserDtoResponse user = new UserDtoResponse();
        user.setEmail(userDtoRequest.getEmail());
        user.setName(userDtoRequest.getName());
        return user;
    }


}