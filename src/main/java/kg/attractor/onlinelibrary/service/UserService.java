package kg.attractor.onlinelibrary.service;

import kg.attractor.onlinelibrary.dto.UserDto;
import kg.attractor.onlinelibrary.dto.UserProfileDto;
import kg.attractor.onlinelibrary.model.User;

import java.util.List;

public interface UserService {
    User findByReaderCardNumber(String readerCardNumber);
    String create(UserDto userDto);

    String createAdmin(UserDto userDto);

    List<User> getAllUsers(String adminReaderCardNumber);
    UserProfileDto getUserProfile(String readerCardNumber);
}
