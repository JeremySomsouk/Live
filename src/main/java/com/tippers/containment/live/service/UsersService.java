package com.tippers.containment.live.service;

import com.tippers.containment.live.controller.dto.UserDto;
import com.tippers.containment.live.controller.exception.UserNotFoundException;
import com.tippers.containment.live.mapper.UsersMapper;
import com.tippers.containment.live.repository.UsersRepository;
import com.tippers.containment.live.repository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UsersService {

    private UsersRepository usersRepository;
    private UsersMapper usersMapper;

    @Autowired
    public UsersService(UsersRepository usersRepository,
                        UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public List<UserDto> getAllUsers() {

        List<UserModel> allUsers = usersRepository.findAll();
        return allUsers.stream()
                .map(userModel -> usersMapper.toDto(userModel))
                .collect(toList());
    }

    public UserDto saveUser(UserDto newUser) {

        UserModel userModel = usersMapper.toModel(newUser);
        UserModel savedUser = usersRepository.save(userModel);
        return usersMapper.toDto(savedUser);
    }

    public UserDto findUserById(Long userId) {

        UserModel userModel = usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found : userId=%s", userId)));
        return usersMapper.toDto(userModel);
    }

    public UserDto replaceUserById(Long userId, UserDto newUser) {

        UserModel user = usersRepository.save(
                usersRepository.findById(userId)
                        .map(userModel -> {
                            userModel.setUsername(newUser.getUsername());
                            userModel.setJob(newUser.getJob());
                            userModel.setAge(newUser.getAge());
                            return userModel;
                        })
                        .orElseGet(() -> {
                            UserModel userModel = usersMapper.toModel(newUser);
                            userModel.setUserId(userId);
                            return userModel;
                        })
        );
        return usersMapper.toDto(user);
    }

    public void deleteUserById(Long userId) {
        usersRepository.deleteById(userId);
    }

    public UserDto findUserByUsername(String username) {
        UserModel user = usersRepository.getByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found with username = " + username);
        }
        return usersMapper.toDto(user);
    }
}
