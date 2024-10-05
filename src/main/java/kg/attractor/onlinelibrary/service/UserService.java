package kg.attractor.onlinelibrary.service;

import kg.attractor.onlinelibrary.dto.UserDto;
import kg.attractor.onlinelibrary.model.User;

public interface UserService {
    User findByReaderCardNumber(String readerCardNumber);
    String create(UserDto userDto);
}
