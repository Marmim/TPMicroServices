package service;

import org.example.dto.UserDtoRequest;
import org.example.dto.UserDtoResponse;

public interface UserService {
    UserDtoResponse addUser(UserDtoRequest userDtoRequest);
}
